package proxy.duotai;

/**
 * Created by hadoop on 2017/1/21.
 */
public class Yinyong {
    public static void main(String[] args) {
        A a =new B();
        a.method();
        a.method1();
    }
}
class A{
    A(){
        System.out.println("a的构造器");
    }
    void method(){
        System.out.println("method ->a");
    }

     void method1() {
         System.out.println("method111 ->a");
    }
}
class B extends A {
    B(){
        super();
        System.out.println("b的构造器");
    }
    void method(){
        System.out.println("method ->b");
    }
    void method1(){
        new A().method1();
        System.exit(1);
        System.out.println("method111 ->b");
    }
}