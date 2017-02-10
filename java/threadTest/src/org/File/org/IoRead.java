package org.File.org;

import java.io.*;
import java.util.Scanner;

/**
 * Created by hadoop on 16-8-3.
 */
public class IoRead {
    public static void main(String[] args) throws IOException {
        File file=new File("/home/hadoop/桌面/IO流/test/in");
        FileReader fileReader=new FileReader(file);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        while (true){
            String a= bufferedReader.readLine();
            if(a!=null){
                if(a.equals("stop")){
                    break;
                }else {
                    System.out.println(a);
                }
        }
//        try {way1(file);
//            way2(file);
//            String []f=file.list();
//            System.out.println(f);}
//        catch (Exception e){
//            e.printStackTrace();
        }
    }
    public static void way1(File file) throws IOException {
        InputStream inputStream=new FileInputStream(file);
        byte[] bytes=new byte[1024];
        int hasRead=0;
        while ((hasRead=inputStream.read(bytes))>0){
            System.out.println(new String(bytes,0,hasRead));
        }
        if(inputStream!=null){
            try {
                inputStream.close();
            }finally {
//                System.exit(1);
            }
        }
    }
//    public static void way2(File file) throws IOException {
//        /*InputStream inputStream=new FileInputStream(file);
//        int tempbyte;
//        while (( tempbyte = inputStream.read()) >0) {
//            System.out.println((String) tempbyte);
//        }
//        inputStream.close();*/
//
//        BufferedReader br=new BufferedReader(new FileReader(file));
//        int tempbyte;
//        while (( tempbyte = br.read()) >0) {
//            System.out.println((char)tempbyte);
//        }
//        br.close();
//
//    }
}

