package myscala.basic
//千万不要起和报名相同的名字
import collection.mutable.ListBuffer

/**
  * Created by docker on 2017/7/18.
  */
class ListBufferTest{


}
object ListBufferTest{
  def main(args:Array[String]):Unit={
    var list1 = new ListBuffer[Int]
    list1.append(1)
    list1.append(1)
    list1.append(1)
    list1.append(1)
    list1.append(1)

    for (i<-list1){
      println(list1(i))
    }

    var a= list1(3)//java list.get(3)
    println("::::::"+a)

    val list = List(1,2,3,4,5,6,7,8,9)
    increment(list)
    increment_MoreEffective(list)
    increment_MostEffective(list)



  }
  def increment(list :List[Int]) : List[Int] = list match {//函数建立堆栈需要消耗大量的内存
    case List() => List()
    case head :: tail => head + 1 :: increment(tail)
  }

  def increment_MoreEffective(list : List[Int]) : List[Int] = {
    //比上边那种有较少的内存消耗。理论上讲支持所有元素个数。但是这里会产生很多种中间结果的list对象，效率是非常低的。
  var result = List[Int]()
    for(element <- list) result = result ::: List(element + 1)
    result
  }

  def increment_MostEffective(list: List[Int]) : List[Int] = {
    //最高效、既能够使用循环遍历，又会避免创建那么多的中间对象，就引入了ListBuffer
    import scala.collection.mutable.ListBuffer  //可变
    var buffer = new ListBuffer[Int]
    for(element <- list) buffer += element + 1
    buffer.toList
  }
}
