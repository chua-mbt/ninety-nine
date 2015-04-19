package ninety.nine

import scala.annotation.tailrec

object P06 extends Problem[List[Int], Boolean] {
  val NAME = "P06"
  val DESCRIPTION = "find out whether a list is a palindrome"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Int]*): Boolean = {
    val list = input(0)
    P05.recursiveReverse(list) == list
  }

  def idiomaticSolution(input: List[Int]*): Boolean = {
    val list = input(0)
    list.reverse == list
  }
}