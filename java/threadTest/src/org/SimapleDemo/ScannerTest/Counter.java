package org.SimapleDemo.ScannerTest;

import java.util.Scanner;

/**
 * Created by hadoop on 16-7-27.
 */
public class Counter {
    public static void main(String[] args) {
        float counter=0;
        while (true){
        System.out.println("输入需要运算的两个数：");
        Scanner sc =new Scanner(System.in);
        float a=sc.nextFloat();
            System.out.println("输入运算符：");
            String c =sc.next();
            float b=sc.nextFloat();
        switch (c){
            case "+":counter=a+b;break;
            case "-":counter=a-b;break;
            case "*":counter=a*b;break;
            case "/":counter=a/b;break;
        }
        System.out.println(counter);}
    }
}
