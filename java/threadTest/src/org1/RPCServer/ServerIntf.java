package org1.RPCServer;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;


public class ServerIntf {
    private int port;
    ServerIntf(int port) throws Exception {
        this.port=port;
    }

    public void accept() throws Exception{
        ServerSocket ss =new ServerSocket(port);
        while(true){
            Socket s=ss.accept();
            ObjectInputStream ois =new ObjectInputStream(s.getInputStream());
            String method =(String)ois.readObject();
//            ois.close();

            FileWriter fw =new FileWriter("ScannerTest/org1/RPCServer/request.xml");
            fw.write(method);//接受客户请求的配置文件
            fw.flush();
            fw.close();
            System.out.println("接收指令。");

            SAXReader sax =new SAXReader();
            Document doc =sax.read("ScannerTest/org1/RPCServer/request.xml");
            Element invoke=  doc.getRootElement();
            List<Element> node1 =invoke.elements();
            Element modified =node1.get(0);

            String id =invoke.attribute(0).getValue();
            System.out.println("指令为："+invoke.attribute(1).getValue()+"方法");
            Class clazz =Class.forName("org1.RPCServer."+invoke.attribute(1).getValue());//需要 实现的需求类
            Method me =clazz.getDeclaredMethod((invoke.attribute(2).getValue()),String.class);//需要 实现的需求方法
            Object obj= clazz.newInstance();
            String result = "用户 "+id +" 的请求:"+"\n"+
                    me.invoke(obj,modified.attribute(0).getValue()).toString();//参数  获得返回的天气
            OutputStream os =s.getOutputStream();
            ObjectOutputStream oos =new ObjectOutputStream(os);
            oos.writeObject(result);
            System.out.println("完成处理，返回结果。");
            oos.close();
            os.close();
            ois.close();
            s.close();
        }
    }
}

