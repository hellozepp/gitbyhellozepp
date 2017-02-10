<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
      <script>
          function aaa() {
            var form1=document.getElementById("myform");
//              var text1=document.getElementById("mytext");
//                var text1encode=encodeURI(encodeURI(text1.value));
//              form1.action="/tt?xxx=aaa"+text1encode;
//              form1.method="get";
//              alert(form1.action);
              form1.submit();
//              alert(text1encode)
//              window.location.href="/tt?xxx="+text1encode+"&xxx=111";
          }
      </script>
  </head>
  <body>
    <form id="myform" action="/tt.do" method="post">
        <input id="xxx" type="text"/>
        <%--<input name="xxx" type="checkbox" value="aaa"/> an1--%>
        <%--<input name="xxx" type="checkbox" value="bbb"/> an2--%>
        <input type="button" value="submit button" onclick="aaa()"/>
    </form>
  </body>
</html>