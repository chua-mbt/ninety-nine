package ninety.nine

object P14 extends Problem[List[Any]] {
  val NAME = "P14"
  val DESCRIPTION = "duplicate the elements of a list"
  val TESTCASE = List(List('a, 'b, 'c, 'c, 'd))
  val TESTOUT = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)

  def recursiveSolution(input: Any*): List[Any] = {
    val list = input(0).asInstanceOf[List[Any]]
    recursiveDuplicate(list)
  }

  def idiomaticSolution(input: Any*): List[Any] = {
    val list = input(0).asInstanceOf[List[Any]]
    list flatMap { item => item::item::Nil }
  }

  def recursiveDuplicate(list: List[Any]): List[Any] = list match {
    case Nil => Nil
    case head::tail => head::head::recursiveDuplicate(tail)
  }
}