package ninety.nine

object P19 extends Problem[Any, List[Symbol]] {
  val NAME = "P19"
  val DESCRIPTION = "rotate a list N places to the left"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: Any*): List[Symbol] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    val len = P04.recursiveLength(list)
    val nMod = (n%len)
    val mod = if(nMod < 0){ nMod + len }else{ nMod }
    val (pre, post) = P17.recursiveSplit(mod, list)
    post++pre
  }

  def idiomaticSolution(input: Any*): List[Symbol] = {
    val n = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    val len = list.length
    val nMod = (n%len)
    val mod = if(nMod < 0){ nMod + len }else{ nMod }
    val (pre, post) = list.splitAt(mod)
    post++pre
  }
}