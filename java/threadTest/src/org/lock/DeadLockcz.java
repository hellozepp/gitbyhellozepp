package org.lock;

/**
 * Created by hadoop on 16-8-11.
 */
public class DeadLockcz {
    public static void main(String[] args)
    {
        Ticket t = new Ticket();

        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        try{Thread.sleep(100);}catch(InterruptedException e){}
        //切换标记,之前，让主线程停一会，这时就只有一个t1线程在，它就会执行同步代码块。
        t.flag = false;

        t2.start();
    }
}

class Ticket implements Runnable
{
    private  int tickets = 100;
    private String  obj = new String();
    boolean flag = true;
    public void run()
    {
        if(flag){
            while(true){
                synchronized(obj){
                    sale();//thisDemo lock;
                }
            }
        }
        else{
            while(true){
                this.sale();
            }
        }
    }

    public  synchronized void sale()//thisDemo lock
    {
        synchronized(obj)//obj lock
        {
            if(tickets>0)
            {
                try{Thread.sleep(100);}catch(InterruptedException e){}
                System.out.println(Thread.currentThread().getName()+"...sale..."+tickets--);//打印线程名称。
            }
        }
    }
}