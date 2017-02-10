package org.File.org.InertTest;
import java.io.*;
import java.util.Scanner;

/**
 * Created by hadoop on 16-9-26.
 */
public class InsertTest {

    public static void main(String[] args) {
        final  String url ="/home/hadoop/桌面/IO流/test";
        final String file1="in";
        System.out.println("输入要插入的数据");
        String data =input();//剪切板
        InsertTest.write(data,url,file1,4,1);//粘贴
    }
    static void write(String data, String url, String file1, int rows, int cols){
        File sourceFile =new File(url,file1);
        File destFile =new File(url,"out");
        try {
            int count =1;
            BufferedReader br =new BufferedReader(new FileReader(sourceFile));
            BufferedWriter bw =new BufferedWriter(new FileWriter(destFile));
            String temp;
            //源文件
            System.out.println("源文件");
            while ((temp =br.readLine())!=null){//不要写成“”
                System.out.print(temp);
                //粘贴位置的缓存方法
                if(count==rows){
                    bw.write(temp.substring(0,cols)+data+temp.substring((cols),temp.length()));//1. 取0-3中间的0,1,2角标 2, 取3-6中间的3,4,5角标 不到六
                    while ((temp =br.readLine())!=null){
                        bw.newLine();//设置换行
                        bw.write(temp);
                    }
                    bw.flush();
                    //粘贴位置的插入方法
                    System.out.println("操作完成！");
                    break;
                }

                bw.write(temp);
                bw.newLine();//设置换行
                count++;
            }
            bw.close();
            br.close();
            //目的文件
            System.out.println("目的文件");

            BufferedReader br1 =new BufferedReader(new FileReader(destFile));
            BufferedWriter bw1 = new BufferedWriter(new FileWriter(sourceFile));
            while ((temp=br1.readLine())!=null){//读源文件
                System.out.println(temp);
                bw1.write(temp);
                bw1.newLine();//设置换行//拷贝回去
            }
            bw1.flush();
            bw1.close();
            br1.close();



        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    static String input() {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        return a;
    }

}
