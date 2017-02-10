package org.synchronised;

/**
 * Created by hadoop on 16-8-9.
 */
public class Account  {
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public int getMoney() {
        return money;
    }

    private String no;
    private  int money;
    public Account(String no, int money) {
        this.no =no;
        this.money=money;

    }
    public  void draw(int drawAmount){
//        try {
//            Thread.currentThread().sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if(money>=drawAmount){
            System.out.println(Thread.currentThread().getName()+"取款成功，取款："+drawAmount);
            money-=drawAmount;
            System.out.println("余额"+money);
        }
        else
            System.out.println(Thread.currentThread().getName()+"失败"+money);

    }
}
