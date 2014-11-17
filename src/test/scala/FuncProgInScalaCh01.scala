import org.scalatest.FunSuite

/**
 * Created by ben on 11/17/14.
 */
class FuncProgInScalaCh01 extends FunSuite{

  test("the Cafe only sells one type of coffee which is 18 dollars for each with side effects p4") {
    val cc = new CreditCard
    val cafe = new Cafe

    // Assert
    assert(cafe.buyCoffee(cc)._2.cost === 18)
  }
}
