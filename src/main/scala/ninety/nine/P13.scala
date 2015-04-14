package ninety.nine
/*
object P13 extends Problem[List[(Int, Any)]] {
  val NAME = "P13"
  val DESCRIPTION = "directly generate the run-length encoding of a list"
  val TESTCASE = List(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  val TESTOUT = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  def recursiveSolution(input: Any*): List[(Int, Any)] = {
    val list = input(0).asInstanceOf[List[Any]]
    recursiveEncode(list)
  }

  def idiomaticSolution(input: Any*): List[(Int, Any)] = {
    val list = input(0).asInstanceOf[List[Any]]
    idiomaticEncode(list)
  }

  def recursiveEncode[T](list: List[T]): List[(Int, T)] = {
    // Skipped, already implemented this correctly in P10
    P10.recursiveEncode(list)
  }

  // Alternative idiomatic solution to encoding problem using span
  def idiomaticEncode[T](list: List[T]): List[(Int, T)] = list match {
    case Nil => Nil
    case items => {
      val (packed, rest) = items.span(_ == items.head)
      (packed.length, packed.head)::idiomaticEncode(rest)
    }
  }
}
*/