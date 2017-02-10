package org1.UDP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by hadoop on 16-8-25.
 */
public class UDPRece {
    public static void main(String[] args) throws IOException {
        System.out.println("rece启动");
        DatagramSocket ds =new DatagramSocket(18888);
        byte[] buf =new byte[4096];
        while (true){
        DatagramPacket dp =new DatagramPacket(buf,buf.length);
        ds.receive(dp);
        String ip =dp.getAddress().getHostAddress();
        int port =dp.getPort();
            //通过接收到的报文包 拿到send端的数据.端口.ip
        String text =new String(dp.getData(),0,dp.getLength());
        System.out.println(ip+":"+port+"\n"+text);

        }
//        ds.close();
    }
}
