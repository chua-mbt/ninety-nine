package ninety.nine

import scala.util.Random

object P25 extends Problem[List[Symbol], List[Symbol]] {
  val NAME = "P25"
  val DESCRIPTION = "generate a random permutation of the elements of a list"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution)
  )

  def idiomaticSolution(input: List[Symbol]*): List[Symbol] = {
    val list = input(0)
    Random.shuffle(list)
  }
}