package ninety.nine

object P14 extends Problem[Any, Any] {
  val NAME = "P14"
  val DESCRIPTION = "duplicate the elements of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd),
      List('a, 'b, 'c, 'c, 'd)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    recursiveDuplicate(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    list flatMap { item => item::item::Nil }
  }

  def recursiveDuplicate[T](list: List[T]): List[T] = list match {
    case Nil => Nil
    case head::tail => head::head::recursiveDuplicate(tail)
  }
}