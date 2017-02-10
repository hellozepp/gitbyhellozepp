package org.SimapleDemo.DriverCar;

import java.util.Scanner;

/**
 * Created by hadoop on 16-7-27.
 */
public class Oop {
    public static void main(String[] args) {
        System.out.println("当前用户：小明，小李");
        System.out.println("选择用户：");

        Scanner sc =new Scanner(System.in);
        String name =sc.next();
        if("小明".equals(name)){
      people people=  new xiaoming();
       xiaoming.setValue();}
        else{
            people people=  new xiaoli();
            xiaoli.setValue1();}

    }
}
abstract class  people{
   static String name;
    public void kaiche(){
    }
    public people(){

    }
}
class xiaoming extends people{


    public xiaoming(){
    }

    public static  void setValue(){
        name="小明";
        String sex ="男";
        int age =13;
        System.out.println("个人信息：\n姓名："+name+"\n性别："+sex+"\n年龄："+age);

        new car(name);
    }
    public void hello(){
    }
}
class xiaoli extends people{
    public xiaoli(){
    }
    public static  void setValue1(){
        name="小李";
        String sex ="男";
        int age =19;
        System.out.println("个人信息：\n姓名："+name+"\n性别："+sex+"\n年龄："+age);

        new car(name);
    }
}
class car{


    public car(String name){
        System.out.println("选择车型：\"长安\",\"奇瑞\",\"奔驰\",\"帕萨拉蒂\"");
        Scanner sc=new Scanner(System.in);
        String id1=sc.next();
        //String id =sc.toString();
        System.out.println(name+"开"+id1);

    }
}
