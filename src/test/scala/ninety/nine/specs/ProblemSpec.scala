package ninety.nine.specs

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine.problems._

abstract class ProblemSpec[I, O](
  problem: Problem[I, O],
  testCases: Set[TestCase[I, O]]
) extends FlatSpec with ShouldMatchers{
  def checkSolution(solution: Solution[I, O], testCase: TestCase[I, O])
  def runTests = testCases.zipWithIndex.foreach { case(testCase, idx) =>
    problem.solutions.foreach { solution =>
      solution.name+": ( Test "+idx+" )" should problem.DESCRIPTION in {
        checkSolution(solution, testCase)
      }
    }
  }
}