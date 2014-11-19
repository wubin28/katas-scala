package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by ben on 11/19/14.
 */
class PolymorphicFunction extends FunSuite{
  test("K: monomorphic function to find a string in an array p23") {
    assert(findFirst(Array("Susan", "Ben", "Louis"), "Ben") === 1)
  }
}
