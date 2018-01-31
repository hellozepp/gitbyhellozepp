package implicits

import java.io.File

import scala.io.Source

object Context_Helper{  
    implicit class FileEnhancer(file : File){    
        def read = Source.fromFile(file.getPath).mkString  
    }
    implicit class Op(x:Int){
         def a(second: Int) = x + second
    }
}
object Implicits_Class {

  def main(args: Array[String]){
    import Context_Helper._
    println(1.a(2))
    println(new File("/opt/aaa.txt").read)
    
  }
  	
}


object Context_Helper1{
  implicit class FileEnhancer(file : File){
    def read = Source.fromFile(file.getPath).mkString
  }
  implicit class Op(x:Int){
    def --(second: Int) = "primse dinied"
  }
}
object Implicits_Class1 {

  def main(args: Array[String]){
    import Context_Helper1._
    println(1.toInt.--(2.toInt))
    println(new File("/opt/aaa.txt").read)

  }

}