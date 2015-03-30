package ninety.nine

trait Problem[O] {
  val NAME:String
  val DESCRIPTION:String
  val TESTCASE:Any
  val TESTOUT:O
  def recursiveSolution(input: Any*): O
  def idiomaticSolution(input: Any*): O
}