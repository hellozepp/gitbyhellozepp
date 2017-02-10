package org1.aa.Rpc.Xmlpackage;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by moer on 16-8-17.
 */
public class Tools {
    public static void main(String[] args) throws DocumentException, IOException {
        Tools tools = new Tools();
        tools.CityDoms();
    }

    public void CityDoms() throws DocumentException, IOException {
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("ScannerTest/Rpc/Xmlpackage/City.xml");
        Element root = document.getRootElement();
        List childlist = root.elements();
        Element body = (Element) childlist.get(0);
        List childlist1 = body.elements();
        String str1 = root.attribute(1).getName() + " " + root.attribute(1).getValue() + ";" + "\n" +
                root.attribute(0).getValue() + " " + root.getName() + " " + root.attribute(2).getValue() + "{" + "\n"
                + "   " + body.attribute(1).getValue() + " " + body.attribute(0).getValue() +
                "(" + body.attribute(3).getValue() + " " + body.attribute(2).getValue() + ")" + ";" + "\n" + "}";
        File f = new File("org1/aa/Rpc/City.java");
        FileWriter fileWriter = new FileWriter(f);
        fileWriter.write(str1);
        ;
        fileWriter.flush();
        fileWriter.close();
        //生成Clientserver 类
        //<interface modify="public" package="Rpc" name="City">
        //<Method name="ResWeather" type="int" modifyname="city" />
        // </interface>
        // public interface City{
        // String ResWeather(String city) throws Exception;
        // }
        String packages = root.attribute(1).getName()+" "+root.attribute(1).getValue()+";\n";
        String stub = " import java.io.BufferedReader;;\n" +
                " import java.io.IOException;\n" +
                " import java.io.InputStreamReader;;\n" +
                " import java.io.PrintStream;;\n" +
                " import java.net.Socket;\n" +
                " public class ClientServer implements City {\n" +
                "      private Socket socket;\n" +
                "      private String ip;\n" +
                "      ClientServer( String ip) throws IOException {\n" +
                "           thisDemo.ip=ip;\n" +
                "      }\n";
        String bornheader = " public  "+body.attribute(1).getValue()+"  Born(";
        String pramet = body.attribute(3).getValue() + "  " + body.attribute(2).getValue() + ") throws IOException {\n";
        String stub1 = "     socket=new Socket(ip,30000);\n" +
                "      PrintStream  ps=new PrintStream(socket.getOutputStream());\n";
        String ps = "      ps.println(" + body.attribute(2).getValue() + ");\n";
        String stub2 = "      ps.flush();\n" +
                "      BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));\n";
        String  res="      String result=br.readLine();\n";
        String re=null;
        if (body.attribute(1).getValue().equals("int")) {
             re = "      return Integer.parseInt(result);\n}";
        } else {
             re = "      return result;\n    }\n";
        }
        String method = "    public  " + body.attribute(1).getValue() +"  "+
                body.attribute(0).getValue() + "(" + (body.attribute(3).getValue() + " " + body.attribute(2).getValue())+"){\n";
        String strresul=null;
        if (body.attribute(1).getValue().equals("int")) {
            strresul = "       "+body.attribute(1).getValue()+" result =0;\n";
        } else {
            strresul = "      "+body.attribute(1).getValue()+"  result=null;\n";
        }
        String stub3="      ClientServer clientServer = null;\n" +
                "         try {\n" +
                "             clientServer = new ClientServer(ip);\n" +
                "         } catch (IOException e) {\n" +
                "             e.printStackTrace();\n" +
                "         }\n" ;


        String stub4="       try {\n" ;
                String strresul2="      result= clientServer.Born("+body.attribute(2).getValue()+");\n"+
                "         } catch (Exception e) {\n" +
                "             e.printStackTrace();\n" +
                "         }\n" +
                "         return result;\n" +
                "\n" +
                "     }\n" +
                " }";
//        System.out.println(packages+stub+bornheader+pramet+stub1+ps+stub2+re+method+strresul+stub3+stub4+strresul2);
        File ff = new File("/home/moer/IdeaProjects/my/ScannerTest/Rpc/ClientServer.java");
        FileWriter fileWriter1 = new FileWriter(ff);
        fileWriter1.write(packages);
        fileWriter1.write(stub+bornheader+pramet+stub1+ps+stub2+res+re+method+strresul+stub3+stub4+strresul2);
        fileWriter1.flush();
        fileWriter1.close();

        //服务端的tools

        String Sstub="\n" +
                "import java.io.BufferedReader;\n" +
                "import java.io.IOException;\n" +
                "import java.io.InputStreamReader;\n" +
                "import java.io.PrintStream;\n" +
                "import java.net.ServerSocket;\n" +
                "import java.net.Socket;\n" +
                "\n" +
                "/**\n" +
                " * Created by moer on 16-8-17.\n" +
                " */\n" +
                "public class ServerHal {\n" +
                "    ServerSocket ss;\n" +
                "    ServerHal () throws IOException {\n" +
                "    }\n";
        String intheafer="    public  String init() throws Exception {\n" +
                "        ss = new ServerSocket(30000);\n" +
                "        Socket s=ss.accept();\n" +
                "        BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));\n";
        String spramet="     String name=br.readLine();\n" +
                "        Class c=Class.forName(\""+root.attribute(1).getValue()+".MyCity\");\n";
        String Sstub2="     MyCity myCity= (MyCity) c.newInstance();\n";
        //在此改变参数;
        String Sree=null;
        if (body.attribute(3).getValue().equals("int")) {
            Sree = "Integer.parseInt(name)";
        } else {
            Sree = "name";
        }
        String  Sre="      "+body.attribute(1).getValue()+" result=myCity."+body.attribute(0).getValue()+"("+ Sree+");\n";
        String psend=
                "        PrintStream ps=new PrintStream(s.getOutputStream());\n"+
                "        ps.println(result);\n" +
                "        ps.flush();\n" +
                "        return s.getInetAddress()+\"   访问成功，数据已发送\";\n" +
                "\n" +
                "    }\n" +
                "}\n";
        System.out.println(packages+Sstub+intheafer+spramet+Sstub2+Sre+psend);
        File fff = new File("/home/moer/IdeaProjects/my/ScannerTest/Rpc/ServerHal.java");
        FileWriter fileWriter2 = new FileWriter(fff);
        fileWriter2.write(packages+Sstub+intheafer+spramet+Sstub2+Sre+psend);
        fileWriter2.flush();
        fileWriter2.close();

    }
}
