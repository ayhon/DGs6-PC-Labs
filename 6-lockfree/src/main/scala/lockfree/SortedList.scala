package lockfree

import scala.annotation.tailrec
import scala.annotation.meta.companionClass

class SortedList extends AbstractSortedList:

  // The sentinel node at the head.
  private val _head: Node = createNode(0, None, isHead = true)

  // The first logical node is referenced by the head.
  def firstNode: Option[Node] = _head.next

  // Finds the first node whose value satisfies the predicate.
  // Returns the predecessor of the node and the node.
  def findNodeWithPrev(pred: Int => Boolean): (Node, Option[Node]) =
    @tailrec
    def traverse(prev: Node, curr: Option[Node]): (Node, Option[Node]) = curr match
      case Some(node) => 
        if node.deleted then
          // Commit the deletion
          prev.atomicState.compareAndSet((curr,false), (node.next,false))
          findNodeWithPrev(pred)
        else
          if !pred(node.value) 
          then traverse(node, node.next) 
          else (prev,curr)
      case None => (prev,curr)
    traverse(_head, firstNode)

  // Insert an element in the list.
  def insert(e: Int): Unit =
    val (prev, next_state) = findNodeWithPrev(_ > e)
    // if (next_state match
    //   case Some(next) =>
    //     next.deleted
    //   case None => false)
    //     // Delete node next_state
    //     insert(e)
    val new_state = Some(createNode(e, next_state))
    if (!prev.atomicState.compareAndSet((next_state,false), (new_state,false)))
          insert(e)

  // Checks if the list contains an element.
  def contains(e: Int): Boolean =
    val (prev, perhaps_post) = findNodeWithPrev(_ == e)
    perhaps_post match
      case Some(node) => true
      case None => false

  // Delete an element from the list.
  // Should only delete one element when multiple occurences are present.
  def delete(e: Int): Boolean = 
    val (prev, node) = findNodeWithPrev(_ == e)
    node match
      case Some(node) => if node.mark then true
                          else delete(e)
      case None => false
