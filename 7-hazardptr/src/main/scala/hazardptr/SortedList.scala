package hazardptr

import scala.annotation.tailrec
import util.control.Breaks._

class SortedList extends AbstractSortedList:
  
  // The sentinel node at the head.
  val _head: Option[Node] = Option(createNode(0, None, None, isHead = true))

  // The first logical node is referenced by the head.
  def firstNode: Option[Node] = _head.get.next

  val hazardPointers = new HazardPointer(2)

  def a: Option[Node] = hazardPointers.get(0)
  def set_a(a: Option[Node]) = hazardPointers.update(0,a)
  def b: Option[Node] = hazardPointers.get(1)
  def set_b(b: Option[Node]) = hazardPointers.update(1,b)

  // Finds the first node whose value satisfies the predicate.
  // Returns the predecessor of the node and the node.
  def findNodeWithPrev(pred: Int => Boolean): (Option[Node], Option[Node]) =
    set_a(_head)     // predecessor
    while (a.get.next.isDefined)
      set_b(a.get.next)
      if (pred(b.get.value))
        return if a.get.next == b 
               then (a, b)
               else findNodeWithPrev(pred)
      set_a(b)
    return (a,None)

  //Find Nth Node after current element. Return 0 if out of bounds.
  def getNthNext(e: Int, n: Int): Int = 
    findNodeWithPrev(_ == e) // Stores those nodes in hazardPointers
    var i: Int = 0
    while(i < n && b.get.next.isDefined)
      set_b(b.get.next)
      i+=1
    if i == n then b.get.value else 0
    

  // Count occurrence of the element.
  def countOccurrences(e: Int): Int =
    set_a(_head)
    var count: Int = 0
    while (a.get.next.isDefined)
      set_b(a.get.next)
      if (b.get.value == e)
        if(a.get.next == b) 
          count += 1
        else
          return countOccurrences(e)
      set_a(b)
    count

  // Insert an element in the list.
  def insert(e: Int): Unit = synchronized {
    val (predecessor, current) = findNodeWithPrev(_ >= e)
    val n: Option[Node] = Some(createNode(e,current,predecessor,isHead=false))
    predecessor.get.next = n
    if(current.isDefined)
      current.get.prev = n
  }

  // Checks if the list contains an element.
  def contains(e: Int): Boolean = findNodeWithPrev(_ == e)._2.isDefined

  // Delete an element from the list.
  // Should only delete one element when multiple occurrences are present.
  def delete(e: Int): Boolean = synchronized {
    val (predecessor, current) = findNodeWithPrev(_ == e)
    if current.isDefined then
      val next = current.get.next
      predecessor.get.next = next
      if(next.isDefined)
        next.get.prev = predecessor
      hazardPointers.retireNode(current)
      true
    else false
  }
