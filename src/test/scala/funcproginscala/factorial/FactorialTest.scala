package funcproginscala.factorial

import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class FactorialTest extends FunSuite{
  test("the factorial of 5 is 120 p20") {
    assert(factorial(5) === 120)
  }
}
