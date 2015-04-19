package ninety.nine

trait Problem[I, O] {
  val NAME:String
  val DESCRIPTION:String
  val solutions:Set[Solution[I, O]]
}