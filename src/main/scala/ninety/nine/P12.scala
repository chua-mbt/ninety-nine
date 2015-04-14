package ninety.nine

import scala.annotation.tailrec

object P12 extends Problem[Any, Any] {
  val NAME = "P12"
  val DESCRIPTION = "decode a run-length encoded list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e),
      List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[(Int, Any)]]
    recursiveDecode(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[(Int, Any)]]
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

  def idiomaticDecode[T](list: List[T]): List[T] = list.foldLeft(List.empty[T]) {
    (decoded, encoding) => {
      val (len:Int, item:T) = encoding
      decoded++List.fill(len)(item)
    }
  }
}