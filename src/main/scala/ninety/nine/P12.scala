package ninety.nine

import scala.annotation.tailrec

object P12 extends Problem[List[(Int, Symbol)], List[Symbol]] {
  val NAME = "P12"
  val DESCRIPTION = "decode a run-length encoded list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[(Int, Symbol)]*): List[Symbol] = {
    val list = input(0)
    recursiveDecode(list)
  }

  def idiomaticSolution(input: List[(Int, Symbol)]*): List[Symbol] = {
    val list = input(0)
    idiomaticDecode(list)
  }

  @tailrec
  def recursiveFill[T](count: Int, item: T, accumulator: List[T] = List[T]()): List[T] = count match {
    case 0 => accumulator
    case _ => recursiveFill(count-1, item, item::accumulator)
  }

  def recursiveDecode[T](list: List[(Int, T)]): List[T] = list match {
    case Nil => Nil
    case (count, item)::tail => recursiveFill(count, item)++recursiveDecode(tail)
  }

  def idiomaticDecode[T](list: List[(Int, T)]): List[T] = list.foldLeft(List.empty[T]) {
    (decoded, encoding) => {
      val (len:Int, item:T) = encoding
      decoded++List.fill(len)(item)
    }
  }
}