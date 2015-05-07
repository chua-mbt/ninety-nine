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