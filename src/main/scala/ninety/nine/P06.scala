package ninety.nine

import scala.annotation.tailrec

object P06 extends Problem[Boolean] {
  val NAME = "P06"
  val DESCRIPTION = "find out whether a list is a palindrome"
  val TESTCASE = List(List(1, 2, 3, 2, 1))
  val TESTOUT = true

  def recursiveSolution(input: Any*): Boolean = {
    val list = input(0).asInstanceOf[List[Any]]
    P05.recursiveReverse(list) == list
  }

  def idiomaticSolution(input: Any*): Boolean = {
    val list = input(0).asInstanceOf[List[Any]]
    list.reverse == list
  }
}
