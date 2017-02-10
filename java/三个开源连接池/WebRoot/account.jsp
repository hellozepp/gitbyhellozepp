<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
  </head>
  
  <body>
	
	<form action="${pageContext.request.contextPath}/account" method="post">
		转入账户:<input type="text" name="accountin"><br>
		转出账户:<input type="text" name="accountout"><br>
		金额:<input type="text" name="money"><br>
		<input type="submit" value="提交">
	</form>

  </body>
</html>
