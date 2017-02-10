package zengqiang;


/**
 * Created by hadoop on 16-9-9.
 * 通过使用继承使功能增强
 */
public class Demo1 {
    public static void main(String[] args) {
        Person2 person2 =new Student1();
        person2.eat();
    }

}

class Person2{
    public Person2() {
        System.out.println("人的向上抽取");//構造器會會默認調用
    }

    public void  eat(){
        System.out.println("两个馒头");
    }
    public void jump(){
        System.out.println("吃完了跳个跳！！！");
    }
}
class Student1 extends Person2{
    public Student1() {
//        super();//默认就会有 必须首行 必须在构造器里//构造其去不掉
        System.out.println("public Student1（）还有用");
    }

    @Override
    public void  eat(){
//        super.eat();//调用父类的eat
//        super.jump();
        System.out.println("加倆雞腿");
    }
}
