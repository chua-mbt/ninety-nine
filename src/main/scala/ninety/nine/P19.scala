package ninety.nine
/*
object P19 extends Problem[List[Any]] {
  val NAME = "P19"
  val DESCRIPTION = "rotate a list N places to the left"
  val TESTCASE = List(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  val TESTOUT = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)

  def recursiveSolution(input: Any*): List[Any] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    val (pre, post) = P17.recursiveSplit(n, list)
    post++pre
  }

  def idiomaticSolution(input: Any*): List[Any] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    val (pre, post) = list.splitAt(n)
    post++pre
  }
}
*/