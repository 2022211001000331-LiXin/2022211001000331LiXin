<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/3/28
  Time: 17:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form method="post" action="addtest.jsp" onsubmit="return check(this)">
    <ul>
        <li>UserName: <input type="text" name="username"></li>
        <li>Password: <input type="password" name="password"></li>
        <li>Email: <input type="text" name="email"></li>
        <li>gender: <input type="radio" value="male" name="gender">Male <input type="radio" value="female" name="gender">Female</li>

        <li><input type="submit" value="添加"></li>
    </ul>
</form>
</body>
</html>
