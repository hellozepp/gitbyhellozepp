val nums = new Array[Int](10)
val a = new Array[String](10)
val s = Array("Hello", "World")
s(0) = "Goodbye"
s
import scala.collection.mutable.ArrayBuffer
val b = ArrayBuffer[Int]()
b += 1
b += (1, 2, 3, 5)
b ++= Array(8, 13, 21)
b
b.trimEnd(5)
b
b.insert(2, 6)
b
b.insert(2, 7, 8, 9)
b
b.remove(2)
b
b.remove(2, 3)
b
b.toArray
b
for (i <- 0 until a.length)
  println(i + ": " + a(i))
val c = Array(2, 3, 5, 7, 11)
val result = for (elem <- c) yield  2 * elem
for (elem <- c if elem % 2 == 0) yield 2 * elem
c.filter(_ % 2 == 0).map(2 * _)
Array(1, 7, 2, 9).sum
ArrayBuffer("Mary", "had", "a", "little", "lamb").max
val d = ArrayBuffer(1, 7, 2, 9)
val bSorted = d.sorted
val e = Array(1, 7, 2, 9)
scala.util.Sorting.quickSort(e)
e
e.mkString(" and ")
e.mkString("<", ",", ">")
val matrix = Array.ofDim[Double](3, 4)
matrix(2)(1) = 42
matrix
val triangle = new Array[Array[Int]](10)
for (i <- 0 until triangle.length)
  triangle(i) = new Array[Int](i + 1)
triangle
val symbols = Array("[", "-", "]")
val counts = Array(2,5,2)
val pairs = symbols.zip(counts)
for ((x,y) <- pairs) Console.print(x*y)
val map = Map("book"->10,"gun"->18,"ipad"->1000)
for((k,v) <- map) yield (k,v * 0.9)
val scores = scala.collection.mutable.Map("Scala" -> 7, "Hadoop" -> 8, "Spark" -> 10 )
val hadoopScore = scores.getOrElse("Hadooop", 0)
scores += ("R" -> 9)
scores -= "Hadoop"
val sortedScore = scala.collection.immutable.SortedMap("Scala" -> 7, "Hadoop" -> 8, "Spark" -> 10 )
val tuple =(1,2,3.14,"Rocky","Spark")
val third = tuple._3
val (first,second,thirda,fourth,fifth) = tuple
val (f1, s2, _, _, _) = tuple
"Rocky Spark".partition(_.isUpper)
val regex="""([0-9]+) ([a-z]+)""".r
val line = "20150623 Spark"
val regex(num, blog) = line
