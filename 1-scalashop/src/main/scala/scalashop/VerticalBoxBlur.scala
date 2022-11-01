package scalashop

import org.scalameter.*

object VerticalBoxBlurRunner:

  val standardConfig = config(
    Key.exec.minWarmupRuns := 5,
    Key.exec.maxWarmupRuns := 10,
    Key.exec.benchRuns := 10,
    Key.verbose := true
  ) withWarmer(Warmer.Default())

  def main(args: Array[String]): Unit =
    val radius = 3
    val width = 1920
    val height = 1080
    val src = Img(width, height)
    val dst = Img(width, height)
    val seqtime = standardConfig measure {
      VerticalBoxBlur.blur(src, dst, 0, width, radius)
    }
    println(s"sequential blur time: $seqtime")

    val numTasks = 32
    val partime = standardConfig measure {
      VerticalBoxBlur.parBlur(src, dst, numTasks, radius)
    }
    println(s"fork/join blur time: $partime")
    println(s"speedup: ${seqtime.value / partime.value}")


/** A simple, trivially parallelizable computation. */
object VerticalBoxBlur extends VerticalBoxBlurInterface:

  /** Blurs the columns of the source image `src` into the destination image
   *  `dst`, starting with `from` and ending with `end` (non-inclusive).
   *
   *  Within each column, `blur` traverses the pixels by going from top to
   *  bottom.
   */
  def blur(src: Img, dst: Img, from: Int, end: Int, radius: Int): Unit =
    val top = 0
    val bottom = Math.min(src.height, dst.height) 
    for
      x <- from until end
      y <- top until bottom
    do dst.update(x,y, boxBlurKernel(src, x, y, radius))

  /** Blurs the columns of the source image in parallel using `numTasks` tasks.
   *
   *  Parallelization is done by stripping the source image `src` into
   *  `numTasks` separate strips, where each strip is composed of some number of
   *  columns.
   */
  def parBlur(src: Img, dst: Img, numTasks: Int, radius: Int): Unit =
    def getBreakingPoints(start: Int, stop: Int, n: Int = 1): List[Int] =
      val span = (stop - start)
      val step = span / n
      val spares = span % n
      val pointAfterSpares = start + (step + 1) * spares
      val firstPart = (start until pointAfterSpares by (step + 1))
      if step == 0 then
        (firstPart ++ List(pointAfterSpares)).toList
      else
        val secondPart = (pointAfterSpares to stop by step)
        (firstPart ++ secondPart).toList
    def getIntervals(start: Int, stop: Int, n: Int = 1): List[(Int, Int)] =
      val breakpoints = getBreakingPoints(start, stop, n)
      breakpoints.zip(breakpoints.tail)
    val ini = 0
    val fin = Math.min(src.width, dst.width)
    val intervals = getIntervals(ini, fin, numTasks)
    val tasks = (for
                  (from, end) <- intervals
                yield task { blur(src, dst, from, end, radius)})
    tasks.foreach(_.join)


