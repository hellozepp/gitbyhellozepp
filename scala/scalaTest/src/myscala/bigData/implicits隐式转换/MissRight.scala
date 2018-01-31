package cn.itcast.day4

/**
  * Created by ZX on 2016/4/14.
  */
class MissRight[T] {

  def choose(first: T, second: T)(implicit ord : T => Ordered[T]): T = {
    if(first > second) first else second
  }

  def select(first: T, second: T)(implicit ord : Ordering[T]): T ={
    if(ord.gt(first, second)) first else second
  }

  def random(first: T, second: T)(implicit ord : Ordering[T]): T ={
    import Ordered.orderingToOrdered
    if(first > second) first else second
  }

}

object MissRight {
  def main(args: Array[String]) {
    val mr = new MissRight[Girl]
    val g1 = new Girl("hatanao", 98, 28)
    val g2 = new Girl("sora", 95, 33)

    import MyPreDef.girlOrdering
    //val g = mr.choose(g1, g2)
    val g = mr.select(g1, g2)
    println(g.name)
  }
}
