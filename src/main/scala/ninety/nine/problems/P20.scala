package ninety.nine.problems

import java.util.NoSuchElementException
import scala.annotation.tailrec

object P20 extends Problem[Any, (List[Symbol], Symbol)] {
  val NAME = "P20"
  val DESCRIPTION = "remove the Nth element from a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: Any*): (List[Symbol], Symbol) = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    recursiveRemove(n, list)
  }

  def idiomaticSolution(input: Any*): (List[Symbol], Symbol) = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
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