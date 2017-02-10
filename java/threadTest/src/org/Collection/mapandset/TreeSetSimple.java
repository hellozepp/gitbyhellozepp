package org.Collection.mapandset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by hadoop on 16-9-23.
 */
public class TreeSetSimple {
    public static void main(String[] args) {
        Set<String> tree =new TreeSet();
        tree.add("sd");
        tree.add("asd");
        tree.add("AA");
        for(Iterator it=tree.iterator();it.hasNext();){
            System.out.println(it.next());
        }
        System.out.println("=====================================");
        System.out.println(tree);
    }
}
