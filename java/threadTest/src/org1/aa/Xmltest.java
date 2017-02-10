package org1.aa;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

/**
 * Created by root on 16-8-17.
 */
public class Xmltest {
    public static void main(String[] args) throws Exception {
        SAXReader saxReader = new SAXReader();

        Document document = saxReader.read(new File("/opt/ideaproject/myjava/ScannerTest/August17th/test.xml"));
        Element root = document.getRootElement();
      //  System.out.println(root.getName());
        List<Element> childList = root.elements();
        Element body= childList.get(0);
        List<Element> childlist1=body.elements();
    Element name= childlist1.get(0);
        Element pwd=childlist1.get(1);
        System.out.println(root.getName()+" "+root.attribute(1).getValue()+"{"+"\n"+
        "private "+name.attribute(1).getValue()+" "+
                name.attribute(0).getValue()+"="+name.attribute(2).getValue()+";\n"+
                "private "+pwd.attribute(1).getValue()+
                " "+pwd.attribute(0).getValue()+"="+pwd.attribute(2).getValue()+";\n}");

    }
}
