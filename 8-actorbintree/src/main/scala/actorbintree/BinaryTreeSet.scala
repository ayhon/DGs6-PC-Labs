/**
 * Copyright (C) 2009-2013 Typesafe Inc. <http://www.typesafe.com>
 */
package actorbintree

import akka.actor.*
import scala.collection.immutable.Queue
import scala.reflect.ManifestFactory.NothingManifest

object BinaryTreeSet:

  trait Operation:
    def requester: ActorRef
    def id: Int
    def elem: Int

  trait OperationReply:
    def id: Int

  /** Request with identifier `id` to insert an element `elem` into the tree.
    * The actor at reference `requester` should be notified when this operation
    * is completed.
    */
  case class Insert(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request with identifier `id` to check whether an element `elem` is present
    * in the tree. The actor at reference `requester` should be notified when
    * this operation is completed.
    */
  case class Contains(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request with identifier `id` to remove the element `elem` from the tree.
    * The actor at reference `requester` should be notified when this operation
    * is completed.
    */
  case class Remove(requester: ActorRef, id: Int, elem: Int) extends Operation

  /** Request to perform garbage collection */
  case object GC

  /** Holds the answer to the Contains request with identifier `id`.
    * `result` is true if and only if the element is present in the tree.
    */
  case class ContainsResult(id: Int, result: Boolean) extends OperationReply

  /** Message to signal successful completion of an insert or remove operation. */
  case class OperationFinished(id: Int) extends OperationReply



class BinaryTreeSet extends Actor:
  import BinaryTreeSet.*
  import BinaryTreeNode.*

  def createRoot: ActorRef = context.actorOf(BinaryTreeNode.props(0, initiallyRemoved = true))

  var root = createRoot

  // optional (used to stash incoming operations during garbage collection)
  var pendingQueue = Queue.empty[Operation]

  // optional
  def receive = normal

  // optional
  /** Accepts `Operation` and `GC` messages. */
  val normal: Receive = {
    case GC =>
      val new_root: ActorRef = createRoot
      context.become(garbageCollecting(new_root))
      root ! CopyTo(new_root)
    case op: Operation => root ! op 
  }
      
  // optional
  /** Handles messages while garbage collection is performed.
   * `newRoot` is the root of the new binary tree where we want to copy
   * all non-removed elements into.
   */
  def garbageCollecting(newRoot: ActorRef): Receive = {
    case op: Operation => 
      pendingQueue = pendingQueue.enqueue(op)
    case CopyFinished =>
      root ! PoisonPill
      root = newRoot
      pendingQueue.foreach(root ! _)
      pendingQueue = Queue.empty
      context.become(normal)
  }


object BinaryTreeNode:
  trait Position

  case object Left extends Position
  case object Right extends Position

  case class CopyTo(treeNode: ActorRef)
  /**
   * Acknowledges that a copy has been completed. This message should be sent
   * from a node to its parent, when this node and all its children nodes have
   * finished being copied.
   */
  case object CopyFinished

  def props(elem: Int, initiallyRemoved: Boolean) = Props(classOf[BinaryTreeNode],  elem, initiallyRemoved)

class BinaryTreeNode(val elem: Int, initiallyRemoved: Boolean) extends Actor:
  import BinaryTreeNode.*
  import BinaryTreeSet.*

  var subtrees = Map[Position, ActorRef]()
  var removed = initiallyRemoved

  def get_position(elem: Int) = if elem < this.elem then Left else Right

  // optional
  def receive = normal

  // optional
  /** Handles `Operation` messages and `CopyTo` requests. */
  val normal: Receive = { 
    // case BinaryTreeSet.Operation
    case Insert(sender, id, elem) =>
      if this.elem == elem then
        // Element is already present in the tree
        removed = false // Ensure that it's not removed
        sender ! OperationFinished(id)
      else
        val position: Position = get_position(elem)
        subtrees.get(position) match
          case Some(subtree) => subtree ! Insert(sender, id, elem) 
          case None =>
            subtrees += position -> context.actorOf(BinaryTreeNode.props(elem, false))
            sender ! OperationFinished(id)

    case Remove(sender, id, elem) =>
      if this.elem == elem then
        this.removed = true
        sender ! OperationFinished(id)
      else
        val position: Position = get_position(elem)
        subtrees.get(position) match
          case Some(subtree) => subtree ! Remove(sender, id, elem)
          case None =>          sender  ! OperationFinished(id)
    
    case Contains(sender, id, elem) =>
      if this.elem == elem then
        sender ! ContainsResult(id, !removed)
      else
        val position: Position = get_position(elem)
        subtrees.get(position) match
          case Some(subtree) => subtree ! Contains(sender, id, elem)
          case None =>          sender  ! ContainsResult(id, false)
      
    case CopyTo(treeNode) => 
      if(!removed)
        treeNode ! Insert(self, 0, this.elem)
      context.become(copying(subtrees.values.toSet, removed))
      if(subtrees.size == 0 && removed)
        sender() ! CopyFinished
        self ! PoisonPill
      else 
        for (_,subtree) <- subtrees do 
          subtree ! CopyTo(treeNode)
  }

  // optional
  /** `expected` is the set of ActorRefs whose replies we are waiting for,
    * `insertConfirmed` tracks whether the copy of this node to the new tree has been confirmed.
    */
  def copying(expected: Set[ActorRef], insertConfirmed: Boolean): Receive = {
    case CopyFinished => 
      if expected.size == 1 && insertConfirmed 
      then 
        context.parent ! CopyFinished
        self ! PoisonPill
      else context.become(copying(expected - sender(), insertConfirmed))
        
    case OperationFinished(_) => 
      if expected.size == 0
      then 
        context.parent ! CopyFinished
        self ! PoisonPill
      else context.become(copying(expected, true))
  }


