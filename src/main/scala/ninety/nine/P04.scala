package ninety.nine

import scala.annotation.tailrec

object P04 extends Problem[Any, Any] {
  val NAME = "P04"
  val DESCRIPTION = "find the number of elements of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](6, List(1, 1, 2, 3, 5, 8))
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Int]]
    recursiveLength(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Int]]
    list.length
  }

  @tailrec
  def recursiveLength[T](list: List[T], accumulator: Int = 0): Int = list match {
    case Nil => accumulator
    case _::tail => recursiveLength(tail, accumulator+1)
  }
}