package org.File.org;

/**
 * Created by hadoop on 16-8-3.
 */
public class Diguitest {
    public static void main(String[] args) {

        /*
        * 功能被服用
        * 需限制自定义条件，否则栈溢出。
        *
        *
        * **/

        int a = show(5);
        System.out.println(a);
    }

    private static int show(int i) {
        if (i==2){
            return 1;
        }
        return i+show(i-1);
    }
}
