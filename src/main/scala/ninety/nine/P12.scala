package ninety.nine

import scala.annotation.tailrec

object P12 extends Problem[List[Any]] {
  val NAME = "P12"
  val DESCRIPTION = "decode a run-length encoded list"
  val TESTCASE = List(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
  val TESTOUT = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)

  def recursiveSolution(input: Any*): List[Any] = {
    val list = input(0).asInstanceOf[List[(Int, Any)]]
    recursiveDecode(list)
  }

  def idiomaticSolution(input: Any*): List[Any] = {
    val list = input(0).asInstanceOf[List[(Int, Any)]]
    idiomaticDecode(list)
  }

  @tailrec
  def recursiveFill[T](count: Int, item: T, accumulator: List[T] = List[T]()): List[T] = count match {
    case 0 => accumulator
    case _ => recursiveFill(count-1, item, item::accumulator)
  }

  def recursiveDecode(list: List[(Int, Any)]): List[Any] = list match {
    case Nil => Nil
    case (count, item)::tail => recursiveFill(count, item)++recursiveDecode(tail)
  }

  def idiomaticDecode(list: List[Any]): List[Any] = list.foldLeft(List.empty[Any]) {
    (decoded, encoding) => {
      val (len:Int, item) = encoding
      decoded++List.fill(len)(item)
    }
  }
}