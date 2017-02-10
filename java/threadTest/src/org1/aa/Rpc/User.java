package org1.aa.Rpc;


/**
 * Created by moer on 16-8-17.
 */
public class User {
    public static void main(String[] args) throws Exception{
        ClientServer cs=new ClientServer("127.0.0.1");
        System.out.println(cs.ResWeather(34));
    }
}
