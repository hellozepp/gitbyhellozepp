package com.lakefarm.utils;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {
	/**
	 * ����˵�� �� �Ѻ�̨�����ݴ���ǰ̨
	 * @param response
	 * @param o ����ǰ̨������
	 * @throws Exception
	 */
	public static void write(HttpServletResponse response,Object o) throws Exception{
		//���÷��������ص�ǰ̨�ַ����ı����ʽ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println(o.toString());
		out.flush();
		out.close();
	}
}
