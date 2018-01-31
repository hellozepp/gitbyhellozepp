package myscala.basic

;

import java.io._

class Yiibai(val xc: Int, val yc: Int) {
  val x: Int = xc //意味着没有set
  var y: Int = yc
  println("Yiibai x location : " + x); //1 10
  println("Yiibai y location : " + y);

  //2 20
  def move(dx: Int, dy: Int) {
    y = y + dy
    println("Yiibai x location : " + x);
    println("Yiibai y location : " + y);
  }
}

class Location(override val xc: Int, override val yc: Int,
               val zc: Int) extends Yiibai(xc, yc) {
  var z: Int = zc

  def move(dx: Int, dy: Int, dz: Int) {
//    x = x + dx //常量
    y = y + dy
    z = z + dz
    println("Yiibai x location : " + x); //10 + dx
    println("Yiibai y location : " + y); //20+ 10
    println("Yiibai z location : " + z); //15+5
  }
}

object Test1a {
  def main(args: Array[String]) {
    val loc = new Location(10, 20, 15);

    // Move to a new location
    loc.move(10, 10, 5);
  }
}

/**
  *构造器参数可以不带val或var，如果不带val或var的参数至少被一个方法所使用，
  *那么它将会被提升为字段
  */
//在类名后面加private就变成了私有的,只有半生能继承
class Queen private( name: String, prop: Array[String], private var age: Int = 18){

  println(prop.size)

  //prop被下面的方法使用后，prop就变成了不可变得对象私有字段，等同于private[this] val prop
  //如果没有被方法使用该参数将不被保存为字段，仅仅是一个可以被主构造器中的代码访问的普通参数
  def description = name + " is " + age + " years old with " + prop.toBuffer
}
object Queen{
  var q = new Queen("1",Array("蜡烛", "皮鞭"), 20)
//  q.prop //相当于private[this]
}




//后面写private 私有化构造器，只有半生能实例化
private class Perso1n(val id:Long,var name:String ){
  var age:Int=_
  def this(id:Long,name:String,age:Int){
    this(id,name)//必走袁构造器，想当于super
    this.age= age

  }
}
object Perso1n{
  def apply :Int ={1}

}