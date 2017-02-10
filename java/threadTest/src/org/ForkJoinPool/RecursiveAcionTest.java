package org.ForkJoinPool;

import java.util.ArrayList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 16-8-15.
 */
public class RecursiveAcionTest {
    public static ForkJoinPool fjp =new ForkJoinPool();
    public static void main(String[] args) {
//         AtomicInteger end = new AtomicInteger(21); //仅作计数器
        int end=6;
        int[] arr =new int[end];
        for (int i=0;i<end;i++){
            arr[i]=i+1;
        }

        for (int a=0;a<end;a++){
            System.out.print(arr[a]+"  ");
        }
        System.out.println();
        Subtask subtask=new Subtask(arr,0,end);
        fjp.invoke(subtask);
        for (int a=0;a<end;a++){
            System.out.print(arr[a]+"  ");
        }
        System.out.println(subtask.getValue());
    }
}
class Subtask extends RecursiveAction{
    private int[] mult ;
    private int start;
    private int end;

    public int getValue() {
        return value;
    }

    private int value=1;
    public Subtask(int[] mult, int start,int end) {
        this.mult = mult;
        this.start = start;
        this.end = end;

    }

    @Override
    protected void compute() {
    if(end-start>10){
        int mid=(end+start)/2;
        Subtask t1=new Subtask(mult,start,mid);
        Subtask t2=new Subtask(mult,mid,end);
        invokeAll(t1,t2);
    }
    else for (int b=start;b<end;b++){
        value*=mult[b];

//        mult[b]=mult[b]+1;

    }
    }

}
