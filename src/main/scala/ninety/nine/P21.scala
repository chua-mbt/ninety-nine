package ninety.nine

object P21 extends Problem[Any, Any] {
  val NAME = "P21"
  val DESCRIPTION = "insert an element at a given position into a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List('a, 'new, 'b, 'c, 'd),
      'new, 1, List('a, 'b, 'c, 'd)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val item = input(0).asInstanceOf[Symbol]
    val n = input(1).asInstanceOf[Int]
    val list = input(2).asInstanceOf[List[Any]]
    recursiveInsert(item, n, list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val item = input(0).asInstanceOf[Symbol]
    val n = input(1).asInstanceOf[Int]
    val list = input(2).asInstanceOf[List[Any]]
    val (pre, post) = list.splitAt(n)
    (pre:+item)++post
  }

  def recursiveInsert[T](item: T, n: Int, list: List[T], idx: Int = 0): List[T] = list match {
    case Nil => Nil
    case head::tail if (idx < n) => head::recursiveInsert(item, n, tail, idx+1)
    case head::tail => item::head::tail
  }
}