package ninety.nine

object P18 extends Problem[Any, Any] {
  val NAME = "P18"
  val DESCRIPTION = "extract a slice from a list"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List('d, 'e, 'f, 'g),
      3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val start = input(0).asInstanceOf[Int]
    val end = input(1).asInstanceOf[Int]
    val list = input(2).asInstanceOf[List[Symbol]]
    recursiveSlice(start, end, list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val start = input(0).asInstanceOf[Int]
    val end = input(1).asInstanceOf[Int]
    val list = input(2).asInstanceOf[List[Symbol]]
    list.slice(start, end)
  }

  def recursiveSlice[T](
    start: Int, end: Int, list: List[T],
    preCtr: Int = 0,
    postCtr: Int = 0
  ): List[T] =
    (preCtr, postCtr, list) match {
      case (_, _, Nil) => Nil
      case (pre, post, head::tail) if(pre < start) =>
        recursiveSlice(start, end, tail, pre+1, post)
      case (pre, post, head::tail) if(pre+post < end) =>
        head::recursiveSlice(start, end, tail, pre, post+1)
      case (pre, post, head::tail) => Nil
    }
}