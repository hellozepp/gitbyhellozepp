package hello

class MapOperations{}
object MapOperations {
	def main(args: Array[String]) {
		val ages = Map("Rocky" -> 27, "Spark" -> 5) 
		
		for((k,v) <- ages){
		  println("Key is " + k + ",value is " + v)
		}
		
		for((k,_) <- ages){ //placeholder
			println("Key is " + k)
		}
				
	}
}