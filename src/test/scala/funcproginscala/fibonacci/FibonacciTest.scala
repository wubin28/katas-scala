package funcproginscala.fibonacci

import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class FibonacciTest extends FunSuite{
  test("the 3th fibonacci number is 2") {
    def fibonacci(n: Int): Int = {
      @annotation.tailrec
      def go(n: Int, a: Int, b: Int): Int = n match {
        case 0 => a
        case _ => go(n-1, b, a+b)
      }
      go(n, 0, 1)
    }
    assert(fibonacci(3) === 2)
  }
}
