package ninety.nine.problems

import scala.annotation.tailrec

object P02 extends Problem[List[Int], Int] {
  val NAME = "P02"
  val DESCRIPTION = "find the last but one element of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Int]*): Int = {
    val list = input(0)
    recursivePenultimate(list)
  }

  def idiomaticSolution(input: List[Int]*): Int = {
    val list = input(0)
    list.dropRight(1).last
  }

  @tailrec
  def recursivePenultimate[T](list: List[T]): T = list match {
    case _::Nil | Nil => throw new java.util.NoSuchElementException()
    case penultimate::_::Nil => penultimate
    case _::tail => recursivePenultimate(tail)
  }
}