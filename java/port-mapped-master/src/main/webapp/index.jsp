<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="js/jquery/jquery-1.5.2.min.js" type="text/javascript"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	服务已启动
	<br/>
	<br/>
	<br/>
	<form action="/api/systemCode/findSystemCode" method="post">
		参数inputStr:<input type="text" name="inputStr">
		参数intputInt:<input type="text" name="inputInt">
		<imput type="submit">show</imput>
	</form>
	<%--<script type="text/javascript">--%>
	<%--alert("开始");--%>
    <%--$(document).ready(function() {--%>

        <%--$.post("/api/systemCode/findSystemCode", {typeCode: "1000"}, function (data, status) {--%>
            <%--if (typeof(data) == "undefined") {--%>
                <%--alert("返回数据为空!")--%>
            <%--} else { //object--%>
<%--//            var json = eval("("+data+")")// 转换对象--%>
                <%--for (key in data) {--%>
                    <%--alert(data[key].syscTypecode + "" + data[key].syscName)--%>
                <%--}--%>
            <%--}--%>
        <%--})--%>
    <%--})--%>
<%--</script>--%>

</body>
</html>