package ninety.nine

object P17 extends Problem[Any, Any] {
  val NAME = "P17"
  val DESCRIPTION = "split a list into two parts"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k)),
      3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    recursiveSplit(n, list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    list.splitAt(n)
  }

  def recursiveSplit[T](n: Int, list: List[T], pre: List[T] = List.empty[T]): (List[T], List[T]) =
    list match {
      case Nil => (pre, Nil)
      case head::tail => if(P04.recursiveLength(pre) == n){
        (pre, head::tail)
      } else {
        recursiveSplit(n, tail, pre:+head)
      }
    }
}