package barneshut

import java.util.concurrent.*
import scala.{collection => coll}
import scala.util.DynamicVariable
import barneshut.conctrees.*

class Boundaries:
  var minX = Float.MaxValue

  var minY = Float.MaxValue

  var maxX = Float.MinValue

  var maxY = Float.MinValue

  def width = maxX - minX

  def height = maxY - minY

  def size = math.max(width, height)

  def centerX = minX + width / 2

  def centerY = minY + height / 2

  override def toString = s"Boundaries($minX, $minY, $maxX, $maxY)"

sealed abstract class Quad extends QuadInterface:
  def massX: Float

  def massY: Float

  def mass: Float

  def centerX: Float

  def centerY: Float

  def size: Float

  def total: Int

  def insert(b: Body): Quad

case class Empty(centerX: Float, centerY: Float, size: Float) extends Quad:
  def massX: Float = centerX
  def massY: Float = centerY
  def mass: Float = 0
  def total: Int = 0
  def insert(b: Body): Quad =
    Leaf(centerX, centerY, size, Seq(b))
/*
    if b.x < centerX
      then if b.y < centerY
        then Fork
      // b.y >= centerY
        else
    // b.x >= centerX
      else if b.y < centerY
        then
      // b.y >= centerY
        else
*/
case class Fork(
  nw: Quad, ne: Quad, sw: Quad, se: Quad
) extends Quad:
  private val quads: List[Quad] = List(nw, ne, sw, se)
  val centerX: Float = nw.centerX + nw.size/2 // quads.map(_.centerX).sum / 4
  val centerY: Float = nw.centerY + nw.size/2 // quads.map(_.centerY).sum / 4
  val size: Float = nw.size*2                 // quads.map(_.size).max*2
  val mass: Float = quads.map(_.mass).sum
  val massX: Float = if mass == 0 then quads.map(_.massX).sum / quads.length else quads.map(q => q.massX * q.mass).sum / mass
  val massY: Float = if mass == 0 then quads.map(_.massY).sum / quads.length else quads.map(q => q.massY * q.mass).sum / mass
  val total: Int = quads.map(_.total).sum

  def insert(b: Body): Fork =
    // assert(Math.abs(b.x - centerX) <= size/2, s"Body {b} not contained in {this}")
    // assert(Math.abs(b.y - centerY) <= size/2, s"Body {b} not contained in {this}")
    val res = if b.y <= centerY then 
      if b.x <= centerX
        then Fork(nw.insert(b),ne,sw,se)
      // b.y >= centerY
                                              else Fork(nw,ne.insert(b),sw,se)
    // b.x >= centerX
    else 
      if b.x <= centerX
        then Fork(nw,ne,sw.insert(b),se)
      // b.y >= centerY
                                              else Fork(nw,ne,sw,se.insert(b))
    res

case class Leaf(centerX: Float, centerY: Float, size: Float, bodies: coll.Seq[Body])
extends Quad:
  val mass: Float = bodies.map(_.mass).sum
  val massX: Float = bodies.map(b => b.x * b.mass).sum / mass
  val massY: Float = bodies.map(b => b.y * b.mass).sum / mass
  val total: Int = bodies.size
  def insert(b: Body): Quad =
    if size > minimumSize then 
      val empty_fork: Fork = Fork(
        Empty(centerX-size/4, centerY-size/4, size/2),
        Empty(centerX+size/4, centerY-size/4, size/2),
        Empty(centerX-size/4, centerY+size/4, size/2),
        Empty(centerX+size/4, centerY+size/4, size/2),
      ).insert(b)
      bodies.foldLeft(empty_fork)(_ insert _)
      
    else
      Leaf(centerX, centerY, size, bodies :+ b)

//Fork(Leaf(0.5,0.5,1.0,List(barneshut.Body@36adf7d4)),Leaf(1.5,0.5,1.0,List(barneshut.Body@d67ec8)),Empty(0.5,1.5,1.0),Empty(1.5,1.5,1.0))
//Fork(Leaf(0.5,0.5,1.0,List(barneshut.Body@36adf7d4)),Empty(1.5,0.5,1.0),Empty(0.5,1.5,1.0),Empty(1.5,1.5,1.0))

def minimumSize = 0.00001f

def gee: Float = 100.0f

def delta: Float = 0.01f

def theta = 0.5f

def eliminationThreshold = 0.5f

def force(m1: Float, m2: Float, dist: Float): Float = gee * m1 * m2 / (dist * dist)

def distance(x0: Float, y0: Float, x1: Float, y1: Float): Float =
  math.sqrt((x1 - x0) * (x1 - x0) + (y1 - y0) * (y1 - y0)).toFloat

class Body(val mass: Float, val x: Float, val y: Float, val xspeed: Float, val yspeed: Float):

  def updated(quad: Quad): Body =
    var netforcex = 0.0f
    var netforcey = 0.0f

    def addForce(thatMass: Float, thatMassX: Float, thatMassY: Float): Unit =
      val dist = distance(thatMassX, thatMassY, x, y)
      /* If the distance is smaller than 1f, we enter the realm of close
        * body interactions. Since we do not model them in this simplistic
        * implementation, bodies at extreme proximities get a huge acceleration,
        * and are catapulted from each other's gravitational pull at extreme
        * velocities (something like this:
        * http://en.wikipedia.org/wiki/Interplanetary_spaceflight#Gravitational_slingshot).
        * To decrease the effect of this gravitational slingshot, as a very
        * simple approximation, we ignore gravity at extreme proximities.
        */
      if dist > 1f then
        val dforce = force(mass, thatMass, dist)
        val xn = (thatMassX - x) / dist
        val yn = (thatMassY - y) / dist
        val dforcex = dforce * xn
        val dforcey = dforce * yn
        netforcex += dforcex
        netforcey += dforcey

    def traverse(quad: Quad): Unit = (quad: Quad) match
      case Empty(_, _, _) =>
        // no force
      case Leaf(_, _, _, bodies) =>
        // add force contribution of each body by calling addForce
        for b <- bodies do
          addForce(b.mass, b.x, b.y)
      case Fork(nw, ne, sw, se) =>
        // see if node is far enough from the body,
        // or recursion is needed
        if quad.size / distance(quad.massX, quad.massY, x, y) < theta then
          // Far enough from the body, consider as one object
          addForce(quad.mass, quad.massX, quad.massY)
        else
          // Not yet
          traverse(nw)
          traverse(ne)
          traverse(sw)
          traverse(se)

    traverse(quad)

    val nx = x + xspeed * delta
    val ny = y + yspeed * delta
    val nxspeed = xspeed + netforcex / mass * delta
    val nyspeed = yspeed + netforcey / mass * delta

    Body(mass, nx, ny, nxspeed, nyspeed)


val SECTOR_PRECISION = 8

class SectorMatrix(val boundaries: Boundaries, val sectorPrecision: Int) extends SectorMatrixInterface:
  val sectorSize = boundaries.size / sectorPrecision
  val matrix = new Array[ConcBuffer[Body]](sectorPrecision * sectorPrecision)
  for i <- 0 until matrix.length do matrix(i) = ConcBuffer()

  def +=(b: Body): SectorMatrix =
    def clamp(value: Int, minimum: Int, maximum: Int) =
      Math.max(minimum, Math.min(maximum, value))
    val x = clamp(((b.x - boundaries.minX) / sectorSize).toInt, 0, sectorPrecision-1)
    val y = clamp(((b.y - boundaries.minY) / sectorSize).toInt, 0, sectorPrecision-1)
    val sector = y * sectorPrecision + x
    matrix(sector) += b
    this

  def apply(x: Int, y: Int) = matrix(y * sectorPrecision + x)

  def combine(that: SectorMatrix): SectorMatrix =
    val result = SectorMatrix(boundaries, sectorPrecision)
    for i <- 0 until matrix.length do 
      result.matrix(i) = this.matrix(i) combine that.matrix(i)
    result
      

  def toQuad(parallelism: Int): Quad =
    def BALANCING_FACTOR = 4
    def quad(x: Int, y: Int, span: Int, achievedParallelism: Int): Quad =
      if span == 1 then
        val sectorSize = boundaries.size / sectorPrecision
        val centerX = boundaries.minX + x * sectorSize + sectorSize / 2
        val centerY = boundaries.minY + y * sectorSize + sectorSize / 2
        var emptyQuad: Quad = Empty(centerX, centerY, sectorSize)
        val sectorBodies = this(x, y)
        sectorBodies.foldLeft(emptyQuad)(_ insert _)
      else
        val nspan = span / 2
        val nAchievedParallelism = achievedParallelism * 4
        val (nw, ne, sw, se) =
          if parallelism > 1 && achievedParallelism < parallelism * BALANCING_FACTOR then parallel(
            quad(x, y, nspan, nAchievedParallelism),
            quad(x + nspan, y, nspan, nAchievedParallelism),
            quad(x, y + nspan, nspan, nAchievedParallelism),
            quad(x + nspan, y + nspan, nspan, nAchievedParallelism)
          ) else (
            quad(x, y, nspan, nAchievedParallelism),
            quad(x + nspan, y, nspan, nAchievedParallelism),
            quad(x, y + nspan, nspan, nAchievedParallelism),
            quad(x + nspan, y + nspan, nspan, nAchievedParallelism)
          )
        Fork(nw, ne, sw, se)

    quad(0, 0, sectorPrecision, 1)

  override def toString = s"SectorMatrix(#bodies: ${matrix.map(_.size).sum})"

class TimeStatistics:
  private val timeMap = collection.mutable.Map[String, (Double, Int)]()

  def clear() = timeMap.clear()

  def timed[T](title: String)(body: =>T): T =
    var res: T = null.asInstanceOf[T]
    val totalTime = /*measure*/
      val startTime = System.currentTimeMillis()
      res = body
      (System.currentTimeMillis() - startTime)

    timeMap.get(title) match
      case Some((total, num)) => timeMap(title) = (total + totalTime, num + 1)
      case None => timeMap(title) = (totalTime.toDouble, 1)

    println(s"$title: ${totalTime} ms; avg: ${timeMap(title)._1 / timeMap(title)._2}")
    res

  override def toString =
    timeMap map {
      case (k, (total, num)) => k + ": " + (total / num * 100).toInt / 100.0 + " ms"
    } mkString("\n")

val forkJoinPool = ForkJoinPool()

abstract class TaskScheduler:
  def schedule[T](body: => T): ForkJoinTask[T]
  def parallel[A, B](taskA: => A, taskB: => B): (A, B) =
    val right = task {
      taskB
    }
    val left = taskA
    (left, right.join())

class DefaultTaskScheduler extends TaskScheduler:
  def schedule[T](body: => T): ForkJoinTask[T] =
    val t = new RecursiveTask[T] {
      def compute = body
    }
    Thread.currentThread match
      case wt: ForkJoinWorkerThread =>
        t.fork()
      case _ =>
        forkJoinPool.execute(t)
    t

val scheduler =
  DynamicVariable[TaskScheduler](DefaultTaskScheduler())

def task[T](body: => T): ForkJoinTask[T] =
  scheduler.value.schedule(body)

def parallel[A, B](taskA: => A, taskB: => B): (A, B) =
  scheduler.value.parallel(taskA, taskB)

def parallel[A, B, C, D](taskA: => A, taskB: => B, taskC: => C, taskD: => D): (A, B, C, D) =
  val ta = task { taskA }
  val tb = task { taskB }
  val tc = task { taskC }
  val td = taskD
  (ta.join(), tb.join(), tc.join(), td)
