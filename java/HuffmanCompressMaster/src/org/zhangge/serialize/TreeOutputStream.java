/**  
 * @Title: TreeOutputStream.java 
 * @Package org.zhangge 
 * @Description: TODO
 * @author zhgeaits@gmail.com
 * @date 2012-11-13 下午11:10:39 
 * @version V1.0
*/ 
package org.zhangge.serialize;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * @project TreeSerialization
 * @file org.zhangge.TreeOutputStream.java
 * @author zhangge
 * @email zhgeaits@gmail.com
 * @date 2012-11-13
 * @description
 * 首先打印完了属性的类型和名字以后再打印每个属性的值，这样就不用在读取属性时做出判空了。
 * {aced 1 {BC {CNL CN {FL {BF FTNL FTN FNL FN EF} {BF FTNL FTN FNL FN EF} {FV}}} EC}}
 */

public class TreeOutputStream extends TreeSerializableContent {

	private DataOutputStream dos;
	
	public TreeOutputStream(String filePath) {
		try {
			dos = new DataOutputStream(new FileOutputStream(filePath));
		} catch (FileNotFoundException e) {
			System.out.println("指定写入文件正在打开。");
			e.printStackTrace();
		}
	}
	
	public void writeTree(TreeNode tree) {
		try {
			writeProtocolName(PROTOCOL_NAME);
			writeProtocolVersion(PROTOCOL_VERSION);
			writeTree0(tree);
			dos.flush();
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("rawtypes")
	private boolean writeTree0(TreeNode tree) {
		try {
			Class cls = tree.getClass();
			String clsName = cls.getName();
			short classNameLength = (short)clsName.length();
			dos.writeShort(BEGIN_CLASS);
			dos.writeInt(classNameLength);
			writeClassName(clsName);
			Field[] fields = cls.getDeclaredFields();
			short fieldsLength = (short) fields.length;
			dos.writeInt(fieldsLength);
			for (Field field : fields) {
				dos.writeShort(BEGIN_FIELD);
				writeField(field);
				dos.writeShort(END_FIELD);
			}
			for (Field field : fields) {
				field.setAccessible(true);
				writeFieldValue(field, tree);
			}
			dos.writeShort(END_CLASS);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@SuppressWarnings({ "rawtypes" })
	private void writeFieldValue(Field field, TreeNode tree) throws IllegalArgumentException, IOException, IllegalAccessException, SecurityException, NoSuchFieldException {
		Class fieldType = field.getType();
		if (fieldType.isPrimitive()) {
			writePrimitiveType(fieldType, tree, field);
		} else if (isWrapClass(fieldType)) {
			writePrimitiveType((Class)fieldType.getField("TYPE").get(null), tree, field);
		} else {
			Object fieldObj = field.get(tree);
			if (fieldObj instanceof Array) {
				Object[] objs = (Object[]) fieldObj;
				dos.writeInt(objs.length);
				for (Object object : objs) {
					if (object instanceof TreeNode) {
						writeTree0((TreeNode)object);
					} else {
						
					}
				}
			} else if (fieldObj instanceof String) {
				String value = (String) field.get(tree);
				dos.writeInt(value.getBytes().length);
				dos.writeUTF(value);
			} else if (fieldObj == null) {
				dos.writeInt(NULL_FIELD_VALUE);
			}
		}
	}
	
	@SuppressWarnings("rawtypes")
	private void writeField(Field field) 
			throws IOException, IllegalArgumentException, IllegalAccessException,
			SecurityException, NoSuchFieldException {
		Class fieldType = field.getType();
		String fieldTypeName = fieldType.getName();
		String fieldName = field.getName();
		dos.writeInt(fieldTypeName.length());
		dos.write(fieldTypeName.getBytes());
		dos.writeInt(fieldName.length());
		dos.write(fieldName.getBytes());
	}
	
	@SuppressWarnings("rawtypes")
	private void writePrimitiveType(Class fieldType, Object obj, Field field) throws IOException, IllegalArgumentException, IllegalAccessException {
		if (fieldType == int.class) {
			int value = (Integer) field.get(obj);
			dos.writeInt(value);
		} else if (fieldType == double.class) {
			double value = (Double) field.get(obj);
			dos.writeDouble(value);
		} else if (fieldType == long.class) {
			long value = field.getLong(obj);
			dos.writeLong(value);
		} else if (fieldType == char.class) {
			char value = (Character) field.get(obj);
			dos.writeChar(value);
		} else if (fieldType == byte.class) {
			byte value = (Byte) field.get(obj);
			dos.writeByte(value);
		} else if (fieldType == short.class) {
			short value = (Short) field.get(obj);
			dos.writeShort(value);
		} else if (fieldType == boolean.class) {
			boolean value = (Boolean) field.get(obj);
			dos.writeBoolean(value);
		} else if (fieldType == float.class) {
			float value = (Float) field.get(obj);
			dos.writeFloat(value);
		}
	}
	
	private void writeProtocolVersion(short version) throws IOException {
		dos.writeShort(version);
	}
	
	private void writeProtocolName(short name) throws IOException {
		dos.write(shortToByteArray(PROTOCOL_NAME, 2));
	}
	
	private void writeClassName(String name) throws IOException {
		dos.write(name.getBytes());
	}
	
}
