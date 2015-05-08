package ninety.nine.problems

case class Solution[I, O](name: String, implementation: Seq[I] => O){
  override def toString = name
}