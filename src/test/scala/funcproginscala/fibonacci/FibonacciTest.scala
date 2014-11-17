package funcproginscala.fibonacci

import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class FibonacciTest extends FunSuite{


  test("the 7th fibonacci number is 13") {
    def fibonacci(n: Int): Int = {
      def go(n: Int, a: Int, b: Int): Int = n match {
        case 0 => a
        case _ => go(n-1, b, a+b)
      }
      go(n, 0, 1)
    }
    assert(fibonacci(7) === 13)
  }
}
