package org;

/**
 * Created by hadoop on 16-8-11.
 */
public class Consumercz {
    public static void main(String[] args)
    {
        //1,创建资源对象。
        Resource r = new Resource();

        //2,创建线程任务。
        Producer pro = new Producer(r);
        Consumer con = new Consumer(r);

        //3,创建线程。
        Thread t1 = new Thread(pro);
        Thread t2 = new Thread(con);

        t1.start();
        t2.start();
    }
}
class Resource
{
    private String name;
    private int count = 1;

    //定义标记。
    private boolean flag = false;
    //1,提供设置的方法。
    public synchronized void set(String name)
    {

        if(flag)
            try{this.wait();}catch(InterruptedException e){}
        //给成员变量赋值并加上编号。
        this.name = name + count;
        //编号自增。
        count++;
        //打印生产了哪个商品。
        System.out.println(Thread.currentThread().getName()+"......生产者...."+this.name);

        //将标记改为true。
        flag = true;
        //唤醒消费者。
        this.notify();
    }
    public synchronized void out()
    {
        if(!flag)
            try{this.wait();}catch(InterruptedException e){}
        System.out.println(Thread.currentThread().getName()+"....消费者...."+this.name);
        //将标记该为false。
        flag = false;
        //唤醒生产者。
        this.notify();
    }
}

//2,描述生产者。
class Producer implements Runnable
{
    private Resource r ;
    // 生产者一初始化就要有资源，需要将资源传递到构造函数中。
    Producer(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.set("面包");
        }
    }
}

//3,描述消费者。
class Consumer implements Runnable
{
    private Resource r ;
    // 消费者一初始化就要有资源，需要将资源传递到构造函数中。
    Consumer(Resource r)
    {
        this.r = r;
    }
    public void run()
    {
        while(true)
        {
            r.out();
        }
    }
}


