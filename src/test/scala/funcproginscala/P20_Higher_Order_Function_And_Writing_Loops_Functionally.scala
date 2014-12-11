package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class P20_Higher_Order_Function_And_Writing_Loops_Functionally extends FunSuite{
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

  test("K: writing loops functionally - fibonacci p21") {
    assert(fibonacci(3) === 2)
  }

  test("K: writing loops functionally - factorial p20") {
    assert(factorial(5) === 120)
  }

  def formatResult(name: String, n: Int, f: (Int) => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  test("K: higher-order function p21") {
    assert(formatResult("fibonacci", 3, fibonacci) === "The fibonacci of 3 is 2.")
    assert(formatResult("factorial", 5, factorial) === "The factorial of 5 is 120.")
  }
}
