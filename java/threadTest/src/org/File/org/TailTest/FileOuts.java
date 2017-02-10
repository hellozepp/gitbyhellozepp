package org.File.org.TailTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by hadoop on 16-8-4.
 */
public class FileOuts {
    public static void main(String[] args) throws IOException {
        File dir =new File("/home/hadoop/桌面/IO流/aaa");
        if(!dir.exists()){
            dir.mkdir();
        }
        File file =new File(dir,"text");
        FileOutputStream fos =new FileOutputStream(file);
        byte[] data ="abc".getBytes();
        try {
            fos.write(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        fos.close();

    }
}
