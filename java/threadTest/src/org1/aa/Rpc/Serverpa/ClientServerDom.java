package org1.aa.Rpc.Serverpa;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
public class ClientServerDom {
        public static void main(String[] args) throws DocumentException, IOException {
            SAXReader saxReader=new SAXReader();
            Document document=saxReader.read("ScannerTest/Rpc/Xmlpackage/ClientServer1.xml");
            //root
            Element root=document.getRootElement();
            List children1=root.elements();

            Element body1= (Element) children1.get(0);
            Element body2= (Element) children1.get(1);
            Element body3= (Element) children1.get(2);
            Element body4= (Element) children1.get(3);
            Element body= (Element) children1.get(4);
            //con
            Element con= (Element) children1.get(5);
            List children2=con.elements();
            Element thiss= (Element) children2.get(0);
            //method
            Element method= (Element) children1.get(6);
            List children3=method.elements();
            Element print= (Element) children3.get(0);
            List children4=print.elements();
            Element println= (Element) children4.get(0);
            Element br= (Element) children4.get(1);
            Element result= (Element) children4.get(2);
            Element res= (Element) children4.get(3);
            String str=root.attribute(1).getName()+" "+root.attribute(1).getValue()+";\n ";
            String str0=body1.attribute(0).getValue()+";\n "+body2.attribute(0).getValue()+";\n "
                    +body3.attribute(0).getValue()+";\n "+body4.attribute(0).getValue()+";\n ";
            String str1=root.attribute(0).getValue()+" "+root.getName()+" "+root.attribute(2).getValue()+" " +"{\n"+
                    body.attribute(0).getValue()+" "+body.attribute(1).getValue()+" "+body.attribute(2).getValue()
                    +";\n";
            String str2="      "+con.attribute(0).getValue()+"( "+body.attribute(1).getValue()+" "
                    +con.attribute(2).getValue()+")"+"{\n";
            String str3="      "+thiss.getName()+thiss.attribute(0).getValue()+";\n    }\n";
            String str4="      "+method.attribute(0).getValue()+"  "+method.attribute(1).getValue()+"  "+
                    method.attribute(2).getValue()+"("+method.attribute(3).getValue()+"  "+method.attribute(4).getValue()+")"+method.attribute(5).getValue()+"{ "+"\n "
                    +" "+print.attribute(0).getValue()+"  "+print.attribute(1).getValue()+"="+print.attribute(2).getValue()
                   +"     "+print.attribute(0).getValue()+"(" +print.attribute(3).getValue()+");\n      "
                    +println.attribute(0).getValue()+"\n      "+br.attribute(0).getValue()+
                    "\n      "+result.getName()+"  "+result.attribute(0).getValue()+"="+result.attribute(1).getValue()+
                    ";\n      "+res.attribute(0).getValue()+"  "+res.attribute(1).getValue()+";\n     }\n}";

            File f=new File("/home/moer/IdeaProjects/my/ScannerTest/Rpc/ClientServer.java");
            FileWriter fileWriter=new FileWriter(f);
            fileWriter.write(str);
            fileWriter.write(str0);
            fileWriter.write(str1);
            fileWriter.write(str2);
            fileWriter.write(str3);
            fileWriter.write(str4);
            fileWriter.flush();
            fileWriter.close();
        }


}
