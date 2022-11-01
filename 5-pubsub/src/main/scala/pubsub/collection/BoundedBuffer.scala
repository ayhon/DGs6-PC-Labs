package pubsub.collection

class BoundedBuffer[T](size: Int) extends AbstractBoundedBuffer[T](size):

  // You have at your disposition the following two variables:
  // - count : Int
  // - head : Int
  // In addition, you have access to an array-like internal buffer:
  // - buffer
  // You can access elements of this buffer using:
  // - buffer(i)
  // Similarly, you can set elements using:
  // - buffer(i) = e
  //
  // You do not need to create those variables yourself!
  // They are inherited from the AbstractBoundedBuffer class.

  override def put(e: T): Unit = synchronized {
    while isFull do wait()
    // if (isFull) then
    //   println("Hey! Buffer is full")
    // else
    buffer(tail) = e
    count += 1
    notifyAll()
  }

  override def take(): T = synchronized {
    while isEmpty do wait()
    // if (isEmpty)
    //   throw Error()
    // else
    val e: T = buffer(head)
    count -= 1
    head = (head + 1) % buffer.size
    notifyAll(); e
  }

  def tail: Int = (head + count) % (buffer.size)
  def isEmpty: Boolean = count == 0
  def isFull: Boolean = count == buffer.size

  // You may want to add methods to:
  // - check whether the buffer is empty
  // - check whether the buffer is full
  // - get the index of tail
