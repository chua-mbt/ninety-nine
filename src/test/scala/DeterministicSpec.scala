import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine._

abstract class DeterministicSpec[I, O](
  problem: Problem[I, O],
  testCases: Set[TestCase[I, O]]
) extends ProblemSpec[I, O](problem, testCases){
  def checkSolution(solution: Solution[I, O], testCase: TestCase[I, O]) =
    solution.implementation(testCase.input) should be === testCase.expected.get
}