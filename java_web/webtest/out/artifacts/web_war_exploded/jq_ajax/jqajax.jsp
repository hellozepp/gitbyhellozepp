<%--
  Created by IntelliJ IDEA.
  User: hadoop
  Date: 16-8-24
  Time: 下午4:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../js/jquery-1.4.2.js" type="text/javascript"></script>
    <script src="../js/jquery-ui-1.9.2.custom.js" type="text/javascript"></script>
    <title>Title</title>
</head>
<script type="text/javascript">
    jQuery(
            function(){
                $("#getbutton").bind("click", function () {
//                    $.get("/jqServlet",{},function(data){//资源地址 参数 回调函数
                    $.getJSON("./test.json",function(data){
//                        alert(data);//接受到的是字符串//getJSON的时候会转成对象
//                        var obj =eval("("+data+")");//负责解析json生成对象,不安全,会被截取json重写,新方法[getJSON]
//                        fastjaon
                        alert(data.length);
                    })
                })
            }
    )

</script>
<body>
    <input type="button" id="getbutton" value="get方法的调用">
</body>
</html>
