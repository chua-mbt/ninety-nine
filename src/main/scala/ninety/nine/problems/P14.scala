package ninety.nine.problems

object P14 extends Problem[List[Symbol], List[Symbol]] {
  val NAME = "P14"
  val DESCRIPTION = "duplicate the elements of a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Symbol]*): List[Symbol] = {
    val list = input(0)
    recursiveDuplicate(list)
  }

  def idiomaticSolution(input: List[Symbol]*): List[Symbol] = {
    val list = input(0)
    list flatMap { item => item::item::Nil }
  }

  def recursiveDuplicate[T](list: List[T]): List[T] = list match {
    case Nil => Nil
    case head::tail => head::head::recursiveDuplicate(tail)
  }
}