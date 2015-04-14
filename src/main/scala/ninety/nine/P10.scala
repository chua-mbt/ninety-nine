package ninety.nine

object P10 extends Problem[Any, Any] {
  val NAME = "P10"
  val DESCRIPTION = "generate the run-length encoding of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomaticMap", idiomaticMapSoln),
    Solution("idiomaticSpan", idiomaticSpanSoln)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e)),
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    recursiveEncode(list)
  }

  def idiomaticMapSoln(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    mapEncode(list)
  }
  def idiomaticSpanSoln(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
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