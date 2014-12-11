package proginscala

import org.scalatest.FunSuite

/**
 * Created by ben on 11/4/14.
 */
class ProgInScalaCh02 extends FunSuite{
  test("a val can never be reassigned but a var can") {
//    val msg = "Hello, world!"
//    msg = "Goodbye cruel world!" // Got "error: reassignment to val"
//    assert(msg === "Goodbye cruel world!")

    var anotherMsg = "Hello, world!"
    anotherMsg = "Goodbye cruel world!"
    assert(anotherMsg === "Goodbye cruel world!")

  }

  test("define a function leaving the result type and curly braces off") {
    def max(x: Int, y: Int) = if (x > y) x else y
//    def max(x, y) = if (x > y) x else y // Scala does not infer function parameter type p72
    assert(max(5, 7) === 7)
  }

  test("checking whether option has value") {
    def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
      if (flag) Some("Found value") else None
    }

    val value1 = maybeItWillReturnSomething(true)
    val value2 = maybeItWillReturnSomething(false)

    assert(value1.isEmpty === false)
    assert(value2.isEmpty === true)

  }

  test("a result type of Unit (could be leaving off) indicates the function returns no interesting value p74") {
    def greet() : Unit = println("Hello, world!")
    val value = greet()
  }

  test("you must say if (i < 10) in Scala") {
    val i = 3
    if (i > 2) println("i > 2")
//    if i > 2 println("i > 2") // you can’t say in Scala things like if i < 10 as you can in a language such as Ruby p77
  }
}


