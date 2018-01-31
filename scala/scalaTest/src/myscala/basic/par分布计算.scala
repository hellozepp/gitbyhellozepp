package myscala.basic

class par分布计算 {

}
object par分布计算{
  def main(args: Array[String]): Unit = {
    val v1 = Vector(1 to 20)//这种写法返回的不是v,是range对象
    //Vector(Range(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20))
    println(v1)
    val v = Vector(1,2,3,4,5)
    var b = v.par.fold(0)(_+_)
    val li = List(1,2,3,4,5).par //并行化集合
    println("//折叠")
    var c = li.fold(0)(_+_)
    println("//聚合")
    var arr = List(List(1,2,3),List(2,3),List(3),List(0))
    var jvhe=arr.aggregate(0)(_+_.size,_+_)//3+2+1+1
    jvhe=arr.aggregate(10)(_+_.sum,_+_)//24
    var jvhe1=arr.par.aggregate(10)(_+_.sum,_+_)//54
    println(jvhe)
    println(jvhe1)
  }
}