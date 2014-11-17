package funcproginscala.factorial

import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class FactorialTest extends FunSuite{

  test("writing loops functionally: the factorial of 5 is 120 p20") {
    def factorial(n: Int): Int = {
      @annotation.tailrec
      def go(n: Int, acc: Int): Int =
        if (n <= 0) acc
        else go(n-1, n*acc)

      go(n, 1)
    }

    assert(factorial(5) === 120)
  }
}
