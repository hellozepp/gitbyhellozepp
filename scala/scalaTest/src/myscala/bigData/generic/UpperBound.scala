package myscala.bigData.generic


/**
  * Created by ZX on 2016/3/31.
  *  <:上界
  *  >:下界
  *  :上下文
  *  <% 视图界定
  *
  * 在scala中泛型与java中的表示方式不同用"[]"
  * 例如[T <: Comparable[T]]表示上界，传入的为Comparable的子类
  */
class Pair[T <% Comparable[T]](val first: T, val second: T){
  def bigger = if(first.compareTo(second) > 0) first else second
}

class UpperBound[T<:Comparable[T]]{ //正数或-数
  def bigger1(first:T,second:T) = if(first.compareTo(second)>0) first else second
}

object UpperBound {
  def main(args: Array[String]) {
    val p = new Pair(1, 5)
    println(p.bigger)

//    val p1 =new UpperBound[Int]
//    println(p1.bigger1(1,2)) //报错，Int没有comparable

    val p2 =new UpperBound[Integer]
    println(p2.bigger1(1,2)) //报错，Int没有comparable
  }
}




