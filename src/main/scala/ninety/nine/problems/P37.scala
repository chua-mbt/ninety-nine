package ninety.nine.problems

import scala.math.pow
import scala.collection.mutable.ArrayBuffer

object P37 extends Problem[Int, Int] {
  val NAME = "P37"
  val DESCRIPTION = "calculate Euler's totient function phi(m) (improved)"

  val solutions = Set(
    Solution("solution", solution)
  )

  def solution(input: Int*): Int = {
    val m = input(0)
    import S99Int.int2S99Int
    m.totient
  }

  class S99Int(val start: Int) {
    lazy val primeFactors = P36.reusedSolution(start)
    def totient: Int = primeFactors.foldLeft(1){
      case(accumulator, (pf, mult)) => accumulator*(pf-1)*pow(pf, mult-1).toInt
    }
  }

  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
