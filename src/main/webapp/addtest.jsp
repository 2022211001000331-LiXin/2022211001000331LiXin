<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/3/28
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.sql.*" %>
<%request.setCharacterEncoding("UTF-8");%>
<jsp:useBean id="user" class="com.test.UserBean"></jsp:useBean>
<jsp:setProperty name="user" property="*"/>

<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%
    try{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost;databaseName=userdb;"+"integratedSecurity=false;encrypt=true;trustServerCertificate=true;";
        String username="sa";
        String password="justinhmh0219";
        Connection con = DriverManager.getConnection(url, username, password);
        String sql="insert into usertable(username,password,email,gender) values(?,?,?,?)";
        PreparedStatement ps=con.prepareStatement(sql);
        ps.setInt(1,user.getId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getEmail());
        ps.setString(4,user.getGender());
        int row=ps.executeUpdate();
        if(row>0){
            out.print("成功添加了"+row+"条数据");
        }
        ps.close();
        con.close();
    }catch (Exception e){
        out.print("添加失败！");
        e.printStackTrace();
    }
%>
<br>
<a href="test.jsp">返回</a>
</body>
</html>
