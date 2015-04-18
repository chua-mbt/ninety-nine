package ninety.nine

object P19 extends Problem[Any, Any] {
  val NAME = "P19"
  val DESCRIPTION = "rotate a list N places to the left"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c),
      3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    ),
    TestCase[Any, Any](
      List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i),
      -2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    val len = P04.recursiveLength(list)
    val nMod = (n%len)
    val mod = if(nMod < 0){ nMod + len }else{ nMod }
    val (pre, post) = P17.recursiveSplit(mod, list)
    post++pre
  }

  def idiomaticSolution(input: Any*): Any = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Any]]
    val len = list.length
    val nMod = (n%len)
    val mod = if(nMod < 0){ nMod + len }else{ nMod }
    val (pre, post) = list.splitAt(mod)
    post++pre
  }
}