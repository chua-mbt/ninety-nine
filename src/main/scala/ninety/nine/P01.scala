package ninety.nine

import scala.annotation.tailrec

object P01 extends Problem[Any, Any] {
  val NAME = "P01"
  val DESCRIPTION = "find the last element of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](8, List(1, 1, 2, 3, 5, 8))
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Int]]
    recursiveLast(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Int]]
    list.last
  }

  @tailrec
  def recursiveLast[T](list: List[T]): T = list match {
    case Nil => throw new java.util.NoSuchElementException()
    case last::Nil => last
    case _::tail => recursiveLast(tail)
  }
}
