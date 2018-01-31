package function


object ClosureOps {//闭包
	def main(args: Array[String]) {
		val data = List(1, 2, 3, 4, 5, 6)
		var sum = 0
		data.foreach(sum += _)
		data.foreach(x=>sum+=x)
		println("1 ",data)
//		println("2 ",data.foreach(x=>x+=sum)) //错误的写法
		println(3,sum)
//颗粒化
		def add(more: Int) = (x: Int) => x + more
		val a = add(1)
		val b = add(9999)
		println(a(10))
		println(b(10))
	}
}