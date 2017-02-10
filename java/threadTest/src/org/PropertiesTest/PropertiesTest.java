package org.PropertiesTest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by hadoop on 16-8-13.
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        Properties prop =new Properties();
        prop.setProperty("zhang1","12");//Prop~作为hashmap的子类字符序列化存取
        prop.setProperty("zhang1","12");
        prop.setProperty("zhang1","12");
        FileWriter fw =new FileWriter("/home/hadoop/桌面/序列化/1");
//        prop.store(fw,"阿四大四大");
        prop.store(fw,"info");
        //参数列表2为注释标题
        //保存属性列表，中文会变成ascII
        /*保存的属性列表：
        * a#\u963F\u56DB\u5927\u56DB\u5927
        #Sat Aug 13 17:02:32 CST 2016
        zhang1=12
        * */
        fw.close();
    }
}
