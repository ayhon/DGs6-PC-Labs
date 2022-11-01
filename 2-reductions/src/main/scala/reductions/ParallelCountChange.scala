package reductions

import org.scalameter.*
import scala.annotation.tailrec
import scala.annotation.static
import scala.concurrent.duration.Duration.Infinite

object ParallelCountChangeRunner:

  @volatile var seqResult = 0

  @volatile var parResult = 0

  val standardConfig = config(
    Key.exec.minWarmupRuns := 20,
    Key.exec.maxWarmupRuns := 40,
    Key.exec.benchRuns := 80,
    Key.verbose := false
  ) withWarmer(Warmer.Default())

  def main(args: Array[String]): Unit =
    val amount = 250
    val coins = List(1, 2, 5, 10, 20, 50)
    val seqtime = standardConfig measure {
      seqResult = ParallelCountChange.countChange(amount, coins)
    }
    println(s"sequential result = $seqResult")
    println(s"sequential count time: $seqtime")

    def measureParallelCountChange(threshold: => ParallelCountChange.Threshold): Unit = try
      val fjtime = standardConfig measure {
        parResult = ParallelCountChange.parCountChange(amount, coins, threshold)
      }
      println(s"parallel result = $parResult")
      println(s"parallel count time: $fjtime")
      println(s"speedup: ${seqtime.value / fjtime.value}")
    catch
      case e: NotImplementedError =>
        println("Not implemented.")

    println("\n# Using moneyThreshold\n")
    measureParallelCountChange(ParallelCountChange.moneyThreshold(amount))
    println("\n# Using totalCoinsThreshold\n")
    measureParallelCountChange(ParallelCountChange.totalCoinsThreshold(coins.length))
    println("\n# Using combinedThreshold\n")
    measureParallelCountChange(ParallelCountChange.combinedThreshold(amount, coins))

object ParallelCountChange extends ParallelCountChangeInterface:
  type Money = Int
  type PossibleCoins = List[Int]
  type Threshold = (Money, PossibleCoins) => Boolean
  
  def countChangeMid(continue: (Money, PossibleCoins) => Int, execute: ( => Int, => Int) => (Int, Int) = (_,_))(money: Int, coins: List[Int]): Int =
    if coins.isEmpty || money < 0 then 0
    else if money == 0 then 1
    else
      val (List(coin), restCoins) = coins.splitAt(1)
      val newAmount = money - coin
      val (usingOtherCoins, usingCurrentCoin) = execute(continue(money, restCoins),  // Don't use the current coin
                                                        continue(newAmount, coins)) // Use the current coin once
      usingOtherCoins + usingCurrentCoin

  /** Returns the number of ways change can be made from the specified list of
   *  coins for the specified amount of money.
   */
  def countChange(money: Money, coins: PossibleCoins): Int =
    if money == 0 then 1
    else if coins.isEmpty || money < 0 then 0
    else
      val (List(coin), restCoins) = coins.splitAt(1)
      val newAmount = money - coin
      val (usingOtherCoins, usingCurrentCoin) = (countChange(money, restCoins),  // Don't use the current coin
                                                 countChange(newAmount, coins)) // Use the current coin once
      usingOtherCoins + usingCurrentCoin
    
  /** In parallel, counts the number of ways change can be made from the
   *  specified list of coins for the specified amount of money.
   */
  def parCountChange(money: Int, coins: List[Int], threshold: Threshold): Int = if threshold(money, coins) 
    then countChange(money, coins)
    else 
      if coins.isEmpty || money < 0 then 0
      else if money == 0 then 1
      else
        val (List(coin), restCoins) = coins.splitAt(1)
        val newAmount = money - coin
        val (usingOtherCoins, usingCurrentCoin) = parallel(parCountChange(money, restCoins, threshold),  // Don't use the current coin
                                                           parCountChange(newAmount, coins, threshold)) // Use the current coin once
        usingOtherCoins + usingCurrentCoin

  /** Threshold heuristic based on the starting money. */
  def moneyThreshold(startingMoney: Int): Threshold = (money, _) => money <= startingMoney * 2/3

  /** Threshold heuristic based on the total number of initial coins. */
  def totalCoinsThreshold(totalCoins: Int): Threshold = (_, coins) => coins.length <= totalCoins * 2/3

  /** Threshold heuristic based on the starting money and the initial list of coins. */
  def combinedThreshold(startingMoney: Int, allCoins: List[Int]): Threshold = (money, coins) => money * coins.length <= startingMoney * allCoins.length / 2
