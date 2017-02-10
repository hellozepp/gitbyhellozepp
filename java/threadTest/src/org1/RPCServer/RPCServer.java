package org1.RPCServer;


/**
 * Created by hadoop on 16-8-17.
 */
public class RPCServer {
    public static void main(String[] args) throws Exception {
        ServerIntf ser =new ServerIntf(30001);
        System.out.println(RPCServer.class.getSimpleName()+"服务器启动服务。");
        ser.accept();
        System.out.println("完成请求。");
    }
}

