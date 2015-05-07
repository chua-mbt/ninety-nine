package ninety.nine.problems

object P07 extends Problem[List[Any], List[Any]] {
  val NAME = "P07"
  val DESCRIPTION = "flatten a nested list structure"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Any]*): List[Any] = {
    val list = input(0)
    recursiveFlatten(list)
  }

  def idiomaticSolution(input: List[Any]*): List[Any] = {
    // Native flatten does not directly work on Any and is not recursive on List elements
    val list = input(0)
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