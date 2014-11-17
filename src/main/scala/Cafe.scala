/**
 * Created by ben on 11/17/14.
 */
class Cafe {
  def buyCoffee(cc: CreditCard): Coffee = {
    val cup = new Coffee
    cc.charge(cup.price)
    cup
  }

}
