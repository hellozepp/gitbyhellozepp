package myscala.basic

/**
  * Created by docker on 2017/5/21.
  */
class Outer{


  class Inner{
    private def f(){println("f")}
    protected def f1(){println("f1")}
     def f2(){println("f2")}

    private[this] def d():Unit = {println("d")}
    private [myscala] def d1() {println("d1")}
    private [Inner] def d2(){}//默认
//    这里的x指代某个所属的包、类或单例对象。
    //内部类访问
    class InnerMost{
      f()
      d()
      d1()
      d2()
   def apply: InnerMost= new InnerMost()//伴生
    }

  }


//  (new Inner).f() //错误
 //   (new Inner).f1()//只有子类和半生能访问
  //  (new Inner).d() //只有该类有效
  (new Inner).d1()//可访问同包中的指定私有
//  (new Inner).d2()
  (new Inner).f2()


  class Inner1 extends Inner{
//    super.f() //私有只能自己 访问
    super.f1()
    override private[myscala] def d1() = {println("d1方法被子类覆盖")}

//    f()
//    d()
    d1()
//    d2()
  }

}
