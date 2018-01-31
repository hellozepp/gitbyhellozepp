package hello

class HelloScala{
  println("AAAAAAAAAA")
}
object HelloScala {


  println("Please input some words blow......")

  def main(args: Array[String]){
    val hs=new HelloScala
    println("Hello Scala!!!A new World!!!")
    for(arg <- args) println(arg)
  }

}