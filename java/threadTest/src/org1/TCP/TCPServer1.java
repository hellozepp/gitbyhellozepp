package org1.TCP;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hadoop on 16-8-16.
 */
public class TCPServer1 {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动——");
        ServerSocket ss =new ServerSocket(22321);
        Socket socket =ss.accept();
        InputStream is =socket.getInputStream();
        byte[] buf =new byte[1024];
        int len;
        while ((len=is.read(buf))>0){
            System.out.println(new String(buf,0,len));
        }
        socket.close();
    }
}
