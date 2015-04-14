package ninety.nine
/*
object P20 extends Problem[List[Any]] {
  val NAME = "P20"
  val DESCRIPTION = "remove the Nth element from a list"
  val TESTCASE = List(1, List('a, 'b, 'c, 'd))
  val TESTOUT = (List('a, 'c, 'd), 'b)

  def recursiveSolution(input: Any*): List[Any] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    val recursiveRemove(n, list)
  }

  def idiomaticSolution(input: Any*): List[Any] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    val removed = list(n)
    val remaining = list.zipWithIndex.filterNot((_, idx) => idx == n)
    (remaining, removed)
  }

  def recursiveRemove[T](n: Int, list: List[T], pre: List[T] = List.empty[T]): (List[T], T) =
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