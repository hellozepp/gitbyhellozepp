package org.lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by hadoop on 16-8-10.
 */
public class BlockingQ {
    public static void main(String[] args) {
        BlockingQueue bq =new ArrayBlockingQueue(2);
        bq.offer("aaa1");
        bq.offer("aaa2");
        bq.offer("aaa3");
        bq.offer("aaa4");
        bq.offer("aaa5");
        System.out.println(bq.poll());
    }
}
