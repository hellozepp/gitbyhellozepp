package org.File.org.FileLest;

/**
 * Ϊ�˱������ǵ���System.getProperties("ϵͳ�����е�ָ����");
 * �����˷�װ���´���ʹ�÷ָ���ֱ���Ҹ��ָ�������Ŷ�ˡ�
 * @author Teaching
 *
 */
public class SeparatorTool {

	
	private  SeparatorTool() {
		super();
	}
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final String PATH_SEPARATOR = System.getProperty("path.separator");
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	
}
