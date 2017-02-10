package org.thisDemo;

public class ThisDemo2 {
    String name;
    int age;
    public ThisDemo2 (){
        this.age=21;
    }
    public ThisDemo2(String name,int age){
        this();
        this.name="Mick";
    }
    private void print(){
        System.out.println("最终名字="+this.name);
        System.out.println("最终的年龄="+this.age);
    }
    public static void main(String[] args) {
        ThisDemo2 tt=new ThisDemo2("",0); //随便传进去的参数
        tt.print();
    }
}