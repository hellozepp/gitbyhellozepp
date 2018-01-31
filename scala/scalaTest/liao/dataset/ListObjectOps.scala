package dataset


object ListObjectOps {

  def main(args: Array[String]) {
    println(List.apply(1, 2, 3))
    println(List.make(3, 5))
    println(List.range(1, 5))
    println(List.range(9, 1, -3))
    
    val zipped = "abcde".toList zip List(1, 2, 3, 4, 5)
    println(zipped)
    println(zipped.unzip)
    
    println(List(List('a', 'b'), List('c'), List('d', 'e')).flatten)
    println(List.concat(List(), List('b'), List('c')))
 
    println(List.map2(List(10, 20), List(10, 10)) (_ * _))
  
  }

}