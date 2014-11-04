import org.scalatest.FunSuite

/**
 * Created by ben on 11/4/14.
 */
class KatasScalaSuite extends FunSuite{
  test("the answer to life the universe and everything") {
    val douglas = new KatasScala
    assert(douglas.answer() === (42))
  }

  test("a val can never be reassigned but a var can") {
//    val msg = "Hello, world!"
//    msg = "Goodbye cruel world!" // Got "error: reassignment to val"
//    assert(msg === "Goodbye cruel world!")

    var anotherMsg = "Hello, world!"
    anotherMsg = "Goodbye cruel world!"
    assert(anotherMsg === "Goodbye cruel world!")

  }

  test("define a function") {
    def max(x: Int, y: Int) = if (x > y) x else y
    assert(max(5, 7) === (7))
  }
}


