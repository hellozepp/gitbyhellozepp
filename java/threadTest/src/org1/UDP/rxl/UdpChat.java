package org1.UDP.rxl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by rxl on 16-8-5.
 */
public class UdpChat {
    public static void main(String[] args) throws SocketException {
        //发送端口与接收端口的socket
        DatagramSocket sendSocket=new DatagramSocket();
        DatagramSocket receSocket=new DatagramSocket(10002);

        //创建对象
        send s=new send(sendSocket);
        rece r=new rece(receSocket);

        //创建线程
        Thread t1=new Thread(s);
        Thread t2=new Thread(r);
        Thread t3=new Thread(s);

        //开启
        t1.start();
        t2.start();
        t3.start();//第二个发送者




    }
}
//发送任务
class send implements Runnable{
    private DatagramSocket ds;
    public send(DatagramSocket ds){
        super();
        this.ds=ds;
    }

    @Override
    public void run() {
        try{
//        DatagramSocket ds=new DatagramSocket();
        BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=bufr.readLine())!=null){
            byte[] buf=line.getBytes();
            DatagramPacket dp=new DatagramPacket(buf,buf.length,
                    InetAddress.getByName("127.0.0.1"),10002);
            ds.send(dp);
            if ("886".equals(line)){
                break;
            }
        }
        ds.close();
//            System.exit(0);
        }catch (IOException e){

            }
    }
}
//伪装发送者
class send2 implements Runnable{
    private DatagramSocket ds;
    public send2(DatagramSocket ds){
        super();
        this.ds=ds;
    }

    @Override
    public void run() {
        try{
//        DatagramSocket ds=new DatagramSocket();
        BufferedReader bufr=new BufferedReader(new InputStreamReader(System.in));
        String line=null;
        while ((line=bufr.readLine())!=null){
            byte[] buf=line.getBytes();
            DatagramPacket dp=new DatagramPacket(buf,buf.length,
                    InetAddress.getByName("192.168.24.1"),10002);
            ds.send(dp);
            if ("886".equals(line)){
                break;
            }
        }
//        ds.close();
            System.exit(0);
        }catch (IOException e){

            }
    }
}
//接收任务
class rece implements Runnable{
    private DatagramSocket ds;
    public rece(DatagramSocket ds){
        super();
        this.ds=ds;
    }

    @Override
    public void run() {
        try {
//        DatagramSocket ds=new DatagramSocket(10001);
        while (true){//不关闭，持续接收
            byte[] buf=new byte[1024];
            DatagramPacket dp=new DatagramPacket(buf,buf.length);
            ds.receive(dp);//阻塞 √ //不影响其他发送端发送数据
            String ip=dp.getAddress().getHostAddress();
            int port=dp.getPort();
            String text=new String(dp.getData(),0,dp.getLength());
            System.out.println(ip+"-->"+port+"-->"+text);
            if (text.equals("886")){
                System.out.println(ip+".....dile离开聊天室");
            }
        }
        }catch (IOException e){

        }

    }
}
