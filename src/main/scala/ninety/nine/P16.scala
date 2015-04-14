package ninety.nine
/*
object P16 extends Problem[List[Any]] {
  val NAME = "P16"
  val DESCRIPTION = "drop every Nth element from a list"
  val TESTCASE = List(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  val TESTOUT = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)

  def recursiveSolution(input: Any*): List[Any] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    recursiveDrop(n, list)
  }

  def idiomaticSolution(input: Any*): List[Any] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    idiomaticDrop(n, list)
  }

  def recursiveDrop[T](n: Int, list: List[T]): List[T] = {
    def drop(n: Int, list: List[T], ctr: Int): List[T] = (ctr, list) match {
      case (_, Nil) => Nil
      case (1, head::tail) => drop(n, tail, n)
      case (_, head::tail) => head::drop(n, tail, ctr-1)
    }
    drop(n, list, n)
  }

  def idiomaticDrop[T](n: Int, list: List[T]): List[T] = list.splitAt(n-1) match {
    case (pre, Nil) => pre
    case (pre, head::post) => pre++idiomaticDrop(n,post)
  }
}
*/