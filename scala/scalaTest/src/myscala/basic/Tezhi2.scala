package myscala.basic

/**
  * Created by docker on 2017/7/17.
  */
class Tezhi2 {

}
//相同方法采用深度遍历
object Tezhi2 extends App {
  val test = (new Default)
  test.get(1)
  val test1 = (new Default with A) //with潜入特质
  test1.get(1)
  val test2 = (new Default with A with B)
  test2.get(1)
  val test3 = (new Default with B with A)
  test3.get(1)
  val test4 = (new Default with B with A with C)
  test4.get(1)
  val test5 = (new chouxiang with C with B with A) //不用继承也能揉一块，相同的get方法
  test5.get(1)
//  val test6 = (new Noparm with C) //X
//  test6.get(1)
}

abstract class chouxiang {
  def get(x: Int) {}
}

class Default extends chouxiang {
  override def get(x: Int): Unit = {
    println("default")
  }
}

trait A extends chouxiang {
  abstract override def get(x: Int): Unit = {
    println("A")
  }
}

trait B extends chouxiang {
  abstract override def get(x: Int): Unit = {
    println("B")
  }
}

trait C extends chouxiang {
  abstract override def get(x: Int): Unit = {
    println("C")
  }
}
class Noparm{

}
