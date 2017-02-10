package org1.NIO;

import java.io.*;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;

/**
 * Created by hadoop on 16-9-27.
 * 空格不算行数。。。。。
 */
public class FileChannelTest {
    public static void main(String[] args) {
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        MappedByteBuffer mbf = null;
        File file =new File("text.txt");
//        File file1 =new File("/home/hadoop/WebstormProjects/threadTest/text2.txt");
        try {
            inChannel = new FileInputStream(file).getChannel();
            outChannel = new FileOutputStream("text2.txt").getChannel();
            //这里是内存拷贝的IO
//            System.out.println(outChannel.transferFrom(inChannel,0,file.length()));//返回写入字符数
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //这里是内存映射
        try {                                   //FMR映射给。。
            mbf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,file.length());
            System.out.println(mbf);
            outChannel.write(mbf);
        } catch (IOException e) {
            e.printStackTrace();
        }
            //这里是读取方法
        mbf.clear();//还原最初位置
        CharBuffer charBuffer = null;
        try {
//          CharBuffer charBuffer = Charset.forName("utf-8").decode(mbf);
            charBuffer = Charset.forName("utf-8").newDecoder().decode(mbf);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        System.out.println(charBuffer);
    }
}
