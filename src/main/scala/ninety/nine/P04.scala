package ninety.nine

import scala.annotation.tailrec
/*
object P04 extends Problem[Int] {
  val NAME = "P04"
  val DESCRIPTION = "find the number of elements of a list"
  val TESTCASE = List(List(1, 1, 2, 3, 5, 8))
  val TESTOUT = 6

  def recursiveSolution(input: Any*): Int = {
    val list = input(0).asInstanceOf[List[Any]]
    recursiveLength(list)
  }

  def idiomaticSolution(input: Any*): Int = {
    val list = input(0).asInstanceOf[List[Any]]
    list.length
  }

  @tailrec
  def recursiveLength[T](list: List[T], accumulator: Int = 0): Int = list match {
    case Nil => accumulator
    case _::tail => recursiveLength(tail, accumulator+1)
  }
}
*/