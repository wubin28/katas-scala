import org.scalatest.FunSuite

/**
 * Created by ben on 11/15/14.
 */
class FuncProgInScalaCh02 extends FunSuite{


  test("a simple scala program p15") {
    // Arrange
    val myAbs = new MyAbs
    
    // Act, Assert
    assert(myAbs.formatAbs(-42) === "The absolute value of -42 is 42")
  }
}
