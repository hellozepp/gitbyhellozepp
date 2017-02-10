package org1.TCP;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by hadoop on 16-8-16.
 * 以前把socket放在线程里面，结果出错
 */
public class TCPServer {
    static int a = 1;

    public static void main(String[] args) throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(6);
        ServerSocket ss = new ServerSocket(22321);

        System.out.println("lin服务器启动————" + ss.getLocalSocketAddress() + "     " +
                Calendar.getInstance().getTime());
        for (int j = 0; j < 6; j++) {
            while (true) {
                Socket socket = ss.accept();
                System.out.println(socket.getInetAddress() + "上线了");
                pool.execute(new ServerHandleThread(socket));

            }
        }
    }
}
class ServerHandleThread implements Runnable{
    Socket s;
    public ServerHandleThread(Socket s) throws IOException {
        this.s =s;
    }
    @Override
    public void run() {
        try {
            //获取socket的读取方法，发送到字节流里
            BufferedReader br =new BufferedReader(new InputStreamReader(s.getInputStream()));
            String temp =null;
            System.out.println("客户端"+(TCPServer.a++)+"会话————"+Calendar.getInstance().getTime());
            while ((temp=br.readLine())!=null)
                System.out.println(temp);
            System.out.println("OK!");
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}