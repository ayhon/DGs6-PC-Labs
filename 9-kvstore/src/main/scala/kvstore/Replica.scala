package kvstore

import akka.actor.{ OneForOneStrategy, PoisonPill, Props, SupervisorStrategy, Terminated, ActorRef, Actor, actorRef2Scala }
import kvstore.Arbiter.*
import akka.pattern.{ ask, pipe }
import scala.concurrent.duration.*
import akka.util.Timeout
import scala.collection.mutable
import akka.actor.SupervisorStrategy.Restart
import akka.pattern.StatusReply.Success
import java.util.concurrent.atomic.AtomicLong

object Replica:
  sealed trait Operation:
    def key: String
    def id: Long
  case class Insert(key: String, value: String, id: Long) extends Operation
  case class Remove(key: String, id: Long) extends Operation
  case class Get(key: String, id: Long) extends Operation

  class ProperlyInstantiated

  sealed trait OperationReply
  case class OperationAck(id: Long) extends OperationReply
  case class OperationFailed(id: Long) extends OperationReply
  case class GetResult(key: String, valueOption: Option[String], id: Long) extends OperationReply

  def props(arbiter: ActorRef, persistenceProps: Props): Props = Props(Replica(arbiter, persistenceProps))

class Replica(val arbiter: ActorRef, persistenceProps: Props) extends Actor:
  import Replica.*
  import Replicator.*
  import Persistence.*
  import context.dispatcher

  /*
   * The contents of this actor is just a suggestion, you can implement it in any way you like.
   */
  
  var kv = Map.empty[String, String]
  // a map from secondary replicas to replicators
  var secondaries = Map.empty[ActorRef, ActorRef]
  // the current set of replicators
  var replicators = Set.empty[ActorRef]

  val instantiating_replicas = mutable.Set.empty[ActorRef]
  
  type Id = Long
  case class TransactionDetails(val sender: ActorRef, var pending: mutable.Set[ActorRef], var persisted: Boolean = false)
  var transactions: mutable.Map[Id, TransactionDetails] = mutable.Map.empty

  val persistence = context.actorOf(persistenceProps)
  val to_be_persisted: mutable.Map[Long, (ActorRef, Persist)] = mutable.Map.empty

  context.system.scheduler.scheduleAtFixedRate(0.milliseconds, 100.milliseconds){
    new Runnable(){
      def run() = for (seq, (sender,msg)) <- to_be_persisted do
        persistence ! msg
    }
  }
  
  override val supervisorStrategy = OneForOneStrategy(){
    case e: PersistenceException => Restart
  }
  
  def forward_replicators(id: Long, msg: Any) =
    replicators foreach (_ ! msg)
    transactions += id -> TransactionDetails(sender(), replicators.to(mutable.Set))
    context.system.scheduler.scheduleOnce(1.second){
      // Isn't this unsafe since we're accessing the Actor's state from inside a function? Even if I just send an OperationFailed, I need to communicate the id
      for details <- transactions.get(id)
      do  details.sender ! OperationFailed(id)
    }
  def replicate(id: Long, replicate_msg: Replicate) =
    forward_replicators(id, replicate_msg)
  def persist(id: Long, persist_msg: Persist) =
      persistence ! persist_msg
      to_be_persisted += id -> (sender(), persist_msg)
  
  arbiter ! Join
  def receive =
    case JoinedPrimary   => context.become(leader)
    case JoinedSecondary => context.become(replica(0))
    
  def common_behaviours: Receive = 
    case Get(k,id) =>
      sender() ! GetResult(k,kv.get(k),id)

  val leader: Receive =
    case Insert(k,v,id) =>
      kv += k -> v
      persist  (id, Persist(k, Some(v), id))
      replicate(id, Replicate(k, Some(v), id))

    case Remove(k,id) =>
      kv -= k
      persist  (id, Persist(k, None, id))
      replicate(id, Replicate(k, None, id))

    case Replicated(k, id) => transactions.get(id) match
      case Some(details) =>
        details.pending -= sender()       
        if (details.pending.isEmpty && details.persisted) // The operation concludes
          details.sender ! OperationAck(id)
          transactions -= id
      case None => ()

    case Replicas(replicas: Set[ActorRef]) =>
      // Handle new replicas
      val new_replicas: Set[ActorRef] = replicas -- secondaries.keySet - self
      val new_replicators = for new_replica <- new_replicas  yield context.actorOf(Replicator.props(new_replica))
      for 
        replicator <- new_replicators
      do replicator ! InitialState(kv)
        
      // Handle lost replicas
      val lost_replicas: Set[ActorRef] = secondaries.keySet -- replicas - self
      val replicators_of_lost = for replica <- lost_replicas yield secondaries(replica)
      replicators_of_lost.foreach(_ ! PoisonPill)
      // Check if removal of replicas made some tasks succeed
      val new_transactions: mutable.Map[Long, TransactionDetails]= mutable.Map.empty
      for (id, TransactionDetails(sender, pending, persisted)) <- transactions do
        pending --= replicators_of_lost
        if(pending.isEmpty && persisted)
          sender ! OperationAck(id)
        else new_transactions += id -> TransactionDetails(sender, pending, persisted)
      transactions = new_transactions

      // Update internal lists
      replicators = replicators -- replicators_of_lost ++ new_replicators
      secondaries = secondaries -- lost_replicas ++ (new_replicas zip new_replicators).toMap

    case Persisted(key, id) => transactions.get(id) match
      case Some(details) =>
        details.persisted = true
        to_be_persisted -= id
        if (details.pending.isEmpty)
          details.sender ! OperationAck(id)
          transactions -= id
      case None => ()
    case msg => common_behaviours(msg)

  def replica(next_seq: Long): Receive =
    case Snapshot(key, possible_value, seq) =>
      if (seq == next_seq)
        possible_value match
          case Some(value) => kv += key -> value
          case None        => kv -= key
        val persist_msg = Persist(key, possible_value, seq)
        persistence ! persist_msg
        to_be_persisted += seq -> (sender(), persist_msg)
        context.become(replica(seq + 1))
      if (seq < next_seq) // && !to_be_persisted.contains(seq))
        sender() ! SnapshotAck(key, seq)

    case Persisted(key, seq) => to_be_persisted.get(seq) match
      case Some(sender,_) => 
        sender ! SnapshotAck(key, seq)
        to_be_persisted -= seq
      case None => ()
    case msg => common_behaviours(msg)


