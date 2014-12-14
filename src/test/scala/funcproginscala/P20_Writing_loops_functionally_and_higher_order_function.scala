package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by twer on 12/13/14.
 */
class P20_Writing_loops_functionally_and_higher_order_function extends FunSuite {
  def factorial(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n-1, n*acc)

    go(n, 1)
  }

  test("K: writing loops functionally - factorial p20") {
    assert(factorial(5) === 120)
  }

  def fibonacci(n: Int): Int = {
    @annotation.tailrec
    def go(n: Int, a: Int, b: Int): Int = n match {
      case 0 => a
      case _ => go(n-1, b, a+b)
    }
    go(n, 0, 1)
  }

  test("K: writing loops functionally - fibonacci p21") {
    assert(fibonacci(3) === 2)
  }

  /*
    The first new idea is this: functions are values. And just like values of other
    types—such as integers, strings, and lists—functions can be assigned to variables,
    stored in data structures, and passed as arguments to functions. When writing
    purely functional programs, we’ll often find it useful to write a function that
    accepts other functions as arguments. This is called a higher-order function (HOF).
  */
  /*
    The Strategy and State patterns could be replaced by HOF.
   */
  def formatResult(name: String, n: Int, f: (Int) => Int) = {
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))
  }

  test("K: higher-order function p21") {
    assert(formatResult("fibonacci", 3, fibonacci) === "The fibonacci of 3 is 2.")
    assert(formatResult("factorial", 5, factorial) === "The factorial of 5 is 120.")
  }
}
