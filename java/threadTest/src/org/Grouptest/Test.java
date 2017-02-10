package org.Grouptest;

import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.TreeMap;

/**
 * Created by hadoop on 16-8-10.
 */
public class Test {
    public static void main(String[] args) {
        TreeMap<String,HashMap> level =new TreeMap<String, HashMap>();

        A a=new A();
        A d=new A();
        B b =new B();
        C c =new C();
        HashMap<String, Thread> hashMap1 =new HashMap<>();
        hashMap1.put("a",a);
        hashMap1.put("b",d);
        level.put("1",hashMap1);
        HashMap <String, Thread> hashMap2 =new HashMap<>();
        hashMap2.put("b",b);
        level.put("2",hashMap2);
        HashMap<String, Thread>  hashMap3 =new HashMap<>();
        hashMap3.put("C",c);
        level.put("3",hashMap3);
        for(String key:level.keySet()){
            Contral ct =new Contral();
            ct.setHashMap(level.get(key));
            ct.start();
            try {
                ct.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


