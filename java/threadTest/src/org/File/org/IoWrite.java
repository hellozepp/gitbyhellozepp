package org.File.org;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

/**
 * Created by hadoop on 16-8-3.
 */
public class IoWrite {
    static BufferedWriter bw;
    public static void main(String[] args) {
        try {
            bw = new BufferedWriter(new FileWriter("/home/hadoop/桌面/test_1"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        getCurrentThreadID1();
        System.out.println(getCurrentThreadID2());
        clear();
    }
    private static void getCurrentThreadID1(){
        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println(name);
        // get pid
        String pid = name.split("@")[0];
        System.out.println("Pid is: "+pid);
        input(pid);
    }
    private static Integer getCurrentThreadID2()
    {
        RuntimeMXBean runtime = ManagementFactory.getRuntimeMXBean();
        String name = runtime.getName();
        return Integer.parseInt(name.substring(0, name.indexOf("@")));
    }
    private static void input(String pid){
        try {
            bw.write(pid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void clear(){
        try {
//            bw = new BufferedWriter(new FileWriter("/home/wgt/桌面/test_1"));
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   /* private static void input(String str){
        try{
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/wgt/桌面/test_1"));
            bw.write(str);
            bw.flush();
            bw.close();
        //文件将会创建在程序所在的文件夹中，
        //("data.txt")也可以加上路径，如：("C://data.txt"),这样就会在C盘根目录创建一个data.txt文件
       *//* BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream("/home/wgt/桌面/test_1"));
        DataOutputStream dout=new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/home/wgt/桌面/test_1")));
        PrintStream pout=new PrintStream(new BufferedOutputStream(new FileOutputStream("/home/wgt/桌面/test_1")));
        RandomAccessFile rout=new RandomAccessFile("/home/wgt/桌面/test_1","rw");//"rw"表示此文件可读可写
        PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter("/home/wgt/桌面/test_1")));*//*

        //设置文本内容
       *//* StringBuilder sb=new StringBuilder("");
        sb.append("How are you?"+"/r/n");
        sb.append("Fine,thanks,and you?"+"/r/n");
        sb.append("Fine,too.");

        String a=sb.toString();
        byte[] b=(a).getBytes();*//*
        //写入文件，还可以用其他方法如：write(String str)
      *//*  bw.write(a,0,b.length);
        out.write(b, 0, b.length);
        dout.write(b, 0, b.length);
        pout.write(b, 0, b.length);
        rout.write(b, 0, b.length);
        pw.print(a);*//*
        //关闭流
       //out.close();

        *//*dout.close();
        pout.close();
        rout.close();
        pw.close();*//*
    } catch (IOException ex) {
            System.out.println(ex);
        }*/
}
