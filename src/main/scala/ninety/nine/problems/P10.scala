package ninety.nine.problems

object P10 extends Problem[List[Symbol], List[(Int, Symbol)]] {
  val NAME = "P10"
  val DESCRIPTION = "generate the run-length encoding of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomaticMap", idiomaticMapSoln),
    Solution("idiomaticSpan", idiomaticSpanSoln)
  )

  def recursiveSolution(input: List[Symbol]*): List[(Int, Symbol)] = {
    val list = input(0)
    recursiveEncode(list)
  }

  def idiomaticMapSoln(input: List[Symbol]*): List[(Int, Symbol)] = {
    val list = input(0)
    mapEncode(list)
  }

  def idiomaticSpanSoln(input: List[Symbol]*): List[(Int, Symbol)] = {
    val list = input(0)
    spanEncode(list)
  }

  def recursiveEncode[T](list: List[T]): List[(Int, T)] = {
    def encode(list: List[List[T]]): List[(Int, T)] = list match {
      case Nil => Nil
      case head::tail => (P04.recursiveLength(head), head.head)::encode(tail)
    }
    encode(P09.recursivePack(list))
  }

  def mapEncode[T](list: List[T]): List[(Int, T)] = P09.idiomaticPack(list) map { packed =>
    (packed.length, packed.head)
  }

  def spanEncode[T](list: List[T]): List[(Int, T)] = list match {
    case Nil => Nil
    case items => {
      val (packed, rest) = items.span(_ == items.head)
      (packed.length, packed.head)::spanEncode(rest)
    }
  }
}