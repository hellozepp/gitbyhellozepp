package org.SimapleDemo.Counter;

import java.util.*;

/**
 * Created by hadoop on 16-7-29.
 */
public class Counter {
    private static double a;
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
         a =sc.nextDouble();
        List<Jiekou> list = new ArrayList();
        list.add(0,new SUM());
        list.add(1,new IMSUB());
        list.add(2,new PRODUCT());
        list.add(3,new QUOTIENT());
        for(Jiekou jiekou: list){
            a =jiekou.jiekou(a);
        }
        System.out.println(a);



    }
}
