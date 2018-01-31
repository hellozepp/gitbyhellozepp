package hello

import scala.io.Source

object FileOps {
	def main(args: Array[String]) {
//		val file = Source.fromFile("/opt/aaa.txt")
		val file = Source.fromURL("http://spark.apache.org/")
		for (line <- file.getLines){
		  println(line)
		}
	}
}