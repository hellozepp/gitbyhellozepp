package hello


object ScalaBasics {

    def looper(x : Long, y : Long) : Long = {
    var a = x
    var b = y
    while(a != 0){
      val temp = a
      a = b % a
      b = temp
    }
    b
  }
  
 
//	  var line = ""
//	  do {
//	    println("Please input some words blow......")
//	    line = readLine()
//	    println("Read: " + line)
//	  } while (line != "")

	    
//	    
//	    
//	    
//	    
//	    
  def doWhile(){
	  var line = ""
			  do {
				  line = readLine()
				  println("Read: " + line)
			  } while (line != "")
  }
  
  
  def main(args: Array[String]){
//    println("This is Spark!!!")
//    for(arg<-args) println(arg)
//
//
//    var file = "scala.txt"
//    if (!args.isEmpty) file = args(0)
//    file = if(!args.isEmpty) args(0) else "scala.xml"
////
//    println(file)
//
//    println(if(!args.isEmpty) args(0) else "Spark.xml")
//
//    println(looper(100, 298))
////    doWhile
////
//	for (i <- 1.to(10)) {
//	  println("Number is :" + i)
//	}
//////
//	val files = (new java.io.File(".")).listFiles()
//	for (file <- files){
//	  println(file)
//	}
//    
//    
	
    
    
    val n = 99
    val file1 = "Spark.txt"
//    打开文件
    try {
	    val half = if (n % 2 == 0) n /2 else throw
        new RuntimeException("N must be event")
	    // 使用文件
    }catch {
      case e : Exception => println("The exception is :",e)
    }finally{
//      关闭文件
    }
    
  }

}