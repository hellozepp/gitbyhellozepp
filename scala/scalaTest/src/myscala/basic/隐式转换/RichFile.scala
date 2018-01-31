package myscala.basic.隐式转换

import java.io.File

import scala.io.Source
import scala.language.implicitConversions
import MyPreDif._

object MyPreDif{ //必须是单例对象
  implicit def file2RichFile(file: File):RichFile = new RichFile(file)
}

class RichFile(file: File) {
  def read(): String = Source.fromFile(file).mkString
}
object RichFile extends App{
  private val file:RichFile = new File("/opt/projects/hadoop2/scalaTest/test.txt")
  Console println file.read()
}
