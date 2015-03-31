package ninety.nine

import scala.annotation.tailrec

object P03 extends Problem[Any] {
  val NAME = "P03"
  val DESCRIPTION = "find the Kth element of a list"
  val TESTCASE = List(2, List(1, 1, 2, 3, 5, 8))
  val TESTOUT = 2

  def recursiveSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    recursiveNth(n, list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    list(n)
  }

  @tailrec
  def recursiveNth(n: Int, list: List[Any], idx: Int = 0): Any = list match {
    case Nil => throw new java.util.NoSuchElementException()
    case item::_ if (idx == n) => item
    case _::tail => recursiveNth(n, tail, idx+1)
  }
}