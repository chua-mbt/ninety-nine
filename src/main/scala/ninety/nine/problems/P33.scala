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
    import S99Int.int2S99Int
    a.isCoprimeTo(b)
  }

  class S99Int(val start: Int) {
    def isCoprimeTo(b: Int): Boolean = P32.gcd(start,b) == 1
  }

  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
