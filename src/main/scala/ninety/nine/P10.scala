package ninety.nine
/*
object P10 extends Problem[List[(Int, Any)]] {
  val NAME = "P10"
  val DESCRIPTION = "generate the run-length encoding of a list"
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
    def encode(list: List[List[T]]): List[(Int, T)] = list match {
      case Nil => Nil
      case head::tail => (P04.recursiveLength(head), head.head)::encode(tail)
    }
    encode(P09.recursivePack(list))
  }

  def idiomaticEncode[T](list: List[T]): List[(Int, T)] = P09.idiomaticPack(list) map { packed =>
    (packed.length, packed.head)
  }
}
*/