package org.lock;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hadoop on 16-8-10.
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws Exception {
        ExecutorService pool= Executors.newFixedThreadPool(6);
        Runnable target =new Runnable() {
            public int getA() {
                return a;
            }

            public void setA(int a) {
                this.a = a;
            }

            private int a;
            @Override
            public void run() {
                for(int i=1;i<=100;i++){
                    System.out.println(Thread.currentThread().getName()+"::::::"+i);
                }
            }
        };
        System.out.println(123123123);
        pool.execute(target);
        pool.submit(target);
        pool.shutdown();
    }
}
