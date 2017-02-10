package org.File.org.buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BufferedStreamDemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		/*
		 * BufferedReader  ��readLine(); BufferedWriter
		 */

		BufferedReader bufr = new BufferedReader(new FileReader("Test25.java"));
		
		String line = null;
		while((line=bufr.readLine())!=null){
			System.out.println(line);
		}
		
		bufr.close();
	}

}
