package org.Grouptest;

/**
 * Created by hadoop on 16-8-10.
 */
public class C  extends Thread{
    public void run() {
        System.out.print("当前进程句柄："+Thread.currentThread().getName()+"   ");
        System.out.println(333);
    }
}
