package ninety.nine

import scala.annotation.tailrec

object P05 extends Problem[Any, Any] {
  val NAME = "P05"
  val DESCRIPTION = "reverse a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List(8, 5, 3, 2, 1, 1),
      List(1, 1, 2, 3, 5, 8)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Int]]
    recursiveReverse(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Int]]
    list.reverse
  }

  @tailrec
  def recursiveReverse[T](list: List[T], accumulator: List[T] = Nil): List[T] = list match {
    case Nil => accumulator
    case head::tail => recursiveReverse(tail, head::accumulator)
  }
}