package org.File.org;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by hadoop on 16-8-1.
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection<String> coll =new ArrayList<String>();
        coll.add("a1");
        coll.add("a2");
        coll.add("a3");
        coll.add("a4");
        System.out.println(coll.remove("a"));
        System.out.println(coll);
        boolean a = coll.contains("a1");//包含
        System.out.println(a);
        System.out.println("============================");
        Collection<String> c2 =new ArrayList<String>();
        c2.addAll(coll);
//        c2.removeAll(coll);//删除相同
        c2.retainAll(coll);//保留相同
        for(Iterator it =c2.iterator();it.hasNext();){
            System.out.println(it.next());;}
        System.out.println("wan le");
    }
    //remove(index)是ArrayList的方法啊
}
