/**  
 * @Title: TreeInputStream.java 
 * @Package org.zhangge 
 * @Description: TODO
 * @author zhgeaits@gmail.com
 * @date 2012-11-15 下午10:16:34 
 * @version V1.0
*/ 
package org.zhangge.serialize;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @project TreeSerialization
 * @file org.zhangge.TreeInputStream.java
 * @author zhangge
 * @email zhgeaits@gmail.com
 * @date 2012-11-15
 * @description
 *
 *
 */

public class TreeInputStream extends TreeSerializableContent {

	private DataInputStream dis;
	private Class[] fieldTypes;
	private String[] fieldNames;
	
	public TreeInputStream(String filePath) {
		try {
			dis = new DataInputStream(new FileInputStream(filePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public TreeNode readTree() {
		try {
			byte[] protocolName = new byte[2];
			dis.read(protocolName, 0, 2);
			byte[] protocolVersion = new byte[2];
			dis.read(protocolVersion, 0, 2);
			if (!checkProtocol(protocolName)) {
				return null;
			}
			short bc = dis.readShort();
			if (bc == TreeOutputStream.BEGIN_CLASS) {
				return readTree0();
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	private TreeNode readTree0() {
		try {
			int classNameLength = dis.readInt();
			byte[] className = new byte[classNameLength];
			dis.read(className, 0, classNameLength);
			String classname = byteArrayToString(className);
			Class treeclass = Class.forName(classname);
			TreeNode tree = (TreeNode) treeclass.newInstance();
			int fieldsLength = dis.readInt();
			fieldTypes = new Class[fieldsLength];
			fieldNames = new String[fieldsLength];
			for (int i = 0; i < fieldsLength; i++) {
				short bf = dis.readShort();
				
				int fieldTypeLength = dis.readInt();
				byte[] fieldType = new byte[fieldTypeLength];
				dis.read(fieldType, 0, fieldTypeLength);
				String fieldTypeName = byteArrayToString(fieldType);
				
				int fieldNameLength = dis.readInt();
				byte[] fieldName = new byte[fieldNameLength];
				dis.read(fieldName, 0, fieldNameLength);
				String fieldname = byteArrayToString(fieldName);
				
				Class fieldtype = Class.forName(fieldTypeName);
				fieldTypes[i] = fieldtype;
				fieldNames[i] = fieldname;
				
				short ef = dis.readShort();
			}
			for (int i = 0; i < fieldsLength; i++) {
				Class fieldtype = fieldTypes[i];
				if (fieldtype.isPrimitive() || isWrapClass(fieldtype)) {
					if (fieldtype == int.class) {
						int value = dis.readInt();
						setObjectValue(tree, fieldNames[i], value);
					} else if (fieldtype == double.class) {
						double value = dis.readDouble();
						setObjectValue(tree, fieldNames[i], value);
					} else if (fieldtype == char.class) {
						char value = dis.readChar();
						setObjectValue(tree, fieldNames[i], value);
					} else if (fieldtype == boolean.class) {
						boolean value = dis.readBoolean();
						setObjectValue(tree, fieldNames[i], value);
					} else if (fieldtype == float.class) {
						float value = dis.readFloat();
						setObjectValue(tree, fieldNames[i], value);
					} else if (fieldtype == long.class) {
						long value = dis.readLong();
						setObjectValue(tree, fieldNames[i], value);
					} else if (fieldtype == short.class) {
						short value = dis.readShort();
						setObjectValue(tree, fieldNames[i], value);
					} else if (fieldtype == byte.class) {
						byte value = dis.readByte();
						setObjectValue(tree, fieldNames[i], value);
					}
				} else if (fieldtype.getName().equals("java.lang.String")) {
					int valuelength = dis.readInt();
					if (valuelength != TreeOutputStream.NULL_FIELD_VALUE) {
						String value = dis.readUTF();
						setObjectValue(tree, fieldNames[i], value);
					} else {
						setObjectValue(tree, fieldNames[i], null);
					}
				} else {
					int valuelength = dis.readInt();
					if (valuelength != TreeOutputStream.NULL_FIELD_VALUE) {
						TreeNode[] values = new TreeNode[valuelength];
						for (int j = 0; j < valuelength; j++) {
							short bc = dis.readShort();
							values[i] = readTree0();
						}
						setObjectValue(tree, fieldNames[i], values);
					} else {
						setObjectValue(tree, fieldNames[i], null);
					}
				}
			}
			short ec = dis.readShort();
			return tree;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private void setObjectValue(TreeNode tree, String fieldname, Object value) 
			throws SecurityException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
		Field field = tree.getClass().getDeclaredField(fieldname);
		field.setAccessible(true);
		field.set(tree, value);
	}
	
	private String byteArrayToString(byte[] source) {
		char[] cs = new char[source.length];
		for (int i = 0; i < source.length; i++) {
			cs[i] = (char)source[i];
		}
		return String.valueOf(cs);
	}
	
	private boolean checkProtocol(byte[] protocolName) {
		byte[] check = shortToByteArray(TreeOutputStream.PROTOCOL_NAME, 2);
		for (int i = 0; i < check.length; i++) {
			if (check[i] != protocolName[i]) {
				return false;
			}
		}
		return true;
	}
}
