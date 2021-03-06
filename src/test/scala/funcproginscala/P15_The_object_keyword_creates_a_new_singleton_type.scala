package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by ben on 11/15/14.
 */
class P15_The_object_keyword_creates_a_new_singleton_type extends FunSuite{

/*
  The object keyword creates a new singleton type, which is like a class that
  only has a single named instance. If you’re familiar with Java, declaring
  an object in Scala is a lot like creating a new instance of an anonymous class.

  Scala has no equivalent to Java’s static keyword, and an object is often
  used in Scala where you might use a class with static members in Java.
*/

  test("a simple scala program of ABS - object version p15") {
    // Arrange
    object MyAbsObject {

      private def abs(n: Int): Int = if (n < 0) -n else n

      def formatAbs(x: Int) = {
        val msg = "The absolute value of %d is %d"
        msg.format(x, abs(x))
      }
    }
    // Act, Assert
    assert(MyAbsObject.formatAbs(-42) === "The absolute value of -42 is 42")
  }

  test("a simple scala program of ABS - class version p15") {
    // Arrange
    class MyAbs {

      private def abs(n: Int): Int = if (n < 0) -n else n

      def formatAbs(x: Int) = {
        val msg = "The absolute value of %d is %d"
        msg.format(x, abs(x))
      }
    }

    val myAbs = new MyAbs
    // Act, Assert
    assert(myAbs.formatAbs(-42) === "The absolute value of -42 is 42")
  }
}
