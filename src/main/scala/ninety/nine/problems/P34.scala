package ninety.nine.problems

object P34 extends Problem[Int, Int] {
  val NAME = "P34"
  val DESCRIPTION = "calculate Euler's totient function phi(m)"

    val solutions = Set(
    Solution("solution", solution)
  )

  def solution(input: Int*): Int = {
    val m = input(0)
    import S99Int.int2S99Int
    m.totient
  }

  class S99Int(start: Int) extends P33.S99Int(start) {
    def totient: Int = (1 until start+1).filter(isCoprimeTo(_)).length
  }

  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
