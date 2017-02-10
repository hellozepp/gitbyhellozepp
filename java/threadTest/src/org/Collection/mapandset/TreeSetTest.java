package org.Collection.mapandset;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by hadoop on 16-8-5.
 *
 */
public class TreeSetTest {
    public static void main(String[] args) {

        Set<Student> treeSet =new TreeSet<Student>();
        treeSet.add(new Student(12,"s"));
        treeSet.add(new Student(22,"a"));
        treeSet.add(new Student(12,"v"));
        treeSet.add(new Student(0,"v"));
        System.out.println("--------------------------------------------");

        for(Iterator it =treeSet.iterator();it.hasNext();){
            System.out.println(it.next());
            Student student1= (Student) it.next();
            System.out.println(student1.getName()+"----"+student1.getAge());

        }




    }
}
