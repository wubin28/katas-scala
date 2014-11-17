package funcproginscala.hof

import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class HofTest extends FunSuite{

  def fibonacci(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => go(n-1, b, a+b)
    }
    go(n, 0, 1)
  }

  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)

    go(n, 1)
  }

  test("the 3th fibonacci number is 2") {
    assert(fibonacci(3) === 2)
  }

  test("writing loops functionally: the factorial of 5 is 120 p20") {
    assert(factorial(5) === 120)
  }

  test("test higher-order function") {
    assert(formatResult("fibonacci", 3, fibonacci) === "")
    assert(formatResult("factorial", 5, factorial) === "")
  }
}
