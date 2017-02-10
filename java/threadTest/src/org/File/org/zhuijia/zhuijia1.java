package org.File.org.zhuijia;

import java.io.*;

/**
 * Created by hadoop on 16-9-27.
 * 往文件中写数据，新写入的数据总是覆盖原有数据，怎么能实现追加功能呢？
 */
public class zhuijia1 {
    /**
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;

        PrintWriter printWriter = null;

        try{
            bufferedReader = new BufferedReader(new FileReader("text1.txt"));//项目根目录下
            printWriter = new PrintWriter(new FileWriter("text.txt", true));//设置为True代表追加 new FileWriter(file,true)
            //PrintWriter可以在写入同时对写入的数据进行格式化。 打印字符数组。    打印 double 精度浮点数。
            String l;

            while ((l = bufferedReader.readLine()) != null) {
                printWriter.println(l);//追加的方法
            }
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }

            if (printWriter != null) {
                printWriter.close();
            }
        }
    }

}

/**
 * File file=new File("f:/a.txt");
 BufferedWriter bw=null;
 try {
 bw=new BufferedWriter(new FileWriter(file,true));
 bw.write("efg");
 bw.close();
 } catch (IOException e) {
 // TODO Auto-generated catch block
 e.printStackTrace();
 }
 * */