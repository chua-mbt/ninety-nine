package ninety.nine.specs

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine.problems._

abstract class RandomizedSpec[I, O](
  problem: Problem[I, O],
  testCases: Set[TestCase[I, O]]
) extends ProblemSpec[I, O](problem, testCases){
  val ITERATION = 10
  def checkSolution(solution: Solution[I, O], testCase: TestCase[I, O]) = {
    val results = (1 to ITERATION).toSet map { _:Int => solution.implementation(testCase.input) }
    results.size should be > 1
    results.foreach { result => checkResult(result, testCase) }
  }
  def checkResult(result: O, testCase: TestCase[I, O])
}