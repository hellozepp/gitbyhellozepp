package org1.NIO;

import javafx.stage.Screen;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Created by hadoop on 16-9-28.
 */
public class PasteDemo {
    public static void main(String[] args) {
        String s ="text.txt";
        int rows = 0;
        int cols = 0;
        Scanner input =new Scanner(System.in);
        System.out.println("请分别输入行号，列号");
        rows =input.nextInt();
        cols =input.nextInt();
        System.out.println("请输入插入的数据：");
        insert(s,rows+1,cols+1,input.next());
    }

    private static void insert(String path, int rows, int cols,String data) {
        File sourceFile =new File(path);
        File distFile =new File("text2.txt");
        FileChannel inChannel;
        FileChannel outChannel;
        try {
            inChannel = new FileInputStream(sourceFile).getChannel();
            MappedByteBuffer mbf =inChannel.map(FileChannel.MapMode.READ_ONLY,0,sourceFile.length());
            CharBuffer  charBuffer = Charset.forName("utf-8").newDecoder().decode(mbf);
            String []context=charBuffer.toString().split("\n");//主意这里的反斜杠！！！！！
            System.out.println("测试分段的数据"+context[rows]);//一行
            String insertLine=context[rows].substring(0,cols)+data+context[rows].substring(cols,context[rows].length());
            System.out.println("测试修改的数据"+insertLine);
            context[rows]=insertLine;

            outChannel =new FileOutputStream(distFile).getChannel();
            ByteBuffer byteBuffer =ByteBuffer.allocate(mbf.capacity()+data.length()*3);
            int contextLen =context.length;
            for (int i =0;i<contextLen;i++){
                byteBuffer.put((context[i]+"\n").getBytes());//按行写入，加换行
            }
            //读取channel，需要置位
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();//写数据
            System.out.println(byteBuffer);
            System.out.println("position: "+byteBuffer.position()+" limit:"+byteBuffer.limit());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
