package myscala.basic

class wordCount {

}
object wordCount extends App{
  val lines = List("hello tom hello jerry", "hello jerry", "hello kitty")
  lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2))
  private val counter = lines.flatMap(_.split(" ")).map((_, 1)).groupBy(_._1).map(t=>(t._1, t._2.size)).toList.sortBy(_._2).reverse
  println(counter)

  lines.flatMap(_.split(" ")).grouped(3)//分成3个一组
  lines.flatMap(_.split(" ")).map((_,1)).groupBy(_._1).mapValues(_.foldLeft(0)(_+_._2)).toList.sortBy(_._2).reverse

}