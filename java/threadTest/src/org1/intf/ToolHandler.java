package org1.intf;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.parsers.SAXParser;
import javax.xml.transform.sax.SAXResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by hadoop on 16-8-17.
 */
public class ToolHandler {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader =new SAXReader();
        Document doc =saxReader.read("ScannerTest/org1/intf/intf.xml");
        Element root=  doc.getRootElement();
        List<Element> nodes =root.elements();
        Element attrs=nodes.get(0);
        List<Element> node1=attrs.elements();
        Element attr=node1.get(0);
        List<Element> childnode1=attr.elements();
        Element parameter=childnode1.get(0);

        String classname =root.attribute(0).getValue();
        String outer = root.attribute(1).getName()+" "+root.attribute(1).getValue()+";"+"\n"
                +root.attribute(2).getValue()+" "+root.getName()+" "+root.attribute(0).getValue()+"{"+"\n"
                +attr.attribute(1).getValue()+" "+attr.attribute(0).getValue()
                +" "+"("
                +parameter.attribute(1).getValue()+" "+parameter.attribute(0).getValue() +")"
                +" "+attr.attribute(2).getName()+" "+attr.attribute(2).getValue()
                +";"+"\n"
                +"}"+"\n"
                ;
        FileWriter fw =new FileWriter("ScannerTest/org1/intf/GetWeather.java");
        fw.write(outer);
        System.out.println("GetWeather.java OK");
        fw.close();

//package org1.intf;
//public interface GetWeather{
//    String getWeather (String city) throws Exception;
//}


        clientIntf(classname);
        serverIntf(classname);

    }

    private static void serverIntf(String classname) throws IOException {
        String str ="package org1.RPCServer;\n" +
                "\n" +
                "import org.dom4j.Document;\n" +
                "import org.dom4j.Element;\n" +
                "import org.dom4j.io.SAXReader;\n" +
                "\n" +
                "import java.io.*;\n" +
                "import java.lang.reflect.Method;\n" +
                "import java.net.ServerSocket;\n" +
                "import java.net.Socket;\n" +
                "import java.util.List;\n" +
                "\n" +
                "\n" +
                "public class ServerIntf {\n" +
                "    private int port;\n" +
                "    ServerIntf(int port) throws Exception {\n" +
                "        thisDemo.port=port;\n" +
                "    }\n" +
                "\n" +
                "    public void accept() throws Exception{\n" +
                "        ServerSocket ss =new ServerSocket(port);\n" +
                "        while(true){\n" +
                "            Socket s=ss.accept();\n" +
                "            ObjectInputStream ois =new ObjectInputStream(s.getInputStream());\n" +
                "            String method =(String)ois.readObject();\n" +
                "//            ois.close();\n" +
                "\n" +
                "            FileWriter fw =new FileWriter(\"ScannerTest/org1/RPCServer/request.xml\");\n" +
                "            fw.write(method);//接受客户请求的配置文件\n" +
                "            fw.flush();\n" +
                "            fw.close();\n" +
                "            System.out.println(\"接收指令。\");\n" +
                "\n" +
                "            SAXReader sax =new SAXReader();\n" +
                "            Document doc =sax.read(\"ScannerTest/org1/RPCServer/request.xml\");\n" +
                "            Element invoke=  doc.getRootElement();\n" +
                "            List<Element> node1 =invoke.elements();\n" +
                "            Element modified =node1.get(0);\n" +
                "\n" +
                "            String id =invoke.attribute(0).getValue();\n" +
                "            System.out.println(\"指令为：\"+invoke.attribute(1).getValue()+\"方法\");\n" +
                "            Class clazz =Class.forName(\"org1.RPCServer.\"+invoke.attribute(1).getValue());//需要 实现的需求类\n" +
                "            Method me =clazz.getDeclaredMethod((invoke.attribute(2).getValue()),String.class);//需要 实现的需求方法\n" +
                "            Object obj= clazz.newInstance();\n" +
                "            String result = \"用户 \"+id +\" 的请求:\"+\"\\n\"+\n" +
                "                    me.invoke(obj,modified.attribute(0).getValue()).toString();//参数  获得返回的天气\n" +
                "            OutputStream os =s.getOutputStream();\n" +
                "            ObjectOutputStream oos =new ObjectOutputStream(os);\n" +
                "            oos.writeObject(result);\n" +
                "            System.out.println(\"完成处理，返回结果。\");\n" +
                "            oos.close();\n" +
                "            os.close();\n" +
                "            ois.close();\n" +
                "            s.close();\n" +
                "        }\n" +
                "    }\n" +
                "}\n" +
                "\n";
        FileWriter fw =new FileWriter("ScannerTest/org1/RPCServer/ServerIntf.java");
        fw.write(str);
        System.out.println("ServerIntf.java OK");
        fw.close();
    }

    private static void clientIntf(String classname) throws IOException {
        String str2 ="package org1.RPCClient;\n" +
                "import java.io.*;\n" +
                "import java.net.Socket;\n" +
                "import java.util.UUID;\n" +
                "\n" +
                "public class Weather implements org1.intf.GetWeather {\n" +
                "    private String getWeather=null;\n" +
                "    private String city;\n" +
                "    public Weather() {\n" +
                "    }\n" +
                "    @Override\n" +
                "    public String getWeather(String city) throws Exception {\n" +
                "        thisDemo.city=city;\n" +
                "        Socket s =new Socket(\"Localhost\",30001);\n" +
                "        //序列化写入方法\n" +
                "        OutputStream is =s.getOutputStream();\n" +
                "        ObjectOutputStream oos =new ObjectOutputStream(is);\n" +
                "        String method =\"  <invoke id=\\\"\"+ UUID.randomUUID().toString()+\"\\\" class=\\\"Weather\\\" method=\\\"getWeather\\\">\\n\" +\n" +
                "                \"        <modified name=\\\"\"+city+\"\\\" />\\n\" +\n" +
                "                \"    </invoke>\";\n" +
                "        oos.writeObject(method);\n" +
                "\n" +
                "        //序列化读取\n" +
                "        ObjectInputStream ois =new ObjectInputStream(s.getInputStream());\n" +
                "        getWeather =(String) ois.readObject();\n" +
                "        s.close();\n" +
                "        return getWeather;\n" +
                "\n" +
                "    }\n" +
                "}\n";
        FileWriter fw =new FileWriter("ScannerTest/org1/RPCClient/Weather.java");
        fw.write(str2);
        System.out.println("Weather.java OK");
        fw.close();
    }
}
