import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class FuncProgInScalaCh01 extends FunSuite{

  test("the result of function buyCoffee() of class Cafe should be a Coffee with side effects p4") {
    val cc = new CreditCard
    val cafe = new Cafe

    // Assert
    assert(cafe.buyCoffee(cc).getClass === (new Coffee(18)).getClass)
  }
}
