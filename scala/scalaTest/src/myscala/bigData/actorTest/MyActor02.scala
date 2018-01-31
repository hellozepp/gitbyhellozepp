package myscala.bigData.actorTest


import scala.actors.Actor


/**
  * Created by ZX on 2016/4/4.
  */
class MyActor extends Actor {

  override def act(): Unit = {
    while (true) {
      receive { //receive是封装的偏函数，阻塞，有消息才执行
        case "start" => {
          println("starting ...")
          Thread.sleep(5000)
          println(Thread.currentThread().getName)
          println("started")
        }
        case "stop" => {
          println("stopping ...")
          //Thread.sleep(8000)
          println(Thread.currentThread().getName)
          println("stopped ...")
        }
      }
    }
  }
}

class YourActor extends Actor {
  override def act(): Unit = {
    loop {//对线程池进行复用，比 receive效率高
      react {
        case "start" => {
          println("starting ...")
          Thread.sleep(5000)
          println(Thread.currentThread().getName)
          println("started")
        }
        case "stop" => {
          println("stopping ...")
          Thread.sleep(8000)
          println(Thread.currentThread().getName)
          println("stopped ...")
        }
        case "exit" => {
          exit() //actor的退出方法
        }
      }
    }
  }
}


object Boot {

  def main(args: Array[String]) {
//    val actor = new MyActor
//    actor.start()
//    actor ! "start"
//    actor ! "stop"
//    println("消息发送完成！")
//
//    actor ! "stop"

    val a2 = new YourActor
    a2.start()
    a2 ! "start"
    a2 ! "stop" //对于一个actor是串行的
    Thread.sleep(10000)
    a2 ! "exit"

//    val a3 = new YourActor
//    a3.start()
//    a3 ! "start"


  }
}
