package ninety.nine

import java.util.NoSuchElementException
import scala.annotation.tailrec

object P20 extends Problem[Any, Any] {
  val NAME = "P20"
  val DESCRIPTION = "remove the Nth element from a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      (List('a, 'c, 'd), 'b),
      1, List('a, 'b, 'c, 'd)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    recursiveRemove(n, list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    val removed = list(n)
    val remaining = list.zipWithIndex.filterNot(
      pair => pair match { case (_, idx) => idx == n }
    ).map{ _._1 }
    (remaining, removed)
  }

  @tailrec
  def recursiveRemove[T](
    n: Int, list: List[T], idx: Int = 0, accumulator: List[T] = List.empty[T]
  ): (List[T], T) = list match {
    case Nil => throw new NoSuchElementException
    case head::tail if (idx ==  n) => (P05.recursiveReverse(accumulator):::tail, head)
    case head::tail => recursiveRemove(n, tail, idx+1, head::accumulator)
  }
}