package ninety.nine

import scala.annotation.tailrec

object P04 extends Problem[Any] {
  val NAME = "P04"
  val DESCRIPTION = "find the number of elements of a list"
  val TESTCASE = List(List(1, 1, 2, 3, 5, 8))
  val TESTOUT = 6

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    recursiveLength(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    list.length
  }

  @tailrec
  def recursiveLength(list: List[Any], accumulator: Int = 0): Any = list match {
    case Nil => accumulator
    case _::tail => recursiveLength(tail, accumulator+1)
  }
}
