<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/3/28
  Time: 16:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="header.jsp"%>
<body>
<h1>Login</h1>
<%
if(!(request.getAttribute("massage")==null)){

    out.println(request.getAttribute(("massage")));
}
%>
<form method="post" action="login">
    UserName: <input type="text" name="username"/><br>
    PassWord: <input type="password" name="password"/><br>
    <input type="submit" value="Login"/>
</form>
</body>
<%@include file="footer.jsp"%>
</html>
