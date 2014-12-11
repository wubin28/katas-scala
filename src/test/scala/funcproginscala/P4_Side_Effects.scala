package funcproginscala

import funcproginscala.cafe.{Coffee, Cafe, CreditCard}
import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class P4_Side_Effects extends FunSuite{

  class CreditCard {
    def charge(cost: Int): Unit = { // Connect to the web service of a bank to do charging... }
  }

  object Cafe {
    def buyCoffeeWithSideEffects(cc: CreditCard): Coffee= {
      val cup = new Coffee(18)
      cc.charge(cup.price) // Side effect: actually charges the credit card
      cup
    }
  }

  test("side effect: actually charges the credit card in a function p4") {
    assert(Cafe.buyCoffeeWithSideEffects(new CreditCard).price === 18);
  }

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
