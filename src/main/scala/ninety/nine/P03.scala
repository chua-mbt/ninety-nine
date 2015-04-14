package ninety.nine

import scala.annotation.tailrec

object P03 extends Problem[Any, Any] {
  val NAME = "P03"
  val DESCRIPTION = "find the Kth element of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](2, 2, List(1, 1, 2, 3, 5, 8))
  )

  def recursiveSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Int]]
    recursiveNth(n, list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Int]]
    list(n)
  }

  @tailrec
  def recursiveNth[T](n: Int, list: List[T], idx: Int = 0): T = list match {
    case Nil => throw new java.util.NoSuchElementException()
    case item::_ if (idx == n) => item
    case _::tail => recursiveNth(n, tail, idx+1)
  }
}