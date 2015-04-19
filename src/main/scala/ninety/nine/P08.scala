package ninety.nine

object P08 extends Problem[List[Symbol], List[Symbol]] {
  val NAME = "P08"
  val DESCRIPTION = "eliminate consecutive duplicates of list elements"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  def recursiveSolution(input: List[Symbol]*): List[Symbol] = {
    val list = input(0)
    recursiveCompress(list)
  }

  def idiomaticSolution(input: List[Symbol]*): List[Symbol] = {
    val list = input(0)
    idiomaticCompress(list)
  }

  def recursiveCompress[T](list: List[T], last:Option[T] = None): List[T] = (list, last) match {
    case (Nil, _) => Nil
    case (head::tail, None) => head::recursiveCompress(tail, Some(head))
    case (head::tail, Some(item)) if(head == item) => recursiveCompress(tail, Some(head))
    case (head::tail, Some(item)) => head::recursiveCompress(tail, Some(head))
  }

  def idiomaticCompress[T](list: List[T]): List[T] = list.foldRight(List.empty[T]) { (item, result) =>
    if(result.isEmpty || result.head != item){ item::result } else { result }
  }
}