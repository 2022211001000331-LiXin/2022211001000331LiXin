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
if(!(request.getAttribute("message")==null)){

    out.println(request.getAttribute("message"));
}
%>
<%
//read cookies
    Cookie[] allCookies=request.getCookies();
    String username="",password="",rememberMeValue="";
    if(allCookies!=null){
        //read 3 cookies
        for (Cookie c:allCookies) {
            //get one by one
            if(c.getName().equals("cUsername")){
                //get value of this cookie
                username=c.getValue();
            }
            if(c.getName().equals("cPassword")){
                //get value of this cookie
                password=c.getValue();
            }
            if(c.getName().equals("cRememberMe")){
                //get value of this cookie
                rememberMeValue=c.getValue();
            }
        }
    }
%>
<form method="post" action="login">
    UserName: <input type="text" name="username" value="<%=username%>"/><br>
    PassWord: <input type="password" name="password" value="<%=password%>"/><br>
    <input type="checkbox" name="rememberMe" value="1" <%=rememberMeValue.equals("1") ?"checked":""%>checked/>RememberMe<br>
    <input type="submit" value="Login"/>
</form>
</body>
<%@include file="footer.jsp"%>
</html>
