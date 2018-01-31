package myscala.bigData.cases


import scala.util.Random

/**
  * Created by ZX on 2016/4/5.
  */
object CaseDemo01 extends App {

  val arr = Array("YoshizawaAkiho", "YuiHatano", "AoiSola")
  val name = arr(Random.nextInt(arr.length))
  println(name)
  name match {
    case "YoshizawaAkiho" => println("吉泽老师...")
    case "YuiHatano" => println("波多老师...")
    case _ => println("真不知道你们在说什么...")
  }

}
