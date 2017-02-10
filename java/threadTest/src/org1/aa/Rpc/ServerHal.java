package org1.aa.Rpc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by moer on 16-8-17.
 */
public class ServerHal {
    ServerSocket ss;
    ServerHal () throws IOException {
    }
    public  String init() throws Exception {
        ss = new ServerSocket(30000);
        Socket s=ss.accept();
        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
     String name=br.readLine();
        Class c=Class.forName("Rpc.MyCity");
     MyCity myCity= (MyCity) c.newInstance();
        String result=myCity.ResWeather(Integer.parseInt(name) );
        PrintStream ps=new PrintStream(s.getOutputStream());
        ps.println(result);
        ps.flush();
        return s.getInetAddress()+"   访问成功，数据已发送";

    }
}
