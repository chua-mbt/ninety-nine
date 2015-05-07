package ninety.nine.problems

import scala.math.pow
import scala.collection.mutable.ArrayBuffer
import scala.annotation.tailrec

object P31 extends Problem[Int, Boolean] {
  val NAME = "P31"
  val DESCRIPTION = "determine whether a given integer number is prime"

  val solutions = Set(
    Solution("trial division", trialDivSolution),
    Solution("sieve", sieveSolution)
  )

  def sieveSolution(input: Int*): Boolean = {
    val num = input(0)
    import S99Int.int2S99Int
    num.isPrimeSieve
  }

  def trialDivSolution(input: Int*): Boolean = {
    val num = input(0)
    import S99Int.int2S99Int
    num.isPrimeTrialDiv
  }

  class S99Int(val start: Int) {
    def isPrimeSieve = start match {
      case 0 | 1 => false
      case num => sieveOfEratosthenes(2 until num+1 by 2, ArrayBuffer.fill[Boolean](num+1)(true))(num)
    }

    @tailrec
    private def sieveOfEratosthenes(range: Range, marks: ArrayBuffer[Boolean]): ArrayBuffer[Boolean] = {
      range.drop(1).foreach { multiple => marks(multiple) = false }
      marks.indexOf(true, range.start+1) match {
        case -1 => marks
        case next => sieveOfEratosthenes(next until range.end by next, marks)
      }
    }

    def isPrimeTrialDiv = start match {
      case 0 | 1 => false
      case n => {
        Stream.from(2).takeWhile{ pow(_, 2) <= n }.find(n % _ == 0) match {
          case Some(i) => false
          case None => true
        }
      }
    }
  }

  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
