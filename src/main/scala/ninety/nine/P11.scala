package ninety.nine

object P11 extends Problem[Any, Any] {
  val NAME = "P11"
  val DESCRIPTION = "generate the modified run-length encoding of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e)),
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    recursiveEncode(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    idiomaticEncode(list)
  }

  def recursiveEncode[T](list: List[T]): List[Any] = {
    def encode(list: List[List[Any]]): List[Any] = list match {
      case Nil => Nil
      case (head::Nil)::tail => head::encode(tail)
      case packed::tail => (P04.recursiveLength(packed), packed.head)::encode(tail)
    }
    encode(P09.recursivePack(list))
  }

  def idiomaticEncode[T](list: List[T]): List[Any] = list match {
    case Nil => Nil
    case items => {
      val (packed, rest) = items.span(_ == items.head)
      packed match {
        case Nil => idiomaticEncode(rest)
        case head::Nil => head::idiomaticEncode(rest)
        case head::_ => (packed.length, head)::idiomaticEncode(rest)
      }
    }
  }
}