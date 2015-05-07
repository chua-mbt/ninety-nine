package ninety.nine.problems

import scala.util.Random

object P24 extends Problem[Int, List[Int]] {
  val NAME = "P24"
  val DESCRIPTION = "draw N different random numbers from the set 1..M"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution)
  )

  def idiomaticSolution(input: Int*): List[Int] = {
    val n = input(0)
    val m = input(1)
    Random.shuffle(List.range(1, m+1)).take(n)
  }
}