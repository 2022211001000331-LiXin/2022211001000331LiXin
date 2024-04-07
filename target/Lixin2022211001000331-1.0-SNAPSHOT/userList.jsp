<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/4/7
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.io.PrintWriter" %>
<h1>User List</h1>
<table border="1">
    <tr>
        <td>username</td>
        <td>password</td>
        <td>email</td>
        <td>gender</td>
        <td>birthdate</td>
    </tr>
    <%
        ResultSet rs= (ResultSet) request.getAttribute("rsname");
        if(rs==null){
    %>
    <tr>
        <td>No Data!</td>
    </tr>
    <%}else{
        while (rs.next()){
            PrintWriter writer= response.getWriter();
            writer.println("<tr><td>"+rs.getString("username")+"</td>");
            writer.println("<td>"+rs.getString("password")+"</td>");
            writer.println("<td>"+rs.getString("email")+"</td>");
            writer.println("<td>"+rs.getString("gender")+"</td>");
            writer.println("<td>"+rs.getString("birthdate")+"</td>");
            writer.println("</tr>");
        }
    }

    %>
</table>
<%@include file="footer.jsp"%>