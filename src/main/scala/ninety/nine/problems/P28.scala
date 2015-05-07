package ninety.nine.problems

import scala.math.Ordering.Int

object P28A extends Problem[List[List[Symbol]], List[List[Symbol]]] {
  val NAME = "P28A"
  val DESCRIPTION = "sorting a list of lists according to length of sublists"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution)
  )

  def idiomaticSolution(input: List[List[Symbol]]*): List[List[Symbol]] = {
    val list = input(0)
    idiomaticLenSort(list)
  }

  def idiomaticLenSort[T](list: List[List[T]]): List[List[T]] = {
    implicit object LenOrdering extends Ordering[List[T]] {
      def compare(x: List[T], y: List[T]): Int = Int.compare(x.length, y.length)
    }
    list.sorted
  }
}

object P28B extends Problem[List[List[Symbol]], List[List[Symbol]]] {
  val NAME = "P28B"
  val DESCRIPTION = "sorting a list of lists according to frequency of length of sublists"

  val solutions = Set(
    Solution("idiomatic", idiomaticSolution)
  )

  def idiomaticSolution(input: List[List[Symbol]]*): List[List[Symbol]] = {
    val list = input(0)
    idiomaticLenFreqSort(list)
  }

  def idiomaticLenFreqSort[T](list: List[List[T]]): List[List[T]] = {
    import scala.collection.mutable.HashMap
    val freqs = list.foldLeft(HashMap.empty[Int, Int].withDefaultValue(0)){ (tally, sublist) =>
      tally(sublist.length) += 1
      tally
    }
    implicit object LenFreqOrdering extends Ordering[List[T]] {
      def compare(x: List[T], y: List[T]): Int = Int.compare(freqs(x.length), freqs(y.length))
    }
    list.sorted
  }
}