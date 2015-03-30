package ninety.nine

import scala.annotation.tailrec

object P01 extends Problem[Any] {
  val NAME = "P01"
  val DESCRIPTION = "find the last element of a list"
  val TESTCASE = List(List(1, 1, 2, 3, 5, 8))
  val TESTOUT = 8

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    recursiveLast(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    list.last
  }

  @tailrec
  def recursiveLast(list: List[Any]): Any = list match {
    case Nil => throw new java.util.NoSuchElementException()
    case last::Nil => last
    case _::tail => recursiveLast(tail)
  }
}
