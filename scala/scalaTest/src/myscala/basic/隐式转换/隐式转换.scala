package myscala.basic.隐式转换

class 隐式转换 {

}

object Context{   //放调用者后面就不能用了，可以从外面导入
  implicit val name:String ="呵呵哒" //只根据类型模式匹配
}


object 隐式转换{
  def sayHai()(implicit name: String="默认值"):Unit={
    println(s"name is $name")
  }
  def main(args:Array[String]):Unit={
    import Context._
//   val a = sayHai()(_) //颗粒化的操作
   sayHai() //implicit的操作

  }
}