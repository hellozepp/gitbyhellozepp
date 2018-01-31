package myscala.basic

/**
  * Created by docker on 2017/5/22.
  * 匿名函数
  * 箭头左边是参数列表，右边是函数体。
  * 属性名 参数类型 lambda 推导出具体方法
  */
object Niminghanshu{
  def main(args: Array[String]): Unit = {
    var inc = (x:Int) =>x+3
    // （底层实现）
    var incc = new Function1[Int,Int]{
      def apply(x:Int):Int=x+3
    }
   Console println inc(1)
   Console println  incc.apply(1)
    //无参
    var userDir = () => { System.getProperty("user.dir") }

  }
}