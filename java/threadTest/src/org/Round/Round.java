package org.Round;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by hadoop on 16-8-10.
 */
public class Round {
//    private int next;
    public static void main(String[] args) throws InterruptedException {
        int n=10;
        ArrayList<Object> arr =new ArrayList();
        for (int i=0;i<n;i++){
            arr.add(i);
            if(i==n-1){arr.add(arr);}
        }
        for(Iterator it=arr.iterator();it.hasNext();){
            Object o =it.next();
            if(o.equals(arr.get(n))) {it=arr.iterator();
                System.out.println("\n");}else{
                Thread.sleep(200);
            System.out.print(o);}

        }
    }
}
