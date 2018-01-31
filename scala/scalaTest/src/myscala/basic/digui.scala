package myscala.basic

/**
  * Created by docker on 2017/5/22.
  */
class digui {

}
object digui{

  def factorial(i: BigInt): BigInt = {
    if (i<=1)
      1
    else  i*factorial(i-1)
  }
 Console println factorial(10)
  def factorial(i: Int): Int = {
    //局部函数 类似匿名内部类，  不用new接口实现方法，创建对象来回调
    def fact(i: Int, accumulator: Int): Int = {
      if (i <= 1)
        accumulator
      else
        fact(i - 1, i * accumulator)
    }
    fact(i, 1)
  }

  def main(args: Array[String]): Unit = {
    for (i <- 1 to 10){
      println(i+" 的阶乘为 " +factorial(i))
    }
  }
}
