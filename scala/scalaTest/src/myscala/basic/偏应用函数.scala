package myscala.basic

import java.util.Date


/**
  * Created by docker on 2017/5/22.
  * 偏函数 把不变化的变量优化成另一个函数，提前写好了此变量，不用每次赋值
  */
class 偏应用函数 {

}

object 偏应用函数 {
  def main(args: Array[String]): Unit = {
    //定义people对象，写在偏函数pian下面会报错，未定义
    /**
      * Error:(19, 16) forward reference extends over definition of value pian
      * val pian = peoples(_:String,date)
      **/
    def peoples(name: String, view: Date) = {
      Console println view + "..." + name
    }

    val date = new Date
    //片函数方式定义
    val pian = peoples(_: String, date)


    //    pian("zhnag")

    val date1 = new Date
    //
    val logWithDateBound = log(date1, _: String)

    logWithDateBound("message1")
    Thread.sleep(1000)
    logWithDateBound("message2")
    Thread.sleep(1000)
    logWithDateBound("message3")
  }

  def log(date: Date, message: String) = {
    println(date + "----" + message)
  }
}
