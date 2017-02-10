<%@ page import="org.service.UserService"%>
<%@page import="org.springframework.web.context.WebApplicationContext"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<center>
		通过controller访问<br/>
		欢迎<br/>
		<%
			WebApplicationContext wac = WebApplicationContextUtils
					.getWebApplicationContext(this.getServletConfig().getServletContext());
			UserService userService = (UserService) wac.getBean("userServiceImpl");
			String in=(String)request.getParameter("id");
		System.out.println(in);
			int num=Integer.parseInt(in);			
		%>
	<%=userService.findUserById(num)%><br />
	<%-- 	<%=userDao.findUserById(2)%><br />
		<%=userDao.findUserById(3)%><br />
		<%=userDao.findUserById(4)%><br /> --%>
	</center>
</body>
</html>
