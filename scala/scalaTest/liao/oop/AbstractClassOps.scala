package oop


class AbstractClassOps{
	var id : Int = _
}
abstract class SuperTeacher(val name : String){
  var id : Int
  var age : Int
  def teach
}

class TeacherForMaths(name : String) extends SuperTeacher(name){
  
  override var id = name.hashCode()
  override var age = 29
  override def teach{
    println("Teaching!!!")
  }
}


object AbstractClassOps{
  def main(args: Array[String]) {
	  val teacher = new TeacherForMaths("Spark")
	  teacher.teach
	  
	  println("teacher.id" + ":" + teacher.id)
	  println(teacher.name + ":" + teacher.age)
    
  }
}