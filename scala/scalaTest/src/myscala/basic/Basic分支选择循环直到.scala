package myscala.basic

/**
  * Created by docker on 2017/4/14.18822623822
  */
class Basic分支选择循环直到 {

}

//function
object Basic分支选择循环直到 {
  //预定义
  //  【注：对于有返回值的函数，不能省略 等号 ；　　对于递归函数，不能省略函数返回值类型。】
  def hello(name: String = "china"): String = {
    "Hello : " + name
  }

  def main(args: Array[String]) {
    println(hello("scala"))
    println(hello())
    println(add(1, 2));
    //方法调用
    printEveryChar("a", "b", "c", "d");

    println("dddddddddddddddddd三目运算dddddddddddddddddddddd")
    val a = 1
    println(a > 1)
    val x = if (a > 0) 1 else 0; //if(true或false)
    println(x);

//    混合类型
    var z = if (a>1) 1 else "reeor";
     z = if (a>1) 1 ;//else 返回Unit
     z = if (a>1) 1 else ();

    for (i <- 1 until 10){ i
    }

    print(1 until 10)//都是函数，开区间
    print(1 to 10)//闭区间

    import scala.util.control._
    val loop = new Breaks;
    var numList = for (i <- 1 to 10) yield i
    loop.breakable {
      for (a1 <- numList) {
        println("Value of a: " + a1);
        if (a1 == 4) {
          loop.break;
        }
      }
    }

    //    while 累加到10
    var (n, r) = (10, 0)
    while (n > 0) {
      r = r + n;
      n = n - 1;
    }
    println(r)

    for (i <- 1 to 100) {
      print(i + " ")

    }
    println()
    for (i <- 1.to(10)) {
      print(i + " ")

    }
    println()
    println(r)
    println("直到型循环")
    //    直到型 到10为止，不包括10 ，until为开区间 for为闭区间
    for (i <- 1.until(10)) {
      print(i + " ")

    }
    println()

    for (i <- 1 to 10 if i % 2 == 0) {
      //守卫
      print(i + ",")
    }

    for (i <- 1 to 3; j <- 1 to 3 if i != j) {
      //多条件守卫
      print((10 * i + j) + " ");
    }
    println
  }


  //  直接写main在外面优先执行
  //出让，该循环会构造出一个集合，每次迭代生成集合中的一个值
  println("----------yield------------")

  val b = for (i <- 1 to 10) yield {
    var r = i % 3
    r
  }
  println(b
  )
  //生成 Vector(1, 2, 0, 1, 2, 0, 1, 2, 0, 1)
  println("---------分行for------------")

  for {i <- 1 until 3 //使用大括号，使用换行来分隔组
       j <- 1 until 3} {
    println(i * j)
  }
  println("----------hanshu1------------")
  //  val被声明为lazy时，变量的初始化将被延迟，直到我们首次对变量取值
  lazy val fileContent = scala.io.Source.fromFile("filename").mkString
  println(fileContent)
  //  匿名函数
  val add = (x: Int, y: Int) => {
    x + y;
  }

  //  颗粒化
  def add1(x: Int)(y: Int) = x + y;

  //  *可变参数
  def printEveryChar(c: String*) = {
    c.foreach(x => println(x))
  }

  println("----------match------------")
  var that1 = 1
  that1 match {
    case 1 => println("数值类型");
//    case "a" => print("字符串")
  }
  var that2 = "1"
  that2 match {
//    case 1 => println("数值类型");
        case "a" => print("字符串")
  }

  for (i <- 5 to 10) {
    print(" " + i)
  }
  println()
  for (i <- 5 until 11 if i >= 7) {
    print(" " + i)
  } //if 守卫
  println()
  for {
    i <- 1 to 10
    if i != 3
    if i % 3 == 1
  } {
    print(" " + i)
  }
  println()
  println("====================")
  // for 循环
  for (a <- 1.to(3); b <- 1 to 3) {
    //双重循环
    println("Value of a: " + a);
    println("Value of b: " + b);
  }
  val numList = List(1, 2, 3, 4, 5, 6);
  val aaaa = Array(1, 1, 1, 1, 1, 1)
  Console println aaaa.mkString("<", ",", ">")

  // for 循环
  for (a <- numList) {
    println("Value of a: " + a);
  }
  //    将 for 循环的返回值作为一个变量存储
  val li = List(1, 1, 1, 1, 1)
  val ress = for {i1 <- li
                  if i1 != 2} yield i1 * 3
  Console println ress
  println("======废弃=======")
  /*  import scala.util.control._
    var a = 0;
    var b = 0;
    val numList1 = List(1,2,3,4,5);
    val numList2 = List(11,12,13);

    val outer = new Breaks;
    val inner = new Breaks;

    outer.breakable {
      for( a <- numList1){
        println( "Value of a: " + a );
        inner.breakable {
          for( b <- numList2){
            println( "Value of b: " + b );
            if( b == 12 ){
              inner.break;
            }
          }
        } // 内嵌循环中断
      }
    } // 外部循环中断*/
}






