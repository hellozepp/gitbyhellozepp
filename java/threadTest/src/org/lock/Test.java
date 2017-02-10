package org.lock;

/**
 * Created by hadoop on 16-8-9.
 */
public class Test {
    public static void main(String[] args) {
      Method mt =new Method();
        mt.start();
        mt.run1();
    }
}
class Method extends Thread{
    A a =new A();
    B b =new B();
    public void run(){
        a.run(b);
    }
    public void run1(){
        b.run(a);
    }

}
class A{
    int a =10;
    public synchronized void run(B b){
        System.out.println("aaaaaa"+b);
        b.last();

    }
    public synchronized void last(){
        System.out.println("last B");
    }
}
class B  extends Thread{
    int b =12;
    public synchronized void run(A a){
        System.out.println("bbbbb"+a.toString());
        a.last();
    }
    public synchronized void last(){
        System.out.println("last B");
    }
}
