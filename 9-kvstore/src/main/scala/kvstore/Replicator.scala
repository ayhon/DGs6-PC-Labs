package kvstore

import akka.actor.Props
import akka.actor.Actor
import akka.actor.ActorRef
import akka.actor.actorRef2Scala
import scala.concurrent.duration.*

object Replicator:
  case class Replicate(key: String, valueOption: Option[String], id: Long)
  case class Replicated(key: String, id: Long)
  
  case class Snapshot(key: String, valueOption: Option[String], seq: Long)
  case class SnapshotAck(key: String, seq: Long)

  case class InitialState(kvs: Map[String, String])

  def props(replica: ActorRef): Props = Props(Replicator(replica))

class Replicator(val replica: ActorRef) extends Actor:
  import Replicator.*
  import context.dispatcher
  
  /*
   * The contents of this actor is just a suggestion, you can implement it in any way you like.
   */

  // map from sequence number to pair of sender and request
  var acks = Map.empty[Long, (ActorRef, Replicate)]
  val initial_acks = scala.collection.mutable.Set.empty[Long]
  
  var _seqCounter = 0L
  def nextSeq() =
    val ret = _seqCounter
    _seqCounter += 1
    ret

  private val resend_interval: FiniteDuration = 100.milliseconds
  private val resend_snapshots = new Runnable(){
      def run() =
        for (seq, (_, Replicate(key, possible_value, _))) <- acks do
          replica ! Snapshot(key, possible_value, seq)
    }
  private val retry_cancellable = context.system.scheduler.scheduleAtFixedRate(0.milliseconds, resend_interval)(resend_snapshots)
  
  def receive: Receive =
    case Replicate(key, possible_value, id) =>
      val seq = nextSeq()
      acks = acks + (seq -> (sender(), Replicate(key, possible_value, id)))
      replica ! Snapshot(key, possible_value, seq)

    case SnapshotAck(key, seq) => 
      if initial_acks contains seq 
      then 
        initial_acks -= seq
        acks = acks - seq
      else acks.get(seq) match
        case Some(sender, Replicate(key, possible_value, id)) =>
          sender ! Replicated(key, id)
          acks = acks - seq
        case None => ()

    case InitialState(kvs) =>
      for (key, value) <- kvs do
        val seq = nextSeq()
        initial_acks += seq
        acks = acks + (seq -> (sender(), Replicate(key, Some(value), -1)))
        replica ! Snapshot(key, Some(value), seq)
        