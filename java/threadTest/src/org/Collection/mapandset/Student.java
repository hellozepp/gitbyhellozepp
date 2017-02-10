package org.Collection.mapandset;

/**
 * Created by hadoop on 16-8-5.
 */
public class Student implements Comparable {

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNa(String name,int age) {
        this.name = name;
        this.age = age;

    }

    private String name ;
    private int age;
    public Student() {
        super();
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    /*建立就自然顺序
    * 按年龄排序
    * */
    @Override
    public int compareTo(Object o) {
        /*
        * 小于，等于，大于指定对象
        * **/
        if(!(o instanceof Student))throw new ClassCastException();
        Student stu =(Student)o;
        int temp =this.age-stu.age;
        return temp==0?this.name.compareTo(stu.name):temp;
    }

    @Override
    public String toString() {
        return "Student{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
