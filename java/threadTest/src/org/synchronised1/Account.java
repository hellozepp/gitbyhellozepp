package org.synchronised1;

/**
 * Created by hadoop on 16-8-9.
 */
public class Account {
    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getMoney() {
        return money;
    }
    private String no;
    private double money;
    public Account(String no, double money) {
        this.no=no;
        this.money=money;

    }
    public void draw(double drawAmount) {
    if(drawAmount<=money){
        System.out.println(Thread.currentThread().getName()+"取款成功！，取了"+drawAmount);
        money-=drawAmount;
        System.out.println("asd"+money);
    }else System.out.println(money);
    }
}
