package hazardptr

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap
import instrumentation.Monitor
import java.util.concurrent.atomic.AtomicInteger

class HazardPointer(numPointerPerThread: Int) extends AbstractHazardPointer(numPointerPerThread):

  def update(i: Int, n: Option[Node]): Unit =
    hazardPointerArray(getMyId()*numPointerPerThread + i) = n

  def get(i: Int): Option[Node] =
    hazardPointerArray(getMyId()*numPointerPerThread + i)

  def retireNode(node: Option[Node]) =
    if(maxThreads != retiredListArray.size) 
      println("HAH!")
      println(s"While the maximum number of threads is $maxThreads, there is actually only ${retiredListArray.size} slots for threads")

    val retiredList = retiredListArray(getMyId())
    retiredList += node
    if (retiredList.size > threshold)
      for pointer <- retiredList do
        if(!hazardPointerArray.contains(pointer))
          retiredList -= pointer

