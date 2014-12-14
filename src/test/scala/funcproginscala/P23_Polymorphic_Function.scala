package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by ben on 11/19/14.
 */
class P23_Polymorphic_Function extends FunSuite{

/*
  The following monomorphic function, findFirst, returns the first index in an
  array where the key occurs, or -1 if it’s not found. It’s specialized for
  searching for a String in an Array of String values.
*/

  test("K: monomorphic function to find a string in an array p23") {
    def findFirst(ss: Array[String], key: String): Int = {
      @annotation.tailrec
      def loop(n: Int): Int =
        if (n >= ss.length) -1 else if (ss(n) == key) n else loop(n + 1)
      loop(0)
    }
    assert(findFirst(Array("Susan", "Ben", "Louis"), "Ben") === 1)
  }

/*
  This is an example of a polymorphic function, sometimes called a generic function.
  We’re abstracting over the type of the array and the function used for searching it.
  To write a polymorphic function as a method, we introduce a comma-separated list of
  type parameters, surrounded by square brackets (here, just a single [A]), following
  the name of the function, in this case findFirst. We can call the type parameters
  anything we want—[Foo, Bar, Baz] and [TheParameter, another_good_one] are valid
  type parameter declarations—though by convention we typically use short, one-letter,
  uppercase type parameter names like [A,B,C].

  The type parameter list introduces type variables that can be referenced in the
  rest of the type signature (exactly analogous to how variables introduced in the
  parameter list to a function can be referenced in the body of the function). In
  findFirst, the type variable A is referenced in two places: the elements of the
  array are required to have the type A (since it’s an Array[A]), and the p function
  must accept a value of type A (since it’s a function of type A => Boolean).
  The fact that the same type variable is referenced in both places in the type
  signature implies that the type must be the same for both arguments, and the compiler
  will enforce this fact anywhere we try to call findFirst. If we try to
  search for a String in an Array[Int], for instance, we’ll get a type mismatch error.

*/
  test("K: polymorphic function to find an element in an array p23") {
    def findFirst[T](as: Array[T], p: (T) => Boolean): Int = {
      @annotation.tailrec
      def loop(n: Int): Int =
        if (n >= as.length) -1 else if (p(as(n))) n else loop(n + 1)
      loop(0)
    }
    assert(findFirst(Array(6, 9, 5, 7), (x: Int) => x == 5) === 2)
  }

  test("Exercise 2.2: Implement isSorted which checks whether an Array[A] is sorted according to a given comparison function p24") {
    def isSorted[T](as: Array[T], ordered: (T, T) => Boolean): Boolean = {
      if (as.length <= 1) return true
      def loop(n: Int): Boolean = {
        if (n >= as.length) true else if (!ordered(as(n-1), as(n))) false else loop(n + 1)
      }
      loop(1)
    }
    assert(isSorted(Array(6, 9, 5, 7), (x: Int, y: Int) => x < y) === false)
    assert(isSorted(Array(5, 6, 7, 9), (x: Int, y: Int) => x < y) === true)
  }
}
