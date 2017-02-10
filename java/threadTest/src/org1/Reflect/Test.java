package org1.Reflect;

import java.security.PrivateKey;

/**
 * Created by hadoop on 16-8-16.
 */
public class Test {
    private String name;
    private int age;

    public Test() {

        System.out.println("空参");
    }


    public Test(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("访问构造器+\"  \"+name+\"  \"+age");
    }
    public void show(String name, int age) {

        System.out.println("访问show"+"  "+name+"  "+age);
    }
    public static void staticshow( ) {
        System.out.println("访问static show");
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
