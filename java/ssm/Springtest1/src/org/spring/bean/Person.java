package org.spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by hadoop on 16-9-4.
 */
public class Person {
    private String name;
    private int age;

    private List<String> list;
    private Map<String,Object> map;
    private Set<String> set;

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    public void setSet(Set<String> set) {
        this.set = set;
    }

    public Person() {
        System.out.println("person被创建");
    }
    public Person(String name, int age) {
        this.name=name;
        this.age=age;
    }
    public  void execute(){
        System.out.println(this.name);
        System.out.println("name:"+this.name+"   age:"+this.age);
        System.out.println("================");
        for (String set1:set){
            System.out.println(set1);
        }
       for(String li :list){
           System.out.println(li);
       }
        for (String key:map.keySet()){
            System.out.println(key+"   "+map.get(key));
        }

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
