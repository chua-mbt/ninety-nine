package ninety.nine.problems

import scala.annotation.tailrec

object P01 extends Problem[List[Int], Int] {
  val NAME = "P01"
  val DESCRIPTION = "find the last element of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Int]*): Int = {
    val list = input(0)
    recursiveLast(list)
  }

  def idiomaticSolution(input: List[Int]*): Int = {
    val list = input(0)
    list.last
  }

  @tailrec
  def recursiveLast[T](list: List[T]): T = list match {
    case Nil => throw new java.util.NoSuchElementException()
    case last::Nil => last
    case _::tail => recursiveLast(tail)
  }
}
