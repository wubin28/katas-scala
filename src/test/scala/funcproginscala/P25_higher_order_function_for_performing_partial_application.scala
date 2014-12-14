package funcproginscala

import org.scalatest.{FeatureSpec, GivenWhenThen}

/**
 * Created by twer on 12/14/14.
 */
class P25_higher_order_function_for_performing_partial_application extends FeatureSpec with GivenWhenThen{
  feature("Partial application of higher-order function") {
    scenario("You should get a carrot") {
      Given("My boss has a rule that if I give him an apple and a banana then I should get a carrot")
        def partial1[A, B, C](a: A, f: (A, B) => C): B => C = b => f(a, b)
        class Apple
        class Banana
        class Carrot
        val apple = new Apple;
        val banana = new Banana;
        val carrot = new Carrot;
      And("My boss has already got an apple from me")
        val myBoss = partial1[Apple, Banana, Carrot](apple, (a: Apple, b: Banana) => carrot)
      When("I give a banana to my boss")
        val whatIGot = myBoss.apply(banana)
      Then("I should get a carrot")
        assert(whatIGot === carrot)
    }
  }
}
