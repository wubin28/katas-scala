import org.scalatest.FunSuite

/**
 * Created by ben on 11/4/14.
 */
class KatasScalaSuite extends FunSuite{
  test("the answer to life the universe and everything") {
    val douglas = new KatasScala
    assert(douglas.answer() === (42))
  }
}


