package org.AutoPacket;

/**
 * Created by hadoop on 16-9-22.
 *i =Integer.valueOf(5);装箱
   int a = i.intValue()	 拆箱
 */
public class Autozhuangxiang {
    public static void main(String[] args) {
        Integer a=new Integer(2);
        Integer i =Integer.valueOf(a.intValue()+2);
        System.out.println("对数值4进行装箱"+i);
        int b =i.intValue()+5;
        System.out.println("拆箱后运算"+b);
    }
}
