package org.Runnable;
class Tick implements Runnable

{
    public void run()
    {
        while(true)
        {
            if(tick > 0)
                System.out.println( Thread.currentThread().getName() + " sail --" + tick--);
        }
    }

        private int tick = 50;
}
  
class TickDemo  
{  
    public static void main(String []args)  
    {  
        Tick t = new Tick();  
  
        Thread t1 = new Thread(t);  
        Thread t2 = new Thread(t);  
        Thread t3 = new Thread(t);  
        Thread t4 = new Thread(t);  
  
        t1.start();  
        t2.start();  
        t3.start();  
        t4.start();  
  
    }  
}


/*
        需求： 实现一个售票程序

        创建线程的第二种方式：实现Runnable接口

        步骤：
        1，定义类实现Runnable接口
        2，覆盖Runnable接口中的run方法
            将线程要运行的代码存放在该run方法中

        3，通过Thread 类建立线程对象
        4，将Runnable接口的子类对象作为实际参数传递给Thread类的构造函数
            为什么要将Runnable接口中的子类对象传递给Thread的构造函数
            因为，自定义的run方法所属的对象是Runnable接口的子类对象
            所以要让线程去指定指定对象的run方法，就必须明确该run方法所属对象。

        5，调用Thread类的start方法 开启线程并调用Runnable接口子类的run方法



    实现方式和继承方式的区别：

    实现方式好处：避免了单继承的局限性
    在定义建议使用实现方式

    两种方式区别：
    继承Thread：线程代码存放在Thread子类run方法中。
    实现Runnable：线程代码存放在接口的子类的run方法中、
    */
