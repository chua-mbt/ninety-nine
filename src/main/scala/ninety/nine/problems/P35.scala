package ninety.nine.problems

import scala.collection.mutable.ArrayBuffer

object P35 extends Problem[Int, List[Int]] {
  val NAME = "P35"
  val DESCRIPTION = "determine the prime factors of a given positive integer"

  val solutions = Set(
    Solution("sieve", sieveSolution)
  )

  def sieveSolution(input: Int*): List[Int] = {
    val num = input(0)
    import S99Int.int2S99Int
    num.primeFactorsSieve
  }

  class S99Int(start: Int) extends P31.S99Int(start) {
    def primeFactorsSieve: List[Int] = {
      val primes = sieveOfEratosthenes(2 until (start) by 2, ArrayBuffer.fill[Boolean](start)(true))
        .view.zipWithIndex
        .filter{ i => i match {
          case(true, prime) => true
          case _ => false
        } }
        .map { _._2 }
      primeFactors(start, primes)
    }

    private def primeFactors(num: Int, primes: Seq[Int]): List[Int] = if(primes.contains(num)){
      return num::Nil
    }else{
      primes.find(num % _ == 0) match {
        case Some(prime) => prime::primeFactors(num/prime, primes)
        case None => Nil
      }
    }
  }

  object S99Int {
    implicit def int2S99Int(i: Int): S99Int = new S99Int(i)
  }
}
