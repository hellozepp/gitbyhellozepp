import scala.collection.immutable.HashSet

class SetDemo{
    //创建一个可变的HashSet
    import scala.collection.mutable.HashSet
    val set1 = new HashSet[Int]()
    //向HashSet中添加元素
    set1 += 2
    //add等价于+=
    set1.add(4)
    set1 ++= Set(1,3,5)
    println(set1)
    //删除一个元素
    set1 -= 5
    set1.remove(2)
    println(set1)
}

object SetDemo extends App{
  val set1 = new HashSet[Int]()
  //将元素和set1合并生成一个新的set，原有set不变
  val set2 = set1 + 4
  //set中元素不能重复
  val set3 = set1 ++ Set(5, 6, 7)
  val set0 = Set(1,3,4) ++ set1
  println(set0.getClass)
  new SetDemo()
}
