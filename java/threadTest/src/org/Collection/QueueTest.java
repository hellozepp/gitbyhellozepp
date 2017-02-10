package org.Collection;

import java.util.LinkedList;

/**
 * Created by hadoop on 16-8-3.
 */
public class QueueTest<E> {
    private LinkedList<E> link;
   public QueueTest(){
       link =new LinkedList<E>();
    }//add Element
    public void add(E obj){
        link.addFirst(obj);
    }//remove Element
    public Object get(){
        return link.removeLast();
    }
    public boolean isNull(){
        return link.isEmpty();
    }
}
