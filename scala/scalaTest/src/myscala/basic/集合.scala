object 集合 {
  println("---------Array-----------")

  //  Array
  var arr = new Array[Int](10)
  var arr1 = Array(1, 2, 3, 4, 5, 6)
  //创建长度为1的array
  var arr2 = Array[Int](10)

  import scala.collection.mutable.ArrayBuffer

  var ab = ArrayBuffer(1, 2, 3)
  ab += 1
  println(ab)
  ab ++= ArrayBuffer(2, 2, 3, 1)
  println(ab)
  ab.insert(0, 0, 0, 0)
  println(ab)
  ab.remove(1, 2) //角标为1干掉两个
  println(ab)
  println("翻转range")
  for (i <- (0 until (ab.length)).reverse) {
    println(ab(i))
  }
  ab.map(println(_))
  ab.filter(x => x % 2 == 0)
  ab.filter(_ % 2 == 0)
  ab.sum
  ab.sorted.reverse
  ab.sortBy(x => x)
  ab.sortWith(_ > _) //从大到小
  ab.sortWith(_ < _)
  ab.sortWith((x, y) => x < y)
  println("---------Map-----------")
  //是一个对偶元祖
  val m = Map("1" -> "a", 2 -> "b", 3 -> "c")
  println(m("1"))
  //  m("1")=3 //不能修改
  import scala.collection.mutable.Map

  var m2 = Map("1" -> "a", 2 -> "b", 3 -> "c")
  m2("1") = "3" //修改
  m2.put("1", "b") //key不重复，无序
  println(m2)
  println(m2.get("c"))
  println(m2.getOrElse("c", "none"))
  val yuanzu = ("t" -> 6)
  //    m2+=(("t",6))
  //  m2+=yuanzu //不支持

  //  import java.util.HashMap
  //  import java.lang.{String=>JString}
  //  val mm = new HashMap()
  //  private val str = new JString("1")
  //  mm.put(1,str)
  import scala.collection.mutable.HashMap

  val map11 = new HashMap[String, Int]()
  map11("spark") = 1
  map11 += (("hadoop", 2))
  map11.put("storm", 3)
  println(map11)

  //从map中移除元素
  map11 -= "spark"
  map11.remove("hadoop")
  println(map11)


  def flatMap1(): Unit = {
    val li = List(1, 2, 3)
    val res = li.flatMap(x => x match {
      case 3 => List('a', 'b')
      case _ => List(x * 2)
    })
    println(res)
  }

  def map1(): Unit = {
    val li = List(1, 2, 3)
    val res = li.map(x => x match {
      case 3 => x - 1
      case _ => x * 2
    })
  }

  def main(args: Array[String]) {
    flatMap1()
    map1()
    val foo =
      """菜鸟教程
      www.runoob.com
      www.w3cschool.cc
      www.runnoob.com
      以上三个地址都能访问"""


    println("---------tuple-----------")
    val tup = (1, "1", 2.0)
    //角标从1开始
    println(tup._3)

    val t, (x, y, z) = ("1", "2", "3") //直接去tuple的值
    println(x)
    //对偶元组转换成map
    val a = Array((1, 1), (2, 3))
    println(a.toMap)
    println("//拉链")
    val aa = Array(x, y, z)
    val bb = Array("1", "2", "3") //没匹配到的不要了

    println(aa.zip(bb)) //变成一个对偶元祖的array

  }
}
