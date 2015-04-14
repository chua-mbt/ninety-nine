package ninety.nine

import scala.annotation.tailrec
/*
object P22 extends Problem[List[Int]] {
  val NAME = "P22"
  val DESCRIPTION = "create a list containing all integers within a given range"
  val TESTCASE = List(4, 9)
  val TESTOUT = List(4, 5, 6, 7, 8, 9)

  def recursiveSolution(input: Any*): List[Int] = {
    val start = input(0).asInstanceOf[Int]
    val end = input(1).asInstanceOf[Int]
    recursiveRange(start, end)
  }

  def idiomaticSolution(input: Any*): List[Int] = {
    val start = input(0).asInstanceOf[Int]
    val end = input(1).asInstanceOf[Int]
    List.range(start, end+1)
  }

  def recursiveRange(start: Int, end: Int): List[Int] = {
    @tailrec
    def range(
      start: Int, end: Int, ctr: Int,
      accumulator: List[Int] = List.empty[Int]
    ): List[Int] = if(ctr > end){
      P05.recursiveReverse(accumulator)
    }else{
      range(start, end, ctr+1, ctr::accumulator)
    }
    range(start, end, start)
  }
}
*/