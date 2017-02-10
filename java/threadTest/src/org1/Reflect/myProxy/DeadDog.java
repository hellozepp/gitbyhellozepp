package org1.Reflect.myProxy;

/**
 * Created by hadoop on 16-10-13.
 */
public class DeadDog implements DogImpl {
    public DeadDog() {
        System.out.println("thisDemo is dog");

    }

    @Override
    public void run() {
        System.out.println("run");
    }

    @Override
    public void bark() {
        System.out.println("wang wang wang");
    }
}
