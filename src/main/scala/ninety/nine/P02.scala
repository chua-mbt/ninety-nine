package ninety.nine

import scala.annotation.tailrec

object P02 extends Problem[Any] {
  val NAME = "P02"
  val DESCRIPTION = "find the last but one element of a list"
  val TESTCASE = List(List(1, 1, 2, 3, 5, 8))
  val TESTOUT = 5

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    recursivePenultimate(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    list.dropRight(1).last
  }

  @tailrec
  def recursivePenultimate(list: List[Any]): Any = list match {
    case _::Nil | Nil => throw new java.util.NoSuchElementException()
    case penultimate::_::Nil => penultimate
    case _::tail => recursivePenultimate(tail)
  }
}