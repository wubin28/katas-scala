package funcproginscala

import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class P4_Side_Effects extends FunSuite {

  object Cafe {
    def buyCoffeeWithSideEffects(cc: CreditCard): Coffee = {
      val cup = new Coffee(18)
      cc.charge(cup.price)
      cup
    }

    def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
      val cup = new Coffee(18)
      (cup, new Charge(cc, cup.price))
    }

    def buyCoffees(cc: CreditCard, amount: Int): (List[Coffee], Charge) = {
      val purchases: List[(Coffee, Charge)] = List.fill(amount)(buyCoffee(cc))
      val (coffees, charges) = purchases.unzip
      (coffees, charges.reduce((c1, c2) => c1.combine(c2)))
    }
  }

  class Coffee(val price: Int) {
  }

  class CreditCard {
    def charge(cost: Int): Unit = {
      // Side effect: actually connect to the web service of a bank to do charging...
    }
  }

  case class Charge(cc: CreditCard, cost: Int) {
    def combine(other: Charge): Charge =
      if (cc == other.cc)
        Charge(cc, cost + other.cost)
      else
        throw new Exception("Can't combine charges to different cards")
  }


  test("side effect: actually charges the credit card in a function p4") {
    assert(Cafe.buyCoffeeWithSideEffects(new CreditCard).price === 18);
  }

  test("the cost of one coffee should be 18 dollars with side effects p4") {
    val cc = new CreditCard

    // Assert
    assert(Cafe.buyCoffee(cc)._2.cost === 18)
  }

  test("the cost of 12 coffees should be 216 dollars without side effects p7") {
    val cc = new CreditCard

    // Assert
    assert(Cafe.buyCoffees(cc, 12)._2.cost === 216)
  }
}