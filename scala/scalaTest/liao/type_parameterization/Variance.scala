package type_parameterization


class Person
class Student extends Person
class C[+T](val args: T)
class S[+T](arg : T) extends C[T](arg)
trait Friend[-T]{
  def makeFriend(somebody: T)
}

object Variance {
  def makeFriendWithYou(s: Student, f: Friend[Student]){f.makeFriend(s)}
  def main(args: Array[String]) {
    val value : C[Person] = new C[Student](new Student)

//    List<? extends Oject> list = new ArrayList<String>()
    val list : List[_ <: Any] = List[String]("Spark")
  }

}