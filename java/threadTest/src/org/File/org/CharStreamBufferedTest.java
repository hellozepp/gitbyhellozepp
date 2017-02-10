package org.File.org;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharStreamBufferedTest {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * 字符流中是否有提供缓冲区 。
		 * 注意：其实自定义数组就可以解决问题,缓冲区问题并提高效率。
		 * 为什么还要使用流中的缓冲区对象呢？因为缓冲区对象中除了封装数组以外，
		 * 还提供了更多的操作缓冲区数据的方法。
		 * BufferedReader  BufferedWriter
		 *
		 * 讲解字符流缓冲区中的特有方法。
		 * 操作字符数据时，有一个文本特有的表形实行 ：行(hang)
		 * 操作行的方法。
		 * BufferedReader:readLine():一次读取一行。
		 * BufferedWriter:
		 */

		copyTextByBuffer();
//		readText();

//		writeText();
	}

	public static void writeText() throws IOException {
		BufferedWriter bufw = new BufferedWriter(new FileWriter("tempfile\\test24_buf.txt"));

		for(int x=1; x<=4; x++){
			bufw.write(x+"-itcast");
			bufw.newLine();
			bufw.flush();
		}
		bufw.close();
	}

	public static void readText() throws IOException {

		BufferedReader bufr = new BufferedReader(new FileReader("Test24.java"));


		String line = null;
		while((line=bufr.readLine())!=null){

			System.out.println(line);

		}

//		String line = bufr.readLine();
//		System.out.println("-"+line+"-");
//		String line1 = bufr.readLine();
//		System.out.println("-"+line1+"-");

		bufr.close();


	}

	public static void copyTextByBuffer() throws IOException {

		BufferedReader bufr = new BufferedReader(new FileReader("Test24.java"));
		BufferedWriter bufw = new BufferedWriter(new FileWriter("tempfile\\test24_bufcopy.txt"));
//		bufr.read();
		//循环读写一行数据。
		String line = null;
		while((line=bufr.readLine())!=null){
			bufw.write(line);
			bufw.newLine();
			bufw.flush();
		}

		bufw.close();
		bufr.close();

	}

}
