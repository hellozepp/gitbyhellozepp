package org.Collection.mapandset;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by hadoop on 16-9-23.
 * 1.值不重复
 * 2.无序
 * 3.不同步
 *
 */
public class HashSetTest {
    public static void main(String[] args) {
        Set<String> hash =new HashSet<>();
        hash.add("小王");
        hash.add("小王");
        hash.add("小王1");
        hash.add("小王2");
        hash.add("小王3");
        System.out.println(hash);
    }
}
