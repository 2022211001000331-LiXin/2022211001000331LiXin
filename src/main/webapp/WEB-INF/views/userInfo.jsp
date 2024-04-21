<%@ page import="java.sql.ResultSet" %>
<%@ page import="com.lixin.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/4/7
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>

<h1>User Info</h1>
<%
//how to read cookies
    //Cookie[] allCookies=request.getCookies();//give all cookies
    //for(Cookie c:allCookies){
      //  out.println(""+c.getName()+"--"+c.getValue());
    //}

%>
<%
User u=(User) session.getAttribute("user");
%>

<table>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr><tr>
        <td>Password:</td><td><%=u.getPassword()%></td>
    </tr><tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
    </tr><tr>
        <td>Gender:</td><td><%=u.getGender()%></td>
    </tr><tr>
        <td>Birthdate:</td><td><%=u.getBirthdate()%></td>
    </tr>
    <tr>
        <td><a href="updateuser">update</a> </td>
    </tr>
</table>
<%@include file="footer.jsp"%>
