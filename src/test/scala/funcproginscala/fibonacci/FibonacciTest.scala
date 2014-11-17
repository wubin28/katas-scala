package funcproginscala.fibonacci

import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class FibonacciTest extends FunSuite{
  test("the 7th fibonacci number is 13") {
    assert(fibonacci(7) === 13)
  }
}
