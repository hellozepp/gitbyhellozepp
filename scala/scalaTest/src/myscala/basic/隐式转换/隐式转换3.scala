package myscala.basic.隐式转换
import java.io.File


import scala.io.Source



class 隐式转换3(f:File){
  def read1():String={
    Source.fromFile(f).mkString
  }
//  def todo():String={
//    Source.fromFile(f).mkString
//  }
}
object 隐式转换3 extends App{
  import MyRef._
  var str = new File("test.txt").read1()
  println(str)
//  Console print MyRef.todo(new File("test.txt"))
  import Rev.RichFile
  private val string1 = new File("test.txt").todo()
  println(string1)
}

