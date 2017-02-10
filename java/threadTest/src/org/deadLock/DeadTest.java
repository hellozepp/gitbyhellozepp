package org.deadLock;

import org.A;
import org.B;

/**
 * Created by hadoop on 16-8-9.
 */
public class DeadTest extends Thread{
    public static void main(String[] args) {
        Death de =new Death();
        de.start();
        de.init();
    }
}
class Death extends Thread{
    A a =new A();
    B b =new B();
    public void run(){
        b.bar(a);

    }

    public void init() {
        a.foo(b);
    }
}

