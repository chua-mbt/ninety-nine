import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine._

class NinetyNineSpec extends FlatSpec with ShouldMatchers {
  def checkSolutions[I, O](problem: Problem[I, O]) = {
    problem.solutions.foreach { solution =>
      problem.testCases.zipWithIndex.foreach { case(testCase, idx) =>
        problem.NAME+"."+solution.name+": ( Test "+idx+" )" should problem.DESCRIPTION in {
          solution.implementation(testCase.input) should be === testCase.expected
        }
      }
    }
  }

  val listProblems = List(
    P01, P02, P03, P04, P05, P06, P07, P08, P09, P10,
    P11, P12, P13, P14, P15, P16, P17, P18, P19/*, P20,
    P21, P22*/
  )
  val problems = listProblems
  // List Problems
  problems.foreach { problem => checkSolutions(problem) }
}
