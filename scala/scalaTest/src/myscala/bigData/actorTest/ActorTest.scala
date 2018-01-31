package myscala.bigData.actorTest

import scala.actors.Actor


/**
  * Scala Actor并发编程
  * 初识Actor
  * 2.10.6 用的是老的actor
  * 2.11 用新版本actor是AKKA
  *
  */
object MyActor1 extends Actor{
  //重新act方法
  def act(){
    for(i <- 1 to 20){
      println("actor-1 " + i)
      Thread.sleep(1000)
    }
  }
}

object MyActor2 extends Actor{
  //重新act方法
  def act(){
    for(i <- 1 to 20){
      println("actor-2 " + i)
      Thread.sleep(1000)
    }
  }
}

object ActorTest extends App{
  //启动Actor
  MyActor1.start()
  MyActor2.start()
  println("main")
}


