package org.File.org;

import java.io.*;

/**
 * Created by hadoop on 16-8-4.
 */
public class Read implements Serializable {
    private static final long serialVersionUID =415215L;
    public static void main(String[] args) throws IOException  {
        String url =Read.class.getResource("Read.class").toString();
        url=url.split(":")[1].toString();
        System.out.println(url);
        File file = new File(url);
        String charset = "UTF-8";
        FileReader fileReader =null;
        BufferedReader bf =null;
        try {
            fileReader  =new FileReader(file);
            bf= new BufferedReader(fileReader);
            String temp =null;
            while ((temp=bf.readLine())!=null){
                System.out.println(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            bf.close();
            fileReader.close();

        }
    }

}
