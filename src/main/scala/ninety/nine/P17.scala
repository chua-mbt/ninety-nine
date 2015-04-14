package ninety.nine
/*
object P17 extends Problem[(List[Any], List[Any])] {
  val NAME = "P17"
  val DESCRIPTION = "split a list into two parts"
  val TESTCASE = List(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  val TESTOUT = (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  def recursiveSolution(input: Any*): (List[Any], List[Any]) = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    recursiveSplit(n, list)
  }

  def idiomaticSolution(input: Any*): (List[Any], List[Any]) = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
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
*/