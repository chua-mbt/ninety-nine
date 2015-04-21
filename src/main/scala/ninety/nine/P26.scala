package ninety.nine

object P26 extends Problem[Any, List[List[Symbol]]] {
  val NAME = "P26"
  val DESCRIPTION = "generate the combinations of K distinct objects chosen from the N elements of a list"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution)
  )

  def idiomaticSolution(input: Any*): List[List[Symbol]] = {
    val k = input(0).asInstanceOf[Int]
    val list = input(1).asInstanceOf[List[Symbol]]
    idiomaticCombinations(k, list)
  }

  def idiomaticCombinations[T](k: Int, list: List[T]): List[List[T]] = list match {
    case Nil => Nil
    case list if k == 1 => list map { _::Nil }
    case head::tail => {
      idiomaticCombinations(k-1, tail).map{ head::_ }++idiomaticCombinations(k, tail)
    }
  }
}