package org1.aa.Rpc.Serverpa;

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
public class MyCityDom {
    public static void main(String[] args) throws DocumentException, IOException {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("ScannerTest/Rpc/Xmlpackage/MyCity.xml");
        Element root=document.getRootElement();
        List children1=root.elements();
        Element body= (Element) children1.get(0);
        List children2=body.elements();
         Element bodyy= (Element) children2.get(0);
        String str=root.attribute(1).getName()+" "+root.attribute(1).getValue()+";\n ";
        String str1=root.attribute(0).getValue()+" "+root.getName()+" "+root.attribute(2).getValue()+" "
                +root.attribute(3).getValue()+" "+root.attribute(4).getValue() +"{\n";
        String str2=body.attribute(0).getValue()+" "+body.attribute(1).getValue()+" "+body.attribute(2).getValue()
                +"("+body.attribute(1).getValue()+" "+body.attribute(3).getValue()+")"+"{\n";
        String str3="      "+bodyy.attribute(0).getValue()+"  "+bodyy.attribute(1).getValue()+";\n}\n}";
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);
        File f=new File("/home/moer/IdeaProjects/my/ScannerTest/Rpc/MyCity.java");
        FileWriter fileWriter=new FileWriter(f);
        fileWriter.write(str);
        fileWriter.write(str1);
        fileWriter.write(str2);
        fileWriter.write(str3);
        fileWriter.flush();
        fileWriter.close();
    }
}
