package myscala.basic

import java.awt.Point

/**
  * Created by docker on 2017/5/22.
  * 特质
  */
//作为借口使用
object Tezhi {
  def main(args: Array[String]): Unit = {
    val p1 = new Point(2, 3)
    val p2 = new Point(2, 4)
    val p3 = new Point(3, 3)

    println(p1.isNotEqu(p2)) //false
    println(p1.isNotEqu(p3))//true
    println(p1.isNotEqu(2)) //true
  }

  class Point(xc: Int, yc: Int) extends chuai {
    var x: Int = xc
    var y: Int = yc

    def isEquals(obj: Any): Boolean =
      obj.isInstanceOf[Point] &&
        obj.asInstanceOf[Point].x == x
  }

}

trait chuai {
  def isEquals(x: Any): Boolean

  def isNotEqu(x: Any): Boolean = !isEquals(x)

  def write(msg: String) {
    println(msg)
  } //特质可以写方法
}