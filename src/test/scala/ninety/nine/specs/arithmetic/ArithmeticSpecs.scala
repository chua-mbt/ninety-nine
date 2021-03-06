package ninety.nine.specs.arithmetic

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine.problems._
import ninety.nine.specs._

class P31Spec extends DeterministicSpec[Int, Boolean](
  P31,
  Set(
    TestCase[Int, Boolean](0)(Some(false)),
    TestCase[Int, Boolean](1)(Some(false)),
    TestCase[Int, Boolean](2)(Some(true)),
    TestCase[Int, Boolean](3)(Some(true)),
    TestCase[Int, Boolean](7)(Some(true)),
    TestCase[Int, Boolean](10)(Some(false)),
    TestCase[Int, Boolean](97)(Some(true))
  )
){ runTests }

class P32Spec extends DeterministicSpec[Int, Int](
  P32,
  Set(
    TestCase[Int, Int](36, 63)(Some(9))
  )
){ runTests }

class P33Spec extends DeterministicSpec[Int, Boolean](
  P33,
  Set(
    TestCase[Int, Boolean](35, 64)(Some(true))
  )
){ runTests }

class P34Spec extends DeterministicSpec[Int, Int](
  P34,
  Set(
    TestCase[Int, Int](10)(Some(4))
  )
){ runTests }

class P35Spec extends DeterministicSpec[Int, List[Int]](
  P35,
  Set(
    TestCase[Int, List[Int]](315)(Some(List(3, 3, 5, 7)))
  )
){ runTests }

class P36Spec extends DeterministicSpec[Int, List[(Int, Int)]](
  P36,
  Set(
    TestCase[Int, List[(Int, Int)]](315)(Some(List((3,2), (5,1), (7,1))))
  )
){ runTests }

class P37Spec extends DeterministicSpec[Int, Int](
  P37,
  Set(
    TestCase[Int, Int](10)(Some(4))
  )
){ runTests }

class P38Spec extends BenchmarkSpec[Int, Int](
  Solution("P34", P34.solution),
  Solution("P37", P37.solution),
  5, Set(
    TestCase[Int, Int](10090)(None)
  ),
  Seq(Solution("P37", P37.solution), Solution("P34", P34.solution))
){ runBenchmarks }