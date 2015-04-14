package ninety.nine

import scala.annotation.tailrec

object P06 extends Problem[Any, Any] {
  val NAME = "P06"
  val DESCRIPTION = "find out whether a list is a palindrome"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](true, List(1, 2, 3, 2, 1))
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Int]]
    P05.recursiveReverse(list) == list
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Int]]
    list.reverse == list
  }
}