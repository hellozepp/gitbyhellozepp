package org.priority;


/**
 * Created by hadoop on 16-8-10.
 * 优先权
 */
public class PriorityTest implements Runnable {
    public static void main(String[] args) {
        Thread.currentThread().setPriority(9);
        PriorityTest pri =new PriorityTest();
        new Thread(pri).start();
        new Thread(pri).start();
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        Thread.currentThread().setName("主线程");
        System.out.println(Thread.currentThread().getName()+" 线程的优先级为 "+Thread.currentThread().getPriority());
    }
    public void run(){
        for(int i=0;i<=20;i++){
            Thread.currentThread().setPriority(1);
            System.out.println(Thread.currentThread().getName()+" i = " + i+"   线程的优先级为  "+Thread.currentThread().getPriority());
        }
    }
}
