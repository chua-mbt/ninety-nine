package ninety.nine

object P27A extends Problem[List[String], List[List[List[String]]]] {
  val NAME = "P27A"
  val DESCRIPTION = "group the elements of a set into disjoint subsets (2,3,4)"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution)
  )

  def idiomaticSolution(input: List[String]*): List[List[List[String]]] = {
    val list = input(0).asInstanceOf[List[String]]
    idiomaticGroup234(list)
  }

  def idiomaticGroup234[T](list: List[T]): List[List[List[T]]] =
    (list combinations(2)).toList.flatMap { combo2 =>
      (list diff combo2 combinations(3)).toList.flatMap { combo3 =>
        (list diff combo2 diff combo3 combinations(4)).toList.map { combo4 =>
          List(combo2, combo3, combo4)
        }
      }
    }
}

object P27B extends Problem[Any, List[List[List[String]]]] {
  val NAME = "P27B"
  val DESCRIPTION = "group the elements of a set into disjoint subsets (parameterized)"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution)
  )

  def idiomaticSolution(input: Any*): List[List[List[String]]] = {
    val comboCount = input(0).asInstanceOf[List[Int]]
    val list = input(1).asInstanceOf[List[String]]
    idiomaticGroupParam(comboCount, list, List.empty[List[String]])
  }

  def idiomaticGroupParam[T](
    comboCount: List[Int],
    list: List[T],
    groups: List[List[T]]
  ): List[List[List[T]]] = comboCount match {
    case Nil => Nil
    case last::Nil => list.combinations(last).toList.map{ groups:+_ }
    case head::tail => {
      val combos = list.combinations(head).toList
      combos.flatMap{ combo => idiomaticGroupParam(tail, (list diff combo), groups:+combo) }
    }
  }
}