package ninety.nine.problems

object P17 extends Problem[Any, (List[Symbol], List[Symbol])] {
  val NAME = "P17"
  val DESCRIPTION = "split a list into two parts"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: Any*): (List[Symbol], List[Symbol]) = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    recursiveSplit(n, list)
  }

  def idiomaticSolution(input: Any*): (List[Symbol], List[Symbol]) = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    list.splitAt(n)
  }

  def recursiveSplit[T](n: Int, list: List[T], pre: List[T] = List.empty[T]): (List[T], List[T]) =
    list match {
      case Nil => (pre, Nil)
      case head::tail if(P04.recursiveLength(pre) == n) => (pre, head::tail)
      case head::tail => recursiveSplit(n, tail, pre:+head)
    }
}