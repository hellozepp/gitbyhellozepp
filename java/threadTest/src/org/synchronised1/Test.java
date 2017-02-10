package org.synchronised1;

import org.synchronised.*;

/**
 * Created by hadoop on 16-8-9.
 */
public class Test {
    public static void main(String[] args) {
        Account acc =new Account("123",1000);
        new DrawThread("张",acc,650).start();
        new DrawThread("李",acc,650).start();
    }
}
