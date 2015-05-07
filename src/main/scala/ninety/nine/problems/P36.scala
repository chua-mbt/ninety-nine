package ninety.nine.problems

import scala.collection.mutable.ArrayBuffer

object P36 extends Problem[Int, List[(Int, Int)]] {
  val NAME = "P36"
  val DESCRIPTION = "determine the prime factors of a given positive integer (2)"

  val solutions = Set(
    Solution("reused", reusedSolution)
  )

  def reusedSolution(input: Int*): List[(Int, Int)] = {
    val num = input(0)
    import P35.S99Int.int2S99Int
    P10.spanEncode(num.primeFactorsSieve).map{ _.swap }
  }
}
