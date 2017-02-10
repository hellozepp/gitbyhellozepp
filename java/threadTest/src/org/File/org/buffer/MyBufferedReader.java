package org.File.org.buffer;

import java.io.IOException;
import java.io.Reader;

/**
 * 自定义一个字符流缓冲区。 用于缓冲字符数据，从而提高操作效率。
 * 并提供了更多操作缓冲区数据的方法。 需要使用具体的流对象来完成数据的获取。
 *
 * 分析： 缓冲区应该具备什么? 1，必须要有数组。 2，需要对数组进行操作，对数组操作一定要有角标。
 *
 * @author Teaching
 *
 */
public class MyBufferedReader {

	private Reader r;

	// 定义一个字符数组,作为缓冲区。
	private char[] buf = new char[1024];
	// 定义了一个索引，用于操作数组中的元素。
	private int index = 0;
	// 定义了一个变量，用于记录读取字符的个数。
	private int count = 0;

	// 需要一初始化就具备一个流对象。
	public MyBufferedReader(Reader r) {// 可以对Reader的所有子类进行高效读取。
		this.r = r;
	}

	/**
	 * 提供一个可以从缓冲区中读取一个字符的方法。
	 * 高效方法。
	 * @throws IOException
	 *
	 */
	public int read() throws IOException {

		/*
		 * 1，需要先通过流对象从底层设备上获取一定数据的数据到缓冲区数组中。 使用流对象read(char[]);
		 */
		//如果count记录字符个数的变量为0，说明缓冲区已经没有字符数据。
		if(count==0){
			//需要从设备上获取一定数量的数据存储到缓冲区中，并用count记录存储字符的个数。
			count = r.read(buf);//通过Reader对象拿到一个数组存到临时的字符char【】缓冲区
			//每取一次新的数据，就需要将角标归0.
			index = 0;
		}
		//如果count小于0，说明到-1，没有数据了，程序直接返回-1.
		if(count<0){
			return -1;
		}
		//从缓冲区中取出一个字符。
		char ch = buf[index];
		//角标自增。
		index ++;//每次读完角标下移
		//计数器要自减。
		count --;

		return ch;
	}

	/**
	 *  基于高效的read方法，建立一个一次可以读取一行的数据的方法。
	 *  将行终止符前的数据转成字符串返回。
	 * @return
	 * @throws IOException
	 */
	public String readLine() throws IOException{

		/*
		 * 思路；
		 *
		 * 从缓冲区中一次获取一个字符，并将这个字符存储到临时容器中。
		 * 每获取一个字符都要进行判断，只要不是行终止符都进行存储。
		 * 一旦读取到行终止符，就将临时容器中的数据转成字符串返回。
		 *
		 */
		//1,定义一个临时容器。
		StringBuilder sb = new StringBuilder();

		//2,调用本类中的read方法，从缓冲区中读取一个字符，存储到临时容器中。
		//存的时候要注意：必须判断，如果是行终止符就不要存储了。就将临时容器中的
		//字符转成字符串返回。

		int ch = 0;
		while((ch=this.read())!=-1){
			if(ch=='\r'){
				continue;
			}

			if(ch=='\n'){
				return sb.toString();
			}

			sb.append((char)ch);//将读取到的字符数字转成char类型，存储到sb中。

		}

		//万一文本中最后以后没有行终止符，判断一下sb中是否有内容，如果有则返回。
		if(sb.length()!=0){
			return sb.toString();
		}


		return null;

	}


	// 关闭流资源。
	public void close() throws IOException {
		// 其实内部就是关闭具体的流。
		r.close();
	}

}
