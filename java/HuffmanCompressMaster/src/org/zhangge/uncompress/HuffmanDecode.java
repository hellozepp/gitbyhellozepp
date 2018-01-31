/**  
 * @Title: HuffmanUncompress.java 
 * @Package org.zhangge.uncompress 
 * @Description: TODO
 * @author zhgeaits@gmail.com
 * @date 2013-5-19 上午11:28:19 
 * @version V1.0
*/ 
package org.zhangge.uncompress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
public class HuffmanDecode {

	//存放每个编码对应的字符，就是解码表
	private Map<String, Byte> decodes;
	private int minLen = Integer.MAX_VALUE;//编码的最短长度
	private int maxLen = 0;//编码的最长长度
	
	//解压
	@SuppressWarnings("unchecked")
	public void uncompress(FileInputStream fis, FileOutputStream out) throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(fis);
		StringBuffer content = new StringBuffer();
		long bitLen = ois.readLong();//读取文件的位长度
		minLen = ois.readInt();//读取编码的最短长度
		maxLen = ois.readInt();//读取编码的最长长度
		decodes = (Map<String, Byte>) ois.readObject();//读取编码表
		
		byte[] contents = new byte[1024];//每次读取1M的文件内容
		int contentLen = 0;
		int judge = (int) (bitLen % 8);//计算编码长度是否刚好为8的倍数
		while((contentLen = ois.read(contents)) != -1) {
			for (int j = 0; j < contentLen; j++) {
				content.append(byteToBinaryString(contents[j]));
			}
			if (contentLen != contents.length && judge != 0) {
				content.delete(content.length() - 8, content.length() - judge);
			}
			if (content.length() >= maxLen || contentLen != contents.length) {//缓存到一定在写出，这个缓存可以调节
				write(content, out);
			}
		}
		ois.close();
		out.flush();
		out.close();
	}
	
	private void write(StringBuffer content, FileOutputStream out) throws IOException {
		List<Byte> bs = new ArrayList<Byte>();
		boolean go = true;
		while(go) {
			for (int i = minLen; i < maxLen + 1; i++) {
				if (content.length() < i) {
					go = false;
					break;
				}
				String code = content.substring(0, i);
				if (decodes.containsKey(code)) {
					bs.add(decodes.get(code));
					content.delete(0, i);
					break;
				}
			}
		}
		if (bs.size() > 0) {//解码成功就写
			byte[] bss = new byte[bs.size()];
			for (int i = 0; i < bss.length; i++) {
				bss[i] = bs.get(i);
			}
			out.write(bss);
			bs.clear();
		}
	}
	
	//byte转换成二进制字符串
	private StringBuilder byteToBinaryString(byte b) {
		StringBuilder str = new StringBuilder();
		byte MAC = 1;
		for (int i = 0; i < 8; i++) {
			if((b & MAC) == 1) {
				str.append('1');
			} else {
				str.append('0');
			}
			b >>= 1;
		}
		return str.reverse();
	}
}
