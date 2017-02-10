package org.thisDemo;

public class ThisDemo1 {
    int number;
    ThisDemo1 increment(){
        number++;
        return this;
    }
    private void print(){
        System.out.println("number="+number);
    }
    public static void main(String[] args) {
        ThisDemo1 tt=new ThisDemo1();
        tt.increment().increment().increment().print();
    }
}
