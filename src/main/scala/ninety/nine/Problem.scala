package ninety.nine

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

trait Problem[I, O] {
  val NAME:String
  val DESCRIPTION:String
  val solutions:Set[Solution[I, O]]
}