package org1.UDP;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

/**
 * Created by hadoop on 16-8-25.
 */
public class UDPSend {
    public static void main(String[] args) throws Exception {
        System.out.println("send启动");
        DatagramSocket ds =new DatagramSocket(8883);
        String line =null;
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        while ((line=bf.readLine())!=null){
            if ("close".equals(line))break;
//        Scanner sc =new Scanner(System.in);
//        byte[] buf =sc.next().getBytes();
        byte[] buf =line.getBytes();
            //数据报包 （字节流，长度，目的ip，目的端口）
        DatagramPacket dp =new DatagramPacket(buf,buf.length, InetAddress.getByName("192.168.24.1"),18888);
        ds.send(dp);
//        ds.send(dp);//可以长链接持续发包
//            break;
      }
        ds.close();
//        System.exit(0);
    }
}
