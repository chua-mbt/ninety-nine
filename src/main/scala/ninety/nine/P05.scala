package ninety.nine

import scala.annotation.tailrec

object P05 extends Problem[Any] {
  val NAME = "P05"
  val DESCRIPTION = "reverse a list"
  val TESTCASE = List(List(1, 1, 2, 3, 5, 8))
  val TESTOUT = List(8, 5, 3, 2, 1, 1)

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    recursiveReverse(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    list.reverse
  }

  @tailrec
  def recursiveReverse(list: List[Any], accumulator: List[Any] = Nil): Any = list match {
    case Nil => accumulator
    case head::tail => recursiveReverse(tail, head::accumulator)
  }
}