package ninety.nine.problems

object P21 extends Problem[Any, List[Symbol]] {
  val NAME = "P21"
  val DESCRIPTION = "insert an element at a given position into a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: Any*): List[Symbol] = {
    val item = input(0).asInstanceOf[Symbol]
    val n = input(1).asInstanceOf[Int]
    val list = input(2).asInstanceOf[List[Symbol]]
    recursiveInsert(item, n, list)
  }

  def idiomaticSolution(input: Any*): List[Symbol] = {
    val item = input(0).asInstanceOf[Symbol]
    val n = input(1).asInstanceOf[Int]
    val list = input(2).asInstanceOf[List[Symbol]]
    val (pre, post) = list.splitAt(n)
    (pre:+item)++post
  }

  def recursiveInsert[T](item: T, n: Int, list: List[T], idx: Int = 0): List[T] = list match {
    case Nil => Nil
    case head::tail if (idx < n) => head::recursiveInsert(item, n, tail, idx+1)
    case head::tail => item::head::tail
  }
}