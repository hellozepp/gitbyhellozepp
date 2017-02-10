package org.synchronised;

/**
 * Created by hadoop on 16-8-9.
 */
public class Lock {
    public static void main(String[] args) {
        Account acct =new Account("123123",1000);
        new DrawThread("甲",acct,800).start();
        new DrawThread("乙",acct,800).start();
    }
}
