/**
 * Created by ben on 11/17/14.
 */
class Cafe {
  def buyCoffee(cc: CreditCard): (Coffee, Charge) = {
    val cup = new Coffee(18)
    (cup, new Charge(cc, cup.price))
  }

  def buyCoffees(cc: CreditCard, amount: Int): (List[Coffee], Charge) = {
    val purchases: List[(Coffee, Charge)] = List.fill(amount)(buyCoffee(cc))
    val (coffees, charges) = purchases.unzip
    (coffees, charges.reduce((c1,c2) => c1.combine(c2)))
  }

}
