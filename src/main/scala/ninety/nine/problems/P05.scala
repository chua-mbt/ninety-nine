package ninety.nine.problems

import scala.annotation.tailrec

object P05 extends Problem[List[Int], List[Int]] {
  val NAME = "P05"
  val DESCRIPTION = "reverse a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Int]*): List[Int] = {
    val list = input(0)
    recursiveReverse(list)
  }

  def idiomaticSolution(input: List[Int]*): List[Int] = {
    val list = input(0)
    list.reverse
  }

  @tailrec
  def recursiveReverse[T](list: List[T], accumulator: List[T] = Nil): List[T] = list match {
    case Nil => accumulator
    case head::tail => recursiveReverse(tail, head::accumulator)
  }
}