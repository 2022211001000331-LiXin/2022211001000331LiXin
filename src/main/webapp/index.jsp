<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/3/28
  Time: 16:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%@include file="header.jsp"%>
<body>
<!--<h1>Welcome to my home page.</h1><br>
<a href="hello-servlet">Hello Servlet-week1</a><br>
<a href="hello">Student Info Servlet-week2</a><br>
<a href="register">Life Cycle Servlet-week3</a><br>
<a href="register.jsp">Register-getParameter-week3</a><br>
<a href="config">Config parameter-week4</a><br>
<a href="register.jsp">Register JDBC-week4</a><br>
<a href="index2.jsp">include-week5</a><br>
<a href="">login-week5</a>-->

<h1>Welcome to my home page.</h1>
<form method="get" action="search" target="_blank">
    <input type="text" name="txt" size="30"/>
    <select name="search">
        <option name="baidu" value="baidu">Baidu</option>
        <option value="bing">Bing</option>
        <option value="google">Google</option>
    </select>
    <input type="submit" value="search">
</form>
</body>
<%@include file="footer.jsp"%>
</html>
