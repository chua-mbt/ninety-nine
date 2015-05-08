package ninety.nine.specs

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers
import ninety.nine.problems._

abstract class BenchmarkSpec[I, O](
  s1: Solution[I, O],
  s2: Solution[I, O],
  iterations: Int,
  testCases: Set[TestCase[I, O]],
  expected: Seq[Solution[I,O]]
) extends FlatSpec with ShouldMatchers{
  implicit val SolutionOrdering = new Ordering[(Solution[I, O], Long)] {
      override def compare(x: (Solution[I, O], Long), y: (Solution[I, O], Long)): Int = {
        x._2.compareTo(y._2)
     }
  }

  def runBenchmarks = testCases.zipWithIndex.foreach { case(testCase, idx) =>
    s1.name+" vs. "+s2.name+": ( Benchmark "+idx+" )" should "result in "+expected.toString in {
      (0 until iterations).foreach { i =>
        println(Seq(timeSolution(testCase, s1), timeSolution(testCase, s2)).sorted.toString)
        Seq(timeSolution(testCase, s1), timeSolution(testCase, s2)).sorted.map{ _._1 } should be === expected
      }
    }
  }

  def timeSolution(testCase: TestCase[I, O], solution: Solution[I, O]) = {
    val s = System.currentTimeMillis()
    solution.implementation(testCase.input)
    (solution, System.currentTimeMillis() - s)
  }
}