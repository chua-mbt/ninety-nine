import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine._

class NinetyNineSpec extends FlatSpec with ShouldMatchers {
  val problems = List(
    // List Problems
    P01, P02, P03, P04, P05, P06, P07, P08, P09, P10,
    P11, P12, P13, P14, P15, P16, P17, P18, P19
    // Arithmetic Problems
  )
  problems.foreach { problem =>
    problem.NAME should problem.DESCRIPTION in {
      problem.recursiveSolution(problem.TESTCASE:_*) should be === problem.TESTOUT
      problem.idiomaticSolution(problem.TESTCASE:_*) should be === problem.TESTOUT
    }
  }
}
