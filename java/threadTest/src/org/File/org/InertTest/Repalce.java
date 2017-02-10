package org.File.org.InertTest;

import java.io.*;

/**
 * Created by hadoop on 16-9-27.
 */
public class Repalce {
    public static void main(String[] args) throws IOException {

        String title = "这里是传送来的标题";
        String context = "这里是传送来的内容";

        File sourceFile = new File("text.txt");//已经存在的模板文件
        File targetFile = new File("targetFile.txt");//需要建立的新文件
        //创建文件
        if(!targetFile.exists()){
            targetFile.createNewFile();
            System.out.println("被复制的文件已创建");
        }
        else if(targetFile.exists()){
            System.out.println("被复制的文件已存在");
        }

        BufferedReader br = new BufferedReader(new FileReader(sourceFile));
        BufferedWriter bw = new BufferedWriter(new FileWriter(targetFile));
        String str = null;
        while( (str = br.readLine()) != null){
            if(str.contains("title")){//包含
                str = str.replaceAll("title", title);//实行替换，规则为一行内替换。
            }
            bw.write(str);
            bw.newLine();

            // 到这里实现A to B的关键字替换，并写入B
        }
        bw.flush();
    }
}

