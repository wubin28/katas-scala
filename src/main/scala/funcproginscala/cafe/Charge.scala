package funcproginscala.cafe

/**
 * Created by ben on 11/17/14.
 */
case class Charge(cc: CreditCard, cost: Int) {
  def combine(other: Charge): Charge =
    if (cc == other.cc)
      Charge(cc, cost + other.cost)
    else
      throw new Exception("Can't combine charges to different cards")
}
