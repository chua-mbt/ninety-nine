package ninety.nine

object P09 extends Problem[List[Symbol], List[List[Symbol]]] {
  val NAME = "P09"
  val DESCRIPTION = "pack consecutive duplicates of list elements into sublists"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Symbol]*): List[List[Symbol]] = {
    val list = input(0)
    recursivePack(list)
  }

  def idiomaticSolution(input: List[Symbol]*): List[List[Symbol]] = {
    val list = input(0)
    idiomaticPack(list)
  }

  def recursivePack[T](list: List[T], last:List[T] = Nil): List[List[T]] = (list, last) match {
    case (Nil, packed) => packed::Nil
    case (head::tail, Nil) => recursivePack(tail, List(head))
    case (head::tail, packed) if(packed.contains(head)) => recursivePack(tail, head::packed)
    case (head::tail, packed) => packed::recursivePack(tail, List(head))
  }

  def idiomaticPack[T](list: List[T]): List[List[T]] = list match {
    case Nil => Nil
    case items => {
      val (packed, rest) = items.span(_ == items.head)
      packed::idiomaticPack(rest)
    }
  }
}