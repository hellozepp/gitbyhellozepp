package org.File.org.TailTest;

import java.io.*;

/**
 * Created by hadoop on 16-8-4.
 */
public class TailTest {
    public static void main(String[] args) throws IOException {
        String srcFilename = "/home/hadoop/桌面/IO流/test/in";
        String charset = "UTF-8";
        BufferedReader in
                = new BufferedReader(new FileReader("foo.in"));
        BufferedReader in1
                = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new FileInputStream(srcFilename),charset));
        String singleLine = "";
        while(true){
            if( (singleLine = bufferedReader.readLine()) != null ){
                System.out.println(singleLine);
                if(singleLine.equals("exit"))
                System.exit(0);
                continue;
            }
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        bufferedReader.close();
    }
}
