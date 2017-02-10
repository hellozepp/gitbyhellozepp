package org1.aa.Rpc;
/**
 * Created by moer on 16-8-19.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        MyCity myCity=new MyCity();
        ServerHal serverHal=new ServerHal();
        String result=serverHal.init();
        System.out.println(result);
    }
}
