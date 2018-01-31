package myscala.basic.隐式转换

class yinshizhuanhuanlei {

}
object yinshizhuanhuanlei extends App{
  val i:Int = 1
  import PreDif._
  println(i++)
   val jiajia =  1++()++()++()++()++()++()++()++()++()++()++()++()++()++()++()++()++()++()++()++()++()
  println("jiajia:"+jiajia)
  2 --()
//  println(3.+-(3)(2))
//  (2 -+ 2)(3)
  Console print "迭代求和:"+((((i++)++)++)++)
}
object PreDif{
  implicit class opts(i:Int){
    def ++():Int={
      i+i
    }
    def --():Int={
      i-i
    }
    def +-(x:Int)(y:Int):Int={
      i+x-y
    }
    def -+(x:Int)(y:Int):Int={
      i+y-x
    }
  }

}