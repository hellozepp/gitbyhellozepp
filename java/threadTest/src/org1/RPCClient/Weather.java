package org1.RPCClient;
import java.io.*;
import java.net.Socket;
import java.util.UUID;

public class Weather implements org1.intf.GetWeather {
    private String getWeather=null;
    private String city;
    public Weather() {
    }
    @Override
    public String getWeather(String city) throws Exception {
        this.city=city;
        Socket s =new Socket("Localhost",30001);
        //序列化写入方法
        OutputStream is =s.getOutputStream();
        ObjectOutputStream oos =new ObjectOutputStream(is);
        String method ="  <invoke id=\""+ UUID.randomUUID().toString()+"\" class=\"Weather\" method=\"getWeather\">\n" +
                "        <modified name=\""+city+"\" />\n" +
                "    </invoke>";
        oos.writeObject(method);

        //序列化读取
        ObjectInputStream ois =new ObjectInputStream(s.getInputStream());
        getWeather =(String) ois.readObject();
        s.close();
        return getWeather;

    }
}
