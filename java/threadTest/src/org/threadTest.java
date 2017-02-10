package org;

/**
 * Created by hadoop on 16-8-5.
 */
public class threadTest {
    public static void main(String[] args) {

        Mythread mt =new Mythread();
        Mythread mt1 =new Mythread();
        mt.start();
        mt1.start();
    }
}
class Mythread extends Thread{
    @Override
    public void run() {
        while (true){
            System.out.print("X");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}