package ninety.nine

import scala.util.Random

object P23 extends Problem[Any, List[Symbol]] {
  val NAME = "P23"
  val DESCRIPTION = "extract a given number of randomly selected elements from a list"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution)
  )

  def idiomaticSolution(input: Any*): List[Symbol] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    Random.shuffle(list).take(n)
  }
}