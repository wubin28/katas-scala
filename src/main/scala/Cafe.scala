/**
 * Created by ben on 11/17/14.
 */
class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee(18)
    (cup, new Charge(cc, cup.price))
  }

}
