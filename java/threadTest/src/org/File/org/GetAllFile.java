package org.File.org;

import org.Collection.QueueTest;

import java.io.File;

/**
 * Created by hadoop on 16-8-4.
 */
public class GetAllFile {
    public static void main(String[] args) {
        File file =new File("/home/hadoop/桌面/html3");
        QueueTest<File> queue =new QueueTest<File>();
        File[] files =file.listFiles();
        for (File file1:files){
            if (file1.isDirectory()){
                queue.add(file1);
            }else System.out.println(file1.getName());

        }
    }
}
