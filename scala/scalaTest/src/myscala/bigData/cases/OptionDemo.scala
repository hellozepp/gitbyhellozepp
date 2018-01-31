package myscala.bigData.cases


object OptionDemo { //option 代表结果可能有可能无 是一个抽象类，None 和 some是子类
  def main(args: Array[String]) {
    val map = Map("a" -> 1, "b" -> 2)

    val v = map.get("b") match {
      case Some(i) => i
      case None => 0
    }
    println(v)
    //更好的方式
    val v1 = map.getOrElse("c", 0)
    println(v1)
  }
}
