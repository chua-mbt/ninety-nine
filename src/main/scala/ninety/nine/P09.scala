package ninety.nine
/*
object P09 extends Problem[List[List[Any]]] {
  val NAME = "P09"
  val DESCRIPTION = "pack consecutive duplicates of list elements into sublists"
  val TESTCASE = List(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  val TESTOUT = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

  def recursiveSolution(input: Any*): List[List[Any]] = {
    val list = input(0).asInstanceOf[List[Any]]
    recursivePack(list)
  }

  def idiomaticSolution(input: Any*): List[List[Any]] = {
    val list = input(0).asInstanceOf[List[Any]]
    idiomaticPack(list)
  }

  def recursivePack[T](list: List[T], last:List[T] = Nil): List[List[T]] = (list, last) match {
    case (Nil, packed) => packed::Nil
    case (head::tail, Nil) => recursivePack(tail, List(head))
    case (head::tail, packed) => if(packed.contains(head)){
      recursivePack(tail, head::packed)
    } else{
      packed::recursivePack(tail, List(head))
    }
  }

  def idiomaticPack[T](list: List[T]): List[List[T]] = list match {
    case Nil => Nil
    case items => {
      val (packed, rest) = items.span(_ == items.head)
      packed::idiomaticPack(rest)
    }
  }
}
*/