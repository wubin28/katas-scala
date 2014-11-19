package funcproginscala

import funcproginscala.cafe.{Cafe, CreditCard}
import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class SideEffects extends FunSuite{
  // TODO: Move to upper package
  test("the cost of one coffee should be 18 dollars with side effects p4") {
    val cc = new CreditCard
    val cafe = new Cafe

    // Assert
    assert(cafe.buyCoffee(cc)._2.cost === 18)
  }

  test("the cost of 12 coffees should be 216 dollars without side effects p7") {
    val cc = new CreditCard
    val cafe = new Cafe

    // Assert
    assert(cafe.buyCoffees(cc, 12)._2.cost === 216)
  }
}
