<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/4/17
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <title>Title</title>
    <style>
        .input1{
            width: 380px;
            height: 40px;
            margin-bottom: 7px;
            background-color: #EFEFE8;
            border: 1px solid #ccc;
        }
        .input2{
            width: 120px;
            height: 30px;
            font-size: 15px;
            border: 1px solid #ccc;
            background-color: #ED8F09;
            -webkit-text-fill-color: white;/*按钮字体颜色变为白色*/
        }
    </style>
    <script type="text/javascript">
        function $(id){
            return document.getElementById(id);/*获取HTML中指定ID的元素*/
        }
        function check(){
            if (checkEmail()&&checkBirthdate()){
                return true;
            }
            return false;
        }
        function checkEmail(){
            var d=document.getElementById("span-email")
            d.innerHTML="";
            var eValue=document.getElementById("email").value;
            if(!/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/.test(eValue)){
                d.innerHTML="邮箱格式错误";
            }else
                d.innerHTML="邮箱格式正确";
        }
        function checkBirthdate(fname){
            var sc = $("#"+fname);
            var s = sc.val();
            if (sc==null){
                alert("此处不能为空");
                return true;
            }
            var reg=/^(?:(?!0000)[0-9]{4}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1[0-9]|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[0-9]{2}(?:0[48]|[2468][048]|[13579][26])|(?:0[48]|[2468][048]|[13579][26])00)-02-29)$/;
            if(!s.match(reg)){
                alert("false");
            }else{
                alert("true");
            }
        }
    </script>
</head>
<%@include file="header.jsp"%>
<%@page import="com.lixin.model.User" %>
<h1>User Update</h1>
<%
User u= (User) session.getAttribute("user");
%>
<form method="post" action="updateuser">
    <input type="hidden" name="id" value="<%=u.getId()%>">
    <input type="text" name="username" value="<%=u.getUsername()%>" placeholder="Username" class="input1" required/><br/>

    <input type="password" name="password" value="<%=u.getPassword()%>" placeholder="Password" minlength="8" class="input1" required/><br/>

    <input type="text" id="email" name="email" value="<%=u.getEmail()%>" placeholder="Email" class="input1" value="" onblur="checkEmail()" required/>
    <span id="span-email"></span><br/>

    Gender<input type="radio" name="gender" value="male" <%="male".equals(u.getGender())?"checked":""%>/>Male
    <input type="radio" name="gender" value="female" <%="female".equals(u.getGender())?"checked":""%>/>Female<br/>

    <input type="text" id="birthday" name="birthday" value="<%=u.getBirthdate()%>" placeholder="Date of Birth(yyyy-mm-dd)" class="input1" onblur="checkBirthdate('birthday')"/><br/>

    <input type="submit" value="Save Changes" class="input2"/>
</form>
<%@include file="footer.jsp"%>
