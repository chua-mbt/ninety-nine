import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine._

class NinetyNineSpec extends FlatSpec with ShouldMatchers {
  P01.NAME should P01.DESCRIPTION in {
    P01.recursiveSolution(P01.TESTCASE:_*) should be === P01.TESTOUT
    P01.idiomaticSolution(P01.TESTCASE:_*) should be === P01.TESTOUT
  }

  P02.NAME should P02.DESCRIPTION in {
    P02.recursiveSolution(P02.TESTCASE:_*) should be === P02.TESTOUT
    P02.idiomaticSolution(P02.TESTCASE:_*) should be === P02.TESTOUT
  }

  P03.NAME should P03.DESCRIPTION in {
    P03.recursiveSolution(P03.TESTCASE:_*) should be === P03.TESTOUT
    P03.idiomaticSolution(P03.TESTCASE:_*) should be === P03.TESTOUT
  }
}
