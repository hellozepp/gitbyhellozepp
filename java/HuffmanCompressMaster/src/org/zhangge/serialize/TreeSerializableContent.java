/**  
 * @Title: TreeSerializableContent.java 
 * @Package org.zhangge 
 * @Description: TODO
 * @author zhgeaits@gmail.com
 * @date 2012-11-16 下午03:05:07 
 * @version V1.0
*/ 
package org.zhangge.serialize;

/**
 * @project TreeSerialization
 * @file org.zhangge.TreeSerializableContent.java
 * @author zhangge
 * @email zhgeaits@gmail.com
 * @date 2012-11-16
 * @description
 * 这是序列化的公共内容
 *
 */

public class TreeSerializableContent {
	
	//序列化协议名字，用于标识这是一个序列化文件
	public final static short PROTOCOL_NAME = (short)0xaced;
	
	//序列化版本号，用于以后的扩展
	public final static short PROTOCOL_VERSION = 1;
	
	//标识序列化一个类开始
	public final static short BEGIN_CLASS = (short)0xbc;
	
	//标识序列化一个类结束
	public final static short END_CLASS = (short)0xec;
	
	//标识序列化属性开始
	public final static short BEGIN_FIELD = (short)0xbf;
	
	//标识序列化属性结束
	public final static short END_FIELD = (short)0xef;
	
	//用4个字节记录一个属性值的长度，如果为null值，则写入-1
	public final static int NULL_FIELD_VALUE = -1;
	
	
	/**
	 * @Title:isWrapClass
	 * @Description:TODO 判断是否基本类型的包装类型
	 * @param @param clz
	 * @param @return
	 * @return boolean
	 * @throws
	 */
	@SuppressWarnings("rawtypes")
	public boolean isWrapClass(Class clz) { 
        try { 
           return ((Class) clz.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) { 
           return false; 
        } 
    } 
	
	/**
	 * @Title:shortToByteArray
	 * @Description:TODO short类型转换成字节数组
	 * @param @param sources
	 * @param @param length
	 * @param @return
	 * @return byte[]
	 * @throws
	 */
	public byte[] shortToByteArray(short sources, int length) {
		byte[] target = new byte[length];
		for (int i = 0; i < target.length; i++) {
			int offset = (target.length - i - 1) * 8;
			target[i] = (byte)((sources >> offset) & 0xFF);
		}
		return target;
	}
}
