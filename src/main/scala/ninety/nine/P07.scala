package ninety.nine

object P07 extends Problem[Any, Any] {
  val NAME = "P07"
  val DESCRIPTION = "flatten a nested list structure"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List(1, 1, 2, 3, 5, 8),
      List(List(1, 1), 2, List(3, List(5, 8)))
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Any]]
    recursiveFlatten(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    // Native flatten does not directly work on Any and is not recursive on List elements
    val list = input(0).asInstanceOf[List[Any]]
    idiomaticFlatten(list)
  }

  def recursiveFlatten(list: List[Any]): List[Any] = list match {
    case Nil => Nil
    case (head::nested)::tail => head::(recursiveFlatten(nested):::recursiveFlatten(tail))
    case head::tail => head::recursiveFlatten(tail)
  }

  def idiomaticFlatten(list: List[Any]): List[Any] = list flatMap {
    case nested: List[_] => idiomaticFlatten(nested)
    case item => List(item)
  }
}