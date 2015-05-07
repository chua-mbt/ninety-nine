package ninety.nine.specs

import org.scalatest._
import org.scalatest.matchers.ShouldMatchers

case class TestCase[I, O](input: I*)(expectedOut: Option[O]){
  def expected = expectedOut
}