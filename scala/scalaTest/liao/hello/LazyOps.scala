package hello

import scala.io.Source

object LazyOps {

  def main(args: Array[String]): Unit = {
    lazy val file = Source.fromFile("E:\\WangJlisssfsdalin.txt") 
    
    println("Scala")
    
	for (line <- file.getLines) println(line)
    
  }

}