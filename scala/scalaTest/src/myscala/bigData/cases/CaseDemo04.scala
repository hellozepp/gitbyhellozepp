package myscala.bigData.cases


import scala.util.Random

/**
  * Created by ZX on 2016/4/5.
  */
case class SubmitTask(id: String, name: String) //不谢参数的方法已经废弃不提供使用 case class多例

case class HeartBeat(time: Long)

case object CheckTimeOutTask //谢参数会报错 单例对象

object CaseDemo04 extends App{

  val arr = Array(CheckTimeOutTask, HeartBeat(12333), SubmitTask("0001", "task-0001"))


  val a = CheckTimeOutTask
  val b = CheckTimeOutTask
  println(s"$a $b")
  arr(Random.nextInt(arr.length)) match {
    case SubmitTask(id, name) => {
      println(s"$id, $name")
    }
    case HeartBeat(time) => {
      println(time)
    }
    case CheckTimeOutTask => {
      println("check")
    }
  }
}
