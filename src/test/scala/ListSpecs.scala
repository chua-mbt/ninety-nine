import ninety.nine._

class P01Spec extends DeterministicSpec[List[Int], Int](
  P01,
  Set(
    TestCase[List[Int], Int](List(1, 1, 2, 3, 5, 8))(Some(8))
  )
){ runTests }

class P02Spec extends DeterministicSpec[List[Int], Int](
  P02,
  Set(
    TestCase[List[Int], Int](List(1, 1, 2, 3, 5, 8))(Some(5))
  )
){ runTests }

class P03Spec extends DeterministicSpec[Any, Int](
  P03,
  Set(
    TestCase[Any, Int](2, List(1, 1, 2, 3, 5, 8))(Some(2))
  )
){ runTests }

class P04Spec extends DeterministicSpec[List[Int], Int](
  P04,
  Set(
    TestCase[List[Int], Int](List(1, 1, 2, 3, 5, 8))(Some(6))
  )
){ runTests }

class P05Spec extends DeterministicSpec[List[Int], List[Int]](
  P05,
  Set(
    TestCase[List[Int], List[Int]](List(1, 1, 2, 3, 5, 8))(Some(List(8, 5, 3, 2, 1, 1)))
  )
){ runTests }

class P06Spec extends DeterministicSpec[List[Int], Boolean](
  P06,
  Set(
    TestCase[List[Int], Boolean](List(1, 2, 3, 2, 1))(Some(true))
  )
){ runTests }

class P07Spec extends DeterministicSpec[List[Any], List[Any]](
  P07,
  Set(
    TestCase[List[Any], List[Any]](
      List(List(1, 1), 2, List(3, List(5, 8)))
    )(Some(
      List(1, 1, 2, 3, 5, 8)
    ))
  )
){ runTests }

class P08Spec extends DeterministicSpec[List[Symbol], List[Symbol]](
  P08,
  Set(
    TestCase[List[Symbol], List[Symbol]](
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )(Some(
      List('a, 'b, 'c, 'a, 'd, 'e)
    ))
  )
){ runTests }

class P09Spec extends DeterministicSpec[List[Symbol], List[List[Symbol]]](
  P09,
  Set(
    TestCase[List[Symbol], List[List[Symbol]]](
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )(Some(
      List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
    ))
  )
){ runTests }

class P10Spec extends DeterministicSpec[List[Symbol], List[(Int, Symbol)]](
  P10,
  Set(
    TestCase[List[Symbol], List[(Int, Symbol)]](
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )(Some(
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    ))
  )
){ runTests }

class P11Spec extends DeterministicSpec[List[Symbol], List[Any]](
  P11,
  Set(
    TestCase[List[Symbol], List[Any]](
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    )(Some(
      List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
    ))
  )
){ runTests }

class P12Spec extends DeterministicSpec[List[(Int, Symbol)], List[Symbol]](
  P12,
  Set(
    TestCase[List[(Int, Symbol)], List[Symbol]](
      List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
    )(Some(
      List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
    ))
  )
){ runTests }

class P13Spec extends DeterministicSpec[Any, Any](
  P13,
  Set.empty[TestCase[Any, Any]]
){ runTests }

class P14Spec extends DeterministicSpec[List[Symbol], List[Symbol]](
  P14,
  Set(
    TestCase[List[Symbol], List[Symbol]](
      List('a, 'b, 'c, 'c, 'd)
    )(Some(
      List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
    ))
  )
){ runTests }

class P15Spec extends DeterministicSpec[Any, List[Symbol]](
  P15,
  Set(
    TestCase[Any, List[Symbol]](
      3, List('a, 'b, 'c, 'c, 'd)
    )(Some(
      List('a, 'a, 'a, 'b, 'b, 'b, 'c, 'c, 'c, 'c, 'c, 'c, 'd, 'd, 'd)
    ))
  )
){ runTests }

class P16Spec extends DeterministicSpec[Any, List[Symbol]](
  P16,
  Set(
    TestCase[Any, List[Symbol]](
      3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    )(Some(
      List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
    ))
  )
){ runTests }

class P17Spec extends DeterministicSpec[Any, (List[Symbol], List[Symbol])](
  P17,
  Set(
    TestCase[Any, (List[Symbol], List[Symbol])](
      3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    )(Some(
      (List('a, 'b, 'c), List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
    ))
  )
){ runTests }

class P18Spec extends DeterministicSpec[Any, List[Symbol]](
  P18,
  Set(
    TestCase[Any, List[Symbol]](
      3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    )(Some(
      List('d, 'e, 'f, 'g)
    ))
  )
){ runTests }

class P19Spec extends DeterministicSpec[Any, List[Symbol]](
  P19,
  Set(
    TestCase[Any, List[Symbol]](
      3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    )(Some(
      List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
    )),
    TestCase[Any, List[Symbol]](
      -2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    )(Some(
      List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
    ))
  )
){ runTests }

class P20Spec extends DeterministicSpec[Any, (List[Symbol], Symbol)](
  P20,
  Set(
    TestCase[Any, (List[Symbol], Symbol)](
      1, List('a, 'b, 'c, 'd)
    )(Some(
      (List('a, 'c, 'd), 'b)
    ))
  )
){ runTests }

class P21Spec extends DeterministicSpec[Any, List[Symbol]](
  P21,
  Set(
    TestCase[Any, List[Symbol]](
      'new, 1, List('a, 'b, 'c, 'd)
    )(Some(
      List('a, 'new, 'b, 'c, 'd)
    ))
  )
){ runTests }

class P22Spec extends DeterministicSpec[Int, List[Int]](
  P22,
  Set(
    TestCase[Int, List[Int]](
      4, 9
    )(Some(
      List(4, 5, 6, 7, 8, 9)
    ))
  )
){ runTests }

class P23Spec extends ProblemSpec[Any, List[Symbol]](
  P23,
  Set(
    TestCase[Any, List[Symbol]](
      3, List('a, 'b, 'c, 'd, 'f, 'g, 'h)
    )(None)
  )
){
  val ITERATION = 10
  def checkSolution(solution: Solution[Any, List[Symbol]], testCase: TestCase[Any, List[Symbol]]) = {
    val inputList = testCase.input(1).asInstanceOf[List[Symbol]]
    val results = (1 to ITERATION).toSet map { _:Int => solution.implementation(testCase.input) }
    results.size should be > 1
    results.foreach { result => result.foreach {
      inputList should contain (_)
    } }
  }
  runTests
}

class P24Spec extends ProblemSpec[Int, List[Int]](
  P24,
  Set(
    TestCase[Int, List[Int]](6, 49)(None)
  )
){
  val ITERATION = 10
  def checkSolution(solution: Solution[Int, List[Int]], testCase: TestCase[Int, List[Int]]) = {
    val n = testCase.input(0)
    val m = testCase.input(1)
    val results = (1 to ITERATION).toSet map { _:Int => solution.implementation(testCase.input) }
    results.size should be > 1
    results.foreach { result =>
      result should have length n
      result.foreach { item =>
        item should be <= m
        item should be > 0
      }
    }
  }
  runTests
}

class P25Spec extends ProblemSpec[List[Symbol], List[Symbol]](
  P25,
  Set(
    TestCase[List[Symbol], List[Symbol]](List('a, 'b, 'c, 'd, 'e, 'f))(None)
  )
){
  val ITERATION = 10
  def checkSolution(
    solution: Solution[List[Symbol], List[Symbol]],
    testCase: TestCase[List[Symbol], List[Symbol]]
  ) = {
    val sortedInput = testCase.input(0).map{ _.toString }.sorted
    val results = (1 to ITERATION).toSet map { _:Int => solution.implementation(testCase.input) }
    results.size should be > 1
    results.foreach { result =>
      sortedInput should be === result.map{ _.toString }.sorted
    }
  }
  runTests
}

