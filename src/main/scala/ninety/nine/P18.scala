package ninety.nine

object P18 extends Problem[List[Any]] {
  val NAME = "P18"
  val DESCRIPTION = "extract a slice from a list"
  val TESTCASE = List(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
  val TESTOUT = List('d, 'e, 'f, 'g)

  def recursiveSolution(input: Any*): List[Any] = {
    val start = input(0).asInstanceOf[Int]
    val end = input(1).asInstanceOf[Int]
    val list = input(2).asInstanceOf[List[Any]]
    recursiveSlice(start, end, list)
  }

  def idiomaticSolution(input: Any*): List[Any] = {
    val start = input(0).asInstanceOf[Int]
    val end = input(1).asInstanceOf[Int]
    val list = input(2).asInstanceOf[List[Any]]
    list.slice(start, end)
  }

  def recursiveSlice(
    start: Int, end: Int, list: List[Any],
    preCtr: Int = 0,
    postCtr: Int = 0
  ): List[Any] =
    (preCtr, postCtr, list) match {
      case (_, _, Nil) => Nil
      case (pre, post, head::tail) => if(pre < start){
        recursiveSlice(start, end, tail, pre+1, post)
      }else if(pre+post < end){
        head::recursiveSlice(start, end, tail, pre, post+1)
      }else{
        Nil
      }
    }
}