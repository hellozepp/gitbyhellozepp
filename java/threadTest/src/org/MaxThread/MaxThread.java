package org.MaxThread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by hadoop on 16-8-28.
 * 在java gc下的内存溢出,最大支持进程11370
 */

public class MaxThread {
    public static void main(String[] args) {
        ThreadTest a=new ThreadTest();
        a.setA(0);
        while (true)
        new Thread(a).start();
    }
}
class ThreadTest implements Runnable{
    CountDownLatch cdl = new CountDownLatch(1);
    private int a;
    public void setA(int a) {
        this.a = a;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"========"+a);
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}