package ninety.nine.problems

import scala.annotation.tailrec

object P32 extends Problem[Int, Int] {
  val NAME = "P32"
  val DESCRIPTION = "determine the greatest common divisor of two positive integer numbers"

  val solutions = Set(
    Solution("solution", solution)
  )

  def solution(input: Int*): Int = {
    val a = input(0)
    val b = input(1)
    gcd(a, b)
  }

  @tailrec
  def gcd(a: Int, b: Int): Int = if(b == 0) a else gcd(b, a % b)
}
