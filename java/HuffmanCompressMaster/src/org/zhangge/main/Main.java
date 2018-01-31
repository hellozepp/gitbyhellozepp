
package org.zhangge.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.zhangge.compress.HuffmanEncode;
import org.zhangge.uncompress.HuffmanDecode;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		HuffmanEncode encode = new HuffmanEncode();
		HuffmanDecode decode = new HuffmanDecode();
		encode.compress(new FileInputStream(new File("a")), new FileOutputStream(new File("a.zip")));
		//System.gc();
		decode.uncompress(new FileInputStream(new File("a.zip")), new FileOutputStream(new File("b")));
	}
}
