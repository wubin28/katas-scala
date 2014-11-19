package funcproginscala.abs

import org.scalatest.FunSuite

/**
 * Created by ben on 11/15/14.
 */
class GettingStarted extends FunSuite{
  // TODO: Move to upper package
  test("a simple scala program of ABS - object version p15") {
    // Arrange
    // Act, Assert
    assert(MyAbsObject.formatAbs(-42) === "The absolute value of -42 is 42")
  }

  test("a simple scala program of ABS - class version p15") {
    // Arrange
    val myAbs = new MyAbs
    // Act, Assert
    assert(myAbs.formatAbs(-42) === "The absolute value of -42 is 42")
  }
}
