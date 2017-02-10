<%@ page language="java" import="java.util.*,org.entity.Emp" pageEncoding="UTF-8"%>
<html>
  <head>
    <title>员工列表示例</title>
  </head>
  
  <body>
    <table border="1">
    	<tr>
    		<td>编号</td>
    		<td>姓名</td>
    		<td>工资</td>
    		<td>入职时间</td>
    	</tr>

		<%
			List list=(List)request.getAttribute("emps");
			for(int i=0;i<list.size();i++){
				Emp emp=(Emp)list.get(i);
				%><tr>
				<td><%=emp.getEmpno()+""%></td>
				<td><%=emp.getEname()+""%></td>
				<td><%=emp.getSal()+""%></td>
				<td><%=emp.getHiredate()+""%></tr><%
			}
		%>
    </table>
  </body>
</html>
