package org.File.org.TailTest;

import java.io.*;

/**
 * Created by hadoop on 16-8-4.
 */
public class FileIns {
    public static void main(String[] args) throws IOException {
        new Input("/home/hadoop/桌面/IO流/test/nohup.out");
        System.out.println("以字节为单位读取文件内容，一次读一个字节：");
        // 一次读一个字节
    }

}
class Input{
    public Input(String file) throws IOException {
        File files =new File(file);
        InputStream in =null;
        try {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            // 一次读一个字节

            in=new FileInputStream(files);
            int byteRead =0;
            while ((byteRead=in.read())!=-1){
                System.out.println(byteRead);
            }
            System.out.println("读完了 ");
            System.out.println(byteRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            // 一次读多个字节
        in =new FileInputStream(files);
        byte[] tempBytes =new byte[1024];
        int hasRead =0;
        while ((hasRead=in.read(tempBytes))>0){
            System.out.println(new String(tempBytes,0,hasRead));
        }
    }
}