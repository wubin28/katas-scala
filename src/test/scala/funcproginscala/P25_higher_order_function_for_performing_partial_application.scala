package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by twer on 12/14/14.
 */
class P25_higher_order_function_for_performing_partial_application extends FunSuite{
  test("partial application p25") {
    def partial1[A,B,C](a: A, f: (A,B) => C): B => C = b => f(a, b)

    class Apple
    class Banana
    class Carrot

    val apple = new Apple;
    val banana = new Banana;
    val carrot = new Carrot;

    assert(partial1[Apple, Banana, Carrot](apple, (a: Apple, b: Banana) => carrot).apply(banana) === carrot)

  }
}
