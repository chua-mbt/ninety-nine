package ninety.nine

object P15 extends Problem[List[Any]] {
  val NAME = "P15"
  val DESCRIPTION = "duplicate the elements of a list a given number of times"
  val TESTCASE = List(3, List('a, 'b, 'c, 'c, 'd))
  val TESTOUT = List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)

  def recursiveSolution(input: Any*): List[Any] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    recursiveDuplicateN(n, list)
  }

  def idiomaticSolution(input: Any*): List[Any] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    list flatMap { item => List.fill(n)(item) }
  }

  def recursiveDuplicateN(n: Int, list: List[Any]): List[Any] = list match {
    case Nil => Nil
    case head::tail => P12.recursiveFill(n, head)++recursiveDuplicateN(n, tail)
  }
}