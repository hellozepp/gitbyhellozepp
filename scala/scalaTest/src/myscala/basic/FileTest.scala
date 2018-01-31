package myscala.basic
import java.io._

import scala.io.Source

object FileTest {
  def main(args: Array[String]) {
    val writer = new PrintWriter(new File("test.txt" ))

    writer.write("Hello Scala")
    writer.close()
    def read() = Source.fromFile("test.txt").mkString
  }
}