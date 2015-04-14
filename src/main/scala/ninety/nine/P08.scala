package ninety.nine

object P08 extends Problem[Any, Any] {
  val NAME = "P08"
  val DESCRIPTION = "eliminate consecutive duplicates of list elements"

  val solutions = Set(
    Solution("recursive", recursiveSolution),
    Solution("idiomatic", idiomaticSolution)
  )

  val testCases = Set(
    TestCase[Any, Any](
      List('a, 'b, 'c, 'a, 'd, 'e),
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )
  )

  def recursiveSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    recursiveCompress(list)
  }

  def idiomaticSolution(input: Any*): Any = {
    val list = input(0).asInstanceOf[List[Symbol]]
    idiomaticCompress(list)
  }

  def recursiveCompress[T](list: List[T], last:Option[T] = None): List[T] = (list, last) match {
    case (Nil, _) => Nil
    case (head::tail, None) => head::recursiveCompress(tail, Some(head))
    case (head::tail, Some(item)) => if(head == item){
      recursiveCompress(tail, Some(head))
    } else{
      head::recursiveCompress(tail, Some(head))
    }
  }

  def idiomaticCompress[T](list: List[T]): List[T] = list.foldRight(List.empty[T]) { (item, result) =>
    if(result.isEmpty || result.head != item){ item::result } else { result }
  }
}