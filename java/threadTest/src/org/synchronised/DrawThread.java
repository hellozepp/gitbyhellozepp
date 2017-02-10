package org.synchronised;

/**
 * Created by hadoop on 16-8-9.
 */
public class DrawThread extends Thread {
    private Account acct;
    private int drawAmount;
    public DrawThread(String name, Account acct, int drawAmount) {
    super(name);
        this.acct=acct;
        this.drawAmount=drawAmount;
    }
    public void run(){
        acct.draw(drawAmount);
    }
}
