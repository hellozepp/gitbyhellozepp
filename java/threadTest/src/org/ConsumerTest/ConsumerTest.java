package org.ConsumerTest;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by hadoop on 16-8-12.
 */
public class ConsumerTest {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> no=new ArrayBlockingQueue<Integer>(12);

        CyclicBarrier barrier =new CyclicBarrier(6);

        for (int i=1;i<=12;i++){
            Integer a=(new Random()).nextInt(1000);
                no.add(a);
        }
        System.out.println("当前生产值为："+no);
        ExecutorService exe = Executors.newFixedThreadPool(6);
        exe.submit(new Thread(new Consumer(barrier,no)));
        exe.submit(new Thread(new Consumer(barrier,no)));
        exe.submit(new Thread(new Consumer(barrier,no)));
        exe.submit(new Thread(new Consumer(barrier,no)));
        exe.submit(new Thread(new Consumer(barrier,no)));
        exe.submit(new Thread(new Consumer(barrier,no)));
        exe.shutdown();
    }
}
class Consumer implements Runnable {
    private BlockingQueue val= new ArrayBlockingQueue(12);
    private BlockingQueue no =new ArrayBlockingQueue(12);
    private CyclicBarrier barrier;
    public Consumer(CyclicBarrier barrier,BlockingQueue no) {
       this.no=no;
        this.barrier=barrier;
    }
    @Override
    public synchronized void run()   {
//        System.out.println(1);
        for (int i=1;i<=2;i++){
//            System.out.println(1);
            try {
                val.put(no.take().toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

//            System.out.println(123);
        }
        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("运行执行命令："+val);
//        System.out.println("sadasdasdasd");

    }
}
