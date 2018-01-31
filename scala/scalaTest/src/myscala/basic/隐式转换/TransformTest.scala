package myscala.basic.隐式转换

class TransformTest {

}
object TransformTest extends App{
  import PreDiff._
  private val str = new String("1234").nope()
  println(str)
}
trait noting{
  def nope():String
}
object PreDiff{
  implicit def transform(s:String):noting = new noting {
    override def nope(): String = "nothing to show "
  }
}