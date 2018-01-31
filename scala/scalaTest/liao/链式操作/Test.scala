package demo

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.util.control.Breaks

/**
  * Created by andilyliao on 17-5-8.
  */
class IntList(){
  private var list:ListBuffer[Int]=new ListBuffer[Int];
//  private[this] var _name: String = _

  def myMap(f:(Int)=>Int):IntList={
    val intList=new IntList
    var k=0
    for(i<-list){
      intList.list+=f(list(k))
      k=k+1
    }
    intList
  }

  override def toString: String = {
    var s:String=""
    for(c<-list) s=s+","+c
    "IntList:["+s.substring(1,s.length)+"]"
  }
  
}
object IntList{
  def apply(is:Int*): IntList = {
    val intList=new IntList
    for(j<-is){
      intList.list+=j
    }
    intList
  }
}
object Test{

  def main(args: Array[String]): Unit = {
    val a=IntList(1,2,3,4,5)
    println(a)
    println(a.myMap(_+1))
    println(a.myMap(_+1).myMap(_+1))
    println(a)
  }

}
