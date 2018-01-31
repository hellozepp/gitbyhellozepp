
package org.zhangge.compress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @project Compress
 * @file org.zhangge.compress.HuffmanCompress.java
 * @author zhangge
 * @email zhgeaits@gmail.com
 * @date 2013-5-19
 * @description
 * 开始以一个字符为单位来压缩，发现编码会出问题，于是现在以一个字节为单位
 * 但是当是大文件的时候，就会内存爆掉，压缩86M的文件，发现用了1.6G内存，
 * 不知道是myeclipse的原因还是java问题。
 * 以后优化，可以以8个字节为单位或者更多字节为单位来优化。
 */

@SuppressWarnings("AliDeprecation")
public class HuffmanEncode {
	
	//压缩文件的内容，源文件的字节流
	private List<Byte> contents = new ArrayList<Byte>();
	
	//存放每个字节出现的次数
	private Map<Byte, Integer> count = new HashMap<Byte, Integer>();
	
	//存放节点的列表
	private List<Node> nodes = new ArrayList<Node>();
	
	//存放每个字节的编码，就是编码表
	private Map<Byte, String> codes = new HashMap<Byte, String>();
	
	//存放每个编码对应的字符，就是解码表
	private Map<String, Byte> decodes = new HashMap<String, Byte>();
	
	private int minLen = Integer.MAX_VALUE;//编码的最短长度
	private int maxLen = 0;//编码的最长长度
	private long bitLen = 0;//压缩后文件的位数
	
	//压缩
	public void compress(FileInputStream content, FileOutputStream out) throws IOException {
		encode(content, out);
	}

	//编码，生成字节流
	private void encode(FileInputStream fis, FileOutputStream out) throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(out);
		//统计字节频率
		int readLen;
		byte[] readBytes = new byte[1024*1024];
		while ((readLen = fis.read(readBytes)) != -1) {
			for (int i = 0; i < readLen; i++) {
				contents.add(readBytes[i]);
				if (count.containsKey(readBytes[i]))
					count.put(readBytes[i], 1 + count.get(readBytes[i]));
				else
					count.put(readBytes[i], 1);
			}
		}
		//释放空间
		readBytes = null;
		

		for (Byte key : count.keySet()) {
			nodes.add(new Node(key, count.get(key)));
		}
		
		//建立huffman树
		List<Node> leaves = new ArrayList<Node>();
		leaves.addAll(nodes);
		while(leaves.size() != 1) {
			Node min1 = findMin(leaves);
			min1.code = 0;
			leaves.remove(min1);
			Node min2 = findMin(leaves);
			min2.code = 1;
			leaves.remove(min2);
			
			Node newNode = new Node(null, min1.weight + min2.weight);
			min1.parent = newNode;
			min2.parent = newNode;
			newNode.lchild = min1;
			newNode.rchild = min2;
			
			leaves.add(newNode);
		}
		//释放字节统计频率
		count.clear();
		
		//从huffman树获得编码表,解码表，最长码长度和最短码长度
		for (int i = 0; i < nodes.size(); i++) {
			Node node = nodes.get(i);
			StringBuffer revercode = new StringBuffer();
			String code = getReverse(node, revercode).reverse().toString();
			codes.put(node.value, code);
			decodes.put(code, node.value);
			if (code.length() < minLen) {
				minLen = code.length();
			}
			if (code.length() > maxLen) {
				maxLen = code.length();
			}
			revercode.delete(0, revercode.length());
		}
		
		//释放huffman树
		nodes.clear();
		leaves.clear();
		
		for (int i = 0; i < contents.size(); i++) {
			String code = codes.get(contents.get(i));
			bitLen += code.length();
		}
		oos.writeLong(bitLen);
		oos.writeInt(minLen);
		oos.writeInt(maxLen);
		oos.writeObject(decodes);//写入编码表		
		decodes.clear();//释放编码表
		
		//把源文件的内容转换成压缩的内容, 压缩后的字节流
		StringBuilder buffer = new StringBuilder();//缓冲一个字节
		//压缩后的字节流
		byte[] contentc = new byte[1024];//缓存1M，然后写到文件，可以再调节
		int index = 0;
		for (int i = 0; i < contents.size(); i++) {
			String code = codes.get(contents.get(i));
			while (code.length() != 0) {
				if (buffer.length() == 8) {//如果缓冲区已满，则转换成一个字节
					contentc[index++] = binaryStringToByte(buffer);
					buffer.delete(0, buffer.length());
				}
				int needLen = 8 - buffer.length();//计算缓冲区还有多少位
				if (code.length() > needLen) {
					buffer.append(code.substring(0, needLen));
					code = code.substring(needLen);
				} else {
					buffer.append(code);
					code = code.substring(code.length());
				}
				if (index == 1024) {
					oos.write(contentc);
					index = 0;
				}
			}
			
		}
		if (index != 0) {//缓冲区没满
			if (buffer.length() != 0) {//如果还有不足一个字节，还要写到文件
				contentc[index++] = binaryStringToByte(buffer);
			}
			byte[] left = new byte[index];
			for (int i = 0; i < left.length; i++) {
				left[i] = contentc[i];
			}
			oos.write(left);
			
		}
		oos.flush();
		oos.close();
		contentc = null;
		codes.clear();//释放编码表
		contents.clear();//释放源文件内容
	}
	
	
	//把二进制字符串转换成字节
	private byte binaryStringToByte(StringBuilder str) {
		byte t = 0;
		for (int i = 0; i < str.length(); i++) {
			t <<= 1;
			if (str.charAt(i) == '1') {
				t += 1;
			}
		}
		return t;
	}
	
	//从叶子节点开始返回到根节点，得到逆序的编码
	private StringBuffer getReverse(Node node, StringBuffer code) {
		while (node.parent != null) {
			code.append(node.code);
			node = node.parent;
		}
		return code;
	}
	
	//查找链表中频率最小的元素
	private Node findMin(List<Node> leaves) {
		int min = Integer.MAX_VALUE;
		Node target = null;
		for (Node node : leaves) {
			if (node.weight < min) {
				target = node;
				min = node.weight;
			}
		}
		return target;
	}
	
}
