package org.spring.bean;

/**
 * Created by hadoop on 16-9-4.
 */
class Person1 {
    private String name;
    private int age;

    public Person1() {
        System.out.println("person被创建");
    }
    public Person1(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public void init(){
        System.out.println("person被使用");
    }
    public void destroy(){
        System.out.println("销毁");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
