package function


object Curring {

  def main(args: Array[String]) {
    def multiple(x: Int, y: Int) = x * y
    def multipleOne(x: Int) = (y: Int) => x * y
    println(multipleOne(6)(7))
    
    def curring(x: Int)(y: Int) = x * y
    
    println(curring(10)(10))

    val a = Array("Hello", "Spark")
    val b = Array("hello", "spark")
    println(a.corresponds(b)(_.equalsIgnoreCase(_)))
    
  }

}