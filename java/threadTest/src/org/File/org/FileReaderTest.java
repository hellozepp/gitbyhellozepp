package org.File.org;

import javax.imageio.IIOException;
import javax.print.attribute.HashPrintRequestAttributeSet;
import java.io.*;

/**
 * Created by hadoop on 16-8-3.
 * 文件复制操作，用Reader和Writer是不合适的。
 一个是不安全，除了换行这种问题外，还有二进制数据无法解析为字符的问题；
 另一个是效率低，毕竟它要做字符解析，还得识别你是不是换行啥的，白白浪费计算量。
 */
public class FileReaderTest {
    public static void main(String[] args) {

        try {
            File fileIn =new File("/home/hadoop/桌面/IO流/test_1");
            File fileOut =new File("/home/hadoop/桌面/IO流/test_11");
            FileReader fr =new FileReader(fileIn);
            BufferedReader br =new BufferedReader(fr);
            BufferedReader br1 =new BufferedReader(new FileReader(fileOut));
            BufferedWriter bw =new BufferedWriter(new FileWriter(fileOut));
            String temp;
            //源文件
            System.out.println("源文件");
            while ((temp =br.readLine())!=null){//不要写成“”
                System.out.print(temp);
                bw.newLine();//设置换行
                bw.write(temp);
            }
            bw.flush();
            bw.close();
            br.close();
            //目的文件
            System.out.println("目的文件");
            while ((temp=br1.readLine())!=null){//不要写成“”
                System.out.println(temp);
            }
            br1.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
