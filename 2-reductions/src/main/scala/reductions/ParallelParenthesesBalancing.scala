package reductions

import scala.annotation.*
import org.scalameter.*

object ParallelParenthesesBalancingRunner:

  @volatile var seqResult = false

  @volatile var parResult = false

  val standardConfig = config(
    Key.exec.minWarmupRuns := 40,
    Key.exec.maxWarmupRuns := 80,
    Key.exec.benchRuns := 120,
    Key.verbose := false
  ) withWarmer(Warmer.Default())

  def main(args: Array[String]): Unit =
    val length = 100000000
    val chars = new Array[Char](length)
    val threshold = 10000
    val seqtime = standardConfig measure {
      seqResult = ParallelParenthesesBalancing.balance(chars)
    }
    println(s"sequential result = $seqResult")
    println(s"sequential balancing time: $seqtime")

    val fjtime = standardConfig measure {
      parResult = ParallelParenthesesBalancing.parBalance(chars, threshold)
    }
    println(s"parallel result = $parResult")
    println(s"parallel balancing time: $fjtime")
    println(s"speedup: ${seqtime.value / fjtime.value}")

object ParallelParenthesesBalancing extends ParallelParenthesesBalancingInterface:
  // def openClose(chars: Array[Char]): (Int, Int) =
  //   var open: Int = 0
  //   var closed: Int = 0
  //   for char <- chars do {
  //     open = char match {
  //       case '(' => open + 1
  //       case ')' => open - 1
  //       case _ => open
  //     }
  //     if (open < 0)
  //       open = 0
  //       closed += 1
  //   }
  //   (open, closed)

  /** Returns `true` iff the parentheses in the input `chars` are balanced.
   */
  def balance(chars: Array[Char]): Boolean = 
    // val (open, closed) = openClose(chars)
    // open == 0 && closed == 0
    var open: Int = 0
    for char <- chars do {
      open = char match {
        case '(' => open + 1
        case ')' => open - 1
        case _ => open
      }
      if (open < 0)
        return false
    }
    open == 0

  // def parOpenClose(chars: Array[Char], threshold: Int): (Int, Int) =
  //   if chars.length <= threshold then
  //     openClose(chars)
  //   else
  //     val (lhs, rhs) = chars.splitAt(chars.length/2)
  //     val ((inner_open, outer_closed), (outer_open, inner_closed)) = parallel(
  //       parOpenClose(lhs, threshold),
  //       parOpenClose(rhs, threshold)
  //     )
  //     val open   = outer_open   + (if inner_open > inner_closed then inner_open - inner_closed else 0)
  //     val closed = outer_closed + (if inner_open < inner_closed then inner_closed - inner_open else 0)
  //     (open, closed)

  /** Returns `true` iff the parentheses in the input `chars` are balanced.
   */
  def parBalance(chars: Array[Char], threshold: Int): Boolean =
    // val (open, closed) = parOpenClose(chars)
    // open == 0 && closed == 0
    @tailrec
    def traverse(idx: Int, until: Int, open: Int = 0, closed: Int = 0): (Int, Int) = 
      if idx < until then chars(idx) match
        case '(' => traverse(idx+1, until, open+1, closed)
        case ')' => if open == 0 
                    then traverse(idx+1, until, open, closed+1)
                    else traverse(idx+1, until, open-1, closed)
        case  _  => traverse(idx+1, until, open, closed)
      else (closed,open)
      
    def reduce(from: Int, to: Int): (Int, Int) = if (to-from) <= threshold
        then traverse(from, to)
        else
          val mid = (from + to)/2
          val ((outer_closed, inner_open), (inner_closed,  outer_open)) =
            parallel(reduce(from, mid), reduce(mid, to))
          val open = outer_open + Math.max(0, inner_open - inner_closed)
          val closed = outer_closed + Math.max(0, inner_closed - inner_open)
          (closed, open)
        
    reduce(0, chars.length) == (0,0)

  // For those who want more:
  // Prove that your reduction operator is associative!

