package org.ForkJoinPool;

/**
 * Created by hadoop on 16-8-15.
 */
public class Digui {
    public static void main(String[] args) {
        int i =6;
        Digui digui=new Digui();
        int sub= digui.subtask(i);
        System.out.println(i+"的阶乘为："+sub);
    }
    public int subtask (int i){
       if(i==1){
           return 1;
       }
        return i*subtask(i-1);
    }
}