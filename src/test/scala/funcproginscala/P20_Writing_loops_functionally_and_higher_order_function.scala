package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by twer on 12/13/14.
 */
class P20_Writing_loops_functionally_and_higher_order_function extends FunSuite {
/*
  Tail calls in Scala

  A call is said to be in tail position if the caller does nothing other than
  return the value of the recursive call. For example, the recursive call to
  go(n-1,n*acc) we discussed earlier is in tail position, since the method
  returns the value of this recursive call directly and does nothing else
  with it. On the other hand, if we said 1 + go(n-1,n*acc), go would no
  longer be in tail position, since the method would still have work to do
  when go returned its result (namely, adding 1 to it).

  If all recursive calls made by a function are in tail position, Scala
  automatically compiles the recursion to iterative loops that don’t consume
  call stack frames for each iteration. By default, Scala doesn’t tell us
  if tail call elimination was successful, but if we’re expecting this to
  occur for a recursive function we write, we can tell the Scala compiler
  about this assumption using the tailrec annotation (http://mng.bz/ bWT5),
  so it can give us a compile error if it’s unable to eliminate the tail
  calls of the function.
*/
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
