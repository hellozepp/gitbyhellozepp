object ListDemo {
  //mutable
  println("=====创建一个可变的集合=======")
  import scala.collection.mutable.ListBuffer
  //构建一个可变列表，初始有3个元素1,2,3
  val lst0 = ListBuffer[Int](1,2,3)
  //创建一个空的可变列表
  val lst1 = new ListBuffer[Int]
  //向lst1中追加元素，注意：没有生成新的集合
  lst1 += 4
  lst1.append(5,6,7,8,9 )
  println(lst1)
  //将lst1中的元素追加到lst0中， 注意：没有生成新的集合
  lst0 ++= lst1

  //将lst0和lst1合并成一个新的ListBuffer 注意：生成了一个集合
  val lst2= lst0 ++ lst1
  println("list2::::: is :"+lst2)
  //将元素追加到lst0的后面生成一个新的集合
  val lst3 = lst0 :+ 5
  val lst5= lst0 +: lst1

  val list1 = List(1,2,3,1)
  list1.sorted
  println(list1)
  var gr = list1.grouped(3)//三个一组
  println(gr.next())
  println(gr.next())
//  println(gr.next())//java.lang.ExceptionInInitializerError
  list1.grouped(3).toList.flatten //转成list并展开

  val list2 = List("hello zepp  hello zepp hello zepp hello zepp ","hello zepphello zepphello zepphello zepp")
  val list = list2.flatMap(_.split(" "))//按一个空格split
  println(list2)
  println(list)


  def main(args: Array[String]) {
    //immutable
    println("=====创建一个不可变的集合========")
    val lst1 = List(1,2,3)
    //将0插入到lst1的前面生成一个新的List
    //元素操作

    val lst2 = 0 :: lst1
    val lst3 = lst1.::(0)
    val lst4 = 0 +: lst1
    val lst5 = lst1.+:(0)

    //将一个元素添加到lst1的后面产生一个新的集合
    val lst6 = lst1 :+ 3
    val lst0 = List(4,5,6)
    //将2个list合并成一个新的List

    //集合操作
    val lst7 = lst1 ++ lst0
    //将lst1插入到lst0前面生成一个新的集合
    val lst8 = lst1 ++: lst0

    //将lst0插入到lst1前面生成一个新的集合
    val lst9 = lst1.:::(lst0)

    println(lst9)



  }
}