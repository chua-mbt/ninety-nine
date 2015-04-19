package ninety.nine

import scala.annotation.tailrec

object P04 extends Problem[List[Int], Int] {
  val NAME = "P04"
  val DESCRIPTION = "find the number of elements of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Int]*): Int = {
    val list = input(0)
    recursiveLength(list)
  }

  def idiomaticSolution(input: List[Int]*): Int = {
    val list = input(0)
    list.length
  }

  @tailrec
  def recursiveLength[T](list: List[T], accumulator: Int = 0): Int = list match {
    case Nil => accumulator
    case _::tail => recursiveLength(tail, accumulator+1)
  }
}