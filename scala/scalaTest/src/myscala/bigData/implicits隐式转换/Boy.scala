package cn.itcast.day4

/**
  * Created by ZX on 2016/4/14.
  */
class Boy(val name: String, val faceValue: Int) extends Comparable[Boy]{
  override def compareTo(o: Boy): Int = {
    this.faceValue - o.faceValue
  }
}
