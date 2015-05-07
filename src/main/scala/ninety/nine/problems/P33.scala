package ninety.nine.problems

object P33 extends Problem[Int, Boolean] {
  val NAME = "P33"
  val DESCRIPTION = "determine whether two positive integer numbers are coprime"

    val solutions = Set(
    Solution("solution", solution)
  )

  def solution(input: Int*): Boolean = {
    val a = input(0)
    val b = input(1)
    coprime(a, b)
  }

  def coprime(a: Int, b: Int): Boolean = P32.gcd(a,b) == 1
}
