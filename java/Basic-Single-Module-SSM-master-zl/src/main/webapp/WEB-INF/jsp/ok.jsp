<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>表单参数接收</title>
  </head>
  
  <body>
   	<h1>登录成功!${requestScope.user }</h1>
   	<h3>${sessionScope.user }</h3>
  </body>
</html>
