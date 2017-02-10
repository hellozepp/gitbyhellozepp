package org.File.org;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyTextFileTest {

	/**
	 * @param args
	 * @throws IOException
	 * 用来写入字符文件的便捷类。此类的构造方法假定默认字符编码和默认字节缓冲区大小都是可接受的。要自己指定这些值，可以先在
     * FileOutputStream 上构造一个 OutputStreamWriter。

	文件是否可用或是否可以被创建取决于底层平台。特别是某些平台一次只允许一个 FileWriter（或其他文件写入对象）打开文件进行写入。
    在这种情况下，如果所涉及的文件已经打开，则此类中的构造方法将失败。

	FileWriter 用于写入字符流。要写入原始字节流，请考虑使用 FileOutputStream。
	 */
	public static void main(String[] args) throws IOException {
		/*
		 * 练习：复制文本文件。
		 * 思路：
		 * 1，既然是文本涉及编码表。需要用字符流。
		 * 2，操作的是文件。涉及硬盘。
		 * 3，有指定码表吗？没有，默认就行。
		 * 操作的是文件，使用的 默认码表。使用哪个字符流对象。直接使用字符流操作文件的便捷类。FileReader  FileWriter
		 */
		copyTextFile();
	}

	public static void copyTextFile() throws IOException {
		//1,明确源和目的。
		FileReader fr = new FileReader("Test24.java");
		FileWriter fw = new FileWriter("tempfile\\test24_copy.txt");

		//2,为了提高效率。自定义缓冲区数组。字符数组。
		char[] buf = new char[1024];

		int len = 0;
		while((len=fr.read(buf))!=-1){
			fw.write(buf,0,len);
		}


		//2,循环读写操作。效率低。
//		int ch = 0;
//		while((ch=fr.read())!=-1){
//			fw.write(ch);
//		}


		//3,关闭资源。
		fw.close();
		fr.close();

	}

}
