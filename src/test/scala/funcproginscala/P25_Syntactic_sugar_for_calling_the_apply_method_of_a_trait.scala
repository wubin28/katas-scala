package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by twer on 12/14/14.
 */
class P25_Syntactic_sugar_for_calling_the_apply_method_of_a_trait extends FunSuite{
/*
  Functions as values in Scala

  When we define a function literal, what is actually being defined in Scala is an
  object with a method called apply. Scala has a special rule for this method name,
  so that objects that have an apply method can be called as if they were themselves
  methods. When we define a function literal like (a, b) => a < b, this is
  really syntactic sugar for object creation:

  val lessThan = new Function2[Int, Int, Boolean] {
    def apply(a: Int, b: Int) = a < b
  }

  lessThan has type Function2[Int,Int,Boolean], which is usually written
  (Int,Int) => Boolean. Note that the Function2 interface (known in Scala
  as a trait) has an apply method. And when we call the lessThan function
  with lessThan(10, 20), it’s really syntactic sugar for calling its apply method:

  scala> val b = lessThan.apply(10, 20)
  b: Boolean = true

  Function2 is just an ordinary trait (an interface) provided by the standard
  Scala library (API docs link: http://mng.bz/qFMr) to represent function objects
  that take two arguments. Also provided are Function1, Function3, and others,
  taking a number of arguments indicated by the name. Because functions are
  just ordinary Scala objects, we say that they’re first-class values.
  We’ll often use “function” to refer to either such a first-class function
  or a method, depending on context.
*/

  test("when we call the lessThan function with lessThan(10, 20), it’s really syntactic sugar for calling its apply method. p25") {
    val lessThan = new Function2[Int, Int, Boolean] {
      def apply(a: Int, b: Int) = a < b
    }

    assert(lessThan.apply(10, 20) === true)
    assert(lessThan(10, 20) === true)

    val lessThanWithSugar = (a: Int, b: Int) => a < b

    assert(lessThanWithSugar(10, 20) === true)
  }
}
