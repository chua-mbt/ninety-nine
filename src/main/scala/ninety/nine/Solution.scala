package ninety.nine

case class Solution[I, O](name: String, implementation: Seq[I] => O)