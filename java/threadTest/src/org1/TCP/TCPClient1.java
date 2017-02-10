package org1.TCP;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hadoop on 16-8-16.
 */
public class TCPClient1 {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端2启动");
        Socket sc=new  Socket("192.168.24.1",22321);
        OutputStream os =sc.getOutputStream();
        os.write("客户端2".getBytes());
        sc.close();
    }
}
