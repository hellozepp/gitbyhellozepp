package org.File.org.Copy;

import java.io.*;

/**
 * Created by hadoop on 16-8-7.
 */
public class CopyTest {
    public static void main(String[] args) throws IOException {
        File src =new File("/home/hadoop/桌面/IO流/test");
        File srcFile =new File(src,"in");//args:目录，文件
        File destFile =new File(src,"out");
        InputStream fis=null;
        OutputStream fos =null;
        try {
            fis = new FileInputStream(srcFile);
            fos=new FileOutputStream(destFile);
            byte[] temp =new byte[4096];
            int hasRead  =0;
            while (-1 != (hasRead = fis.read(temp))){
                String str =new String(temp,0,hasRead);
                System.out.print(str);//打印会换行，单文件写入不会受影响
                fos.write(str.getBytes());//写入语句，将str转换成Byte
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fis.close();
                fos.flush();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
