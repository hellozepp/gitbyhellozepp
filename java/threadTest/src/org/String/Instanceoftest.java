package org.String;

/**
 * Created by hadoop on 16-9-11.
 */
//instanceof是Java的一个二元操作符，和==，>，<是同一类东东。
// 由于它是由字母组成的，所以也是Java的保留关键字。
// 它的作用是测试它左边的对象是否是它右边的类的实例，返回boolean类型的数据
interface A{}
class B implements A{

}
class C extends B {
}
public class Instanceoftest {
    public static void main(String[] args){
        String s1 = "Monday";
        String s2 = new String("Monday");
        if (s1 == s2)
            System.out.println("s1 == s2");
        else
            System.out.println("s1 != s2");
        if (s1.equals(s2)) System.out.println("s1 equals s2");
        else
            System.out.println("s1 not equals s2");

        A a=null;
        B b=null;
        boolean res;
        System.out.println("instanceoftest test case 1: ------------------");
        res = a instanceof A;
        System.out.println("a instanceof A: " + res);
        res = a instanceof B;
        System.out.println("a instanceof B: " + res);

        res = b instanceof B;
        System.out.println("b instanceof B: " + res);
        res = b instanceof A;
        System.out.println("b instanceof A: " + res);

        System.out.println("/ninstanceoftest test case 2: ------------------");
        a=new B();
        b=new B();

        res = a instanceof A;
        System.out.println("a instanceof A: " + res);

        res = a instanceof B;
        System.out.println("a instanceof B: " + res);

        res = b instanceof A;
        System.out.println("b instanceof A: " + res);

        res = b instanceof B;
        System.out.println("b instanceof B: " + res);

        System.out.println("/ninstanceoftest test case 3: ------------------");
        B b2=(C)new C();
        B b3=(B)new C();
//        Exception in thread "main" java.lang.ClassCastException: org.String.B cannot be cast to org.String.C
//        at org.String.Instanceoftest.main(Instanceoftest.java:60)
//        C c1= (C) new B();

        res = b2 instanceof A;
        System.out.println("b2 instanceof A: " + res);

        res = b2 instanceof B;
        System.out.println("b2 instanceof B: " + res);

        res = b2 instanceof C;
        System.out.println("b2 instanceof C: " + res);
        res = a instanceof C;//A a=new B();
        System.out.println("b2 instanceof C: " + res);
        res = b instanceof C;//B b=new B();
        System.out.println("b2 instanceof C: " + res);
        res = b3 instanceof C;//B b=new B();
        System.out.println("b3 instanceof C: " + res);
        res = b3 instanceof B;//B b=new B();
        System.out.println("b3 instanceof B: " + res);
    }
}
