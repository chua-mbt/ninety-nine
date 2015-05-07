package ninety.nine.problems

object P15 extends Problem[Any, List[Symbol]] {
  val NAME = "P15"
  val DESCRIPTION = "duplicate the elements of a list a given number of times"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: Any*): List[Symbol] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    recursiveDuplicateN(n, list)
  }

  def idiomaticSolution(input: Any*): List[Symbol] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    list flatMap { item => List.fill(n)(item) }
  }

  def recursiveDuplicateN[T](n: Int, list: List[T]): List[T] = list match {
    case Nil => Nil
    case head::tail => P12.recursiveFill(n, head)++recursiveDuplicateN(n, tail)
  }
}