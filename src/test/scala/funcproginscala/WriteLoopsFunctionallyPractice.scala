package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by ben on 11/23/14.
 */
class WriteLoopsFunctionallyPractice extends FunSuite{

  test("K: writing loops functionally - factorial p20") {
    def factorial(n: Int): Int = {
      @annotation.tailrec
      def go(n: Int, acc: Int): Int =
        if (n <= 0) acc else go(n-1, n*acc)
      go(n, 1)
    }
    assert(factorial(5) === 120)
  }

  test("K: writing loops functionally - fibonacci p21") {
    def fibonacci(n: Int): Int = {
      @annotation.tailrec
      def fib_tail( n: Int, a:Int, b:Int): Int = n match {
        case 0 => a
        case _ => fib_tail( n-1, b, a+b )
      }
      return fib_tail( n, 0, 1)
    }
    assert(fibonacci(4) === 3)
  }
}
