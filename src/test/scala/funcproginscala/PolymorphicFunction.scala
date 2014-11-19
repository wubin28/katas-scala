package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by ben on 11/19/14.
 */
class PolymorphicFunction extends FunSuite{

  test("K: monomorphic function to find a string in an array p23") {
    def findFirst(ss: Array[String], key: String): Int = {
      @annotation.tailrec
      def loop(n: Int): Int =
        if (n >= ss.length) -1 else if (ss(n) == key) n else loop(n + 1)
      loop(0)
    }
    assert(findFirst(Array("Susan", "Ben", "Louis"), "Ben") === 1)
  }

  def findFirst[T](as: Array[T], p: (T) => Boolean): Int = {
    @annotation.tailrec
    def loop(n: Int): Int =
      if (n >= as.length) -1 else if (p(as(n))) n else loop(n + 1)
    loop(0)
  }

  test("K: polymorphic function to find an element in an array p23") {
    assert(findFirst(Array(6, 9, 5, 7), (x: Int) => x == 5) === 2)
  }
}
