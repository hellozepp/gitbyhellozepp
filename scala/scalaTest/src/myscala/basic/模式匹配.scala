package myscala.basic

;

/**
  * 模式匹配
  */
case class Class1(param1: String, param2: String)

case class Class2(param1: String)

object Case {
  def main(args: Array[String]) {
    //通过模式匹配进行条件判断
    val test1: String = "1"
    val result1 = test1 match { //switch(test){case "1":return "one";break;}
      case "1" => {
        "one"
      }
      case "2" => "two"
      case _ => "other"
    }
    println(result1)

    //通过模式匹配进行条件判断，可自定义条件
    val test2: Int = 1;
    val result2 = test2 match {
      case i if i + 1 == 2 => "one"
      case i if i + 1 == 3 => "tow"
      case _ => "error"
    }
    println(result2)

    //通过模式匹配进行类型条件判断
    val t3 = 1
    println(Test3(t3))

    //通过模式匹配进行类型条件判断
    val t4 = "1"
    println(Test3((t4)))

    //通过模式匹配进行类的判断与执行
    val test5 = Class1("1", "2")
    ClassMatch(test5)

    val test6 = Class2("3")
    ClassMatch(test6)


    //  1.定义为case class 的类在实例化时，可以不使用new 关键字。
    //  2. 定义为case class 的类 默认实现了 equals 和hashcode 方法
    //
    //  3. 默认是可序列化的
    //
    //  4. 其构造函数的参数 是public 访问的。如  zhangsan.name
    case class People1(name: String, age: Int)
    val zhangsan = People1("zhangsan", 30)
    println(zhangsan)
    //    5.支持模式匹配：
    case class PhoneExt(name: String, ext: Int)
    val extensions = List(PhoneExt("steve", 100), PhoneExt("robey", 200))
    println(extensions)
    extensions.filter { case PhoneExt(name, extension) => extension < 200 }
  }

  def ClassMatch(classTest: Any): Unit = {
    classTest match {
      case Class1(param1, param2) => {
        println("Class1:" + param1 + "_" + param2)
      }
      case Class2(param1) => {
        println("Class2:" + param1)
      }
      case _ => println("error")
    }
  }

  def Test3(data: Any): String = {
    data match {
      case x: Int => "Int" //使用类型推断传入值，推导为string"Int"
      case x: String => "String"
      case _ => "unkown"
    }
  }

}