package myscala.basic.隐式转换

import java.io.File

import scala.io.Source

class 隐式转换2{
  def read(f:File):String = Source.fromFile(f).mkString
}
object 隐式转换2 {
var file = new File("test.txt")
  var str = new 隐式转换2().read(file)
  println(str)
}
