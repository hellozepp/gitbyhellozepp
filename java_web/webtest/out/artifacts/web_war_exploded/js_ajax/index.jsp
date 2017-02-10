<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 16-8-24
  Time: 下午1:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script>
        var xmlhttp=null;
        if (window.XMLHttpRequest)
        {// code for all new browsers
            xmlhttp=new XMLHttpRequest();
        }
        else if (window.ActiveXObject)
        {// code for IE5 and IE6
            xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
        }
        xmlhttp.onreadystatechange=function(){
            //回调函数 编写逻辑操作客户端页面或responseText获取服务端数据
            if(xmlhttp.readyState==4&&xmlhttp.status==200){
               // xmlhttp.responseText
                alert(xmlhttp.responseText);//弹出xmlhttp域中writer的值 最后执行
            }
//            else{
//                alert("失败");//弹出四次状态
//            }
        };
        xmlhttp.open("post","${pageContext.request.contextPath}/jsajax");//页面内容 请求 地址
        xmlhttp.setRequestHeader("content-type","application/x-www-form-urlencoded");//设置请求头
        xmlhttp.send("name=hehehhe");

    </script>
    <title>Title</title>
</head>
<body>
<form method="post" action="/jsajax">
    <input type="text" value="2" name="text">
    <input type="button" value="登陆">
</form>
</body>
</html>
