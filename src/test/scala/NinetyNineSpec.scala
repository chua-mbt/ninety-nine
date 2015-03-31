import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine._

class NinetyNineSpec extends FlatSpec with ShouldMatchers {
  val problems = List(
    P01, P02, P03, P04, P05, P06, P07
  )
  problems.foreach { problem =>
    problem.NAME should problem.DESCRIPTION in {
      problem.recursiveSolution(problem.TESTCASE:_*) should be === problem.TESTOUT
      problem.idiomaticSolution(problem.TESTCASE:_*) should be === problem.TESTOUT
    }
  }
}