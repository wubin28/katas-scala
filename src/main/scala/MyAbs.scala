/**
 * Created by ben on 11/16/14.
 */
class MyAbs {
  def formatAbs(x: Int) = {
    val msg = "The absolute value of %d is %d"
    msg.format(x, abs(x))
  }

}
