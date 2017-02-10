package org.String;

/**
 * Created by hadoop on 2017/1/11.
 * equals比较的对象，“==”比较的是值
 */
public class Compareble {
    public static void main(String[] args) {
        String a ="aaa";
        String b ="aaa";
        System.out.println(a==b);
        System.out.println(a.equals(b));
        b =new String("aaa");
        System.out.println(a==b);
        System.out.println(a.equals(b));

        String c =new String("aaa");
        System.out.println(a==c);

    }
}
