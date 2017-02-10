package org.Collection;

import java.io.File;

/**
 * Created by hadoop on 16-8-3.
 */
public class ListFile {
    public static void main(String[] args) {
        File dir =new File("//home//hadoop//桌面//题目");
        listAll(dir);

    }
    public static void listAll(File dir){
        File[] files =dir.listFiles();
        int i =1;int j= 1;
        for (File file:files){
            if (file.isDirectory()){

                File f =new File(file+"/aaa");
                Boolean bl = f.delete();
                System.out.println(bl);
                System.out.println("Directory::"+i+++file);listAll(file);}
            else {
                System.out.println("isfile::"+j+++file.getName());
            }
        }

    }
}
