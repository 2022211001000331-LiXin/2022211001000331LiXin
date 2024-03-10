<%--
  Created by IntelliJ IDEA.
  User: 86150
  Date: 2024/3/5
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<body>
<h2>New User Registration!</h2>
<form method="post">
    <input type="text" name="username" placeholder="Username" class="input1" required/><br/>

    <input type="password" name="password" placeholder="Password" minlength="8" class="input1" required/><br/>

    <input type="text" id="email" placeholder="Email" class="input1" value="" onblur="checkEmail()" required/>
    <span id="span-email"></span><br/>

    Gender<input type="radio" name="gender" value="1"/>Male
    <input type="radio" name="gender" value="2"/>Female<br/>

    <input type="text" id="birthday" placeholder="Date of Birth(yyyy-mm-dd)" class="input1" onblur="checkBirthdate('birthday')"/><br/>

    <input type="submit" value="Register" class="input2"/>
</form>
</body>
</html>
