package org.synchronised1;

import org.synchronised.*;

/**
 * Created by hadoop on 16-8-9.
 */
public class DrawThread extends Thread {
    private Account ac;

    public Double getDrawAmount() {
        return drawAmount;
    }

    private Double drawAmount;

    public DrawThread(String name, Account ac, double drawAmount){
        super(name);
        this.ac =ac;
        this.drawAmount = drawAmount;
    }
    public void run(){
        ac.draw(drawAmount);
    }

}
