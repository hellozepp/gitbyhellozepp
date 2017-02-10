package org.Collection.mapandset;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by hadoop on 16-8-6.
 特点：无序 key不可重复  可以为空
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(0,"ad");
        map.put(4,"bm");
        map.put(4,"bm1");
        map.put(2,"nb");
        map.put(5,"nk");
        map.put(-1,"nk");
        map.put(3,"nk");
        System.out.println(map);
        Set<Integer> set =map.keySet();
        for (Iterator<Integer> it =set.iterator();it.hasNext();){
            int key =it.next();
            System.out.println(map.get(key));

        }
        System.out.println(map.get(1));
    }
}
