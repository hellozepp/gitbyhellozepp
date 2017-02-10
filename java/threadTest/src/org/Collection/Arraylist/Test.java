package org.Collection.Arraylist;

/**
 * Created by Hello Zepp on 2016/7/31 0031.
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Integer> arr =new ArrayList<Integer>();
        for (int i=0;i<1000;i++){
            arr.add(i);
        }
        System.out.println(arr.get(0));
        System.out.println(arr.get(999));
    }
}
