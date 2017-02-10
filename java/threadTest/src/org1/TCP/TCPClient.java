package org1.TCP;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by hadoop on 16-8-16.
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端1");
        Socket socket = null;
        try {
            socket = new Socket("192.168.24.1", 22321);
            OutputStream out = socket.getOutputStream();
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }

    }
}
