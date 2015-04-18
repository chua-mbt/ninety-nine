package ninety.nine

object P09 extends Problem[Any, Any] {
  val NAME = "P09"
  val DESCRIPTION = "pack consecutive duplicates of list elements into sublists"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e)),
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    recursivePack(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
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