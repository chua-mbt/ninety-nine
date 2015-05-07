package ninety.nine.problems

import scala.util.Random

object P25 extends Problem[List[Symbol], List[Symbol]] {
  val NAME = "P25"
  val DESCRIPTION = "generate a random permutation of the elements of a list"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution),
    Solution("perfect", perfectShuffle)
  )

  def idiomaticSolution(input: List[Symbol]*): List[Symbol] = {
    val list = input(0)
    Random.shuffle(list)
  }

  // http://okmij.org/ftp/Haskell/perfect-shuffle.txt
  def perfectShuffle(input: List[Symbol]*): List[Symbol] = {
    val list = input(0)
    recursiveShuffle(list)
  }

  def recursiveShuffle[T](list: List[T]): List[T] = {
    val r = new Random
    def shuffle[T](list: List[T]): List[T] = list match {
      case Nil => Nil
      case head::tail => {
        val (remaining, removed) =  P20.recursiveRemove(r.nextInt(list.length), list)
        removed::shuffle(remaining)
      }
    }
    shuffle(list)
  }
}