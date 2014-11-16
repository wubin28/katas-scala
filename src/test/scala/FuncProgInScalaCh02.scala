import org.scalatest.FunSuite

/**
 * Created by ben on 11/15/14.
 */
class FuncProgInScalaCh02 extends FunSuite{

  val myAbs = new MyAbs

  test("a simple scala program p15") {
    // Assert
    assert(myAbs.formatAbs(-42) === "The absolute value of -42 is 42")
  }
}
