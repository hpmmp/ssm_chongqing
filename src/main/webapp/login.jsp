<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>重庆籍建卡贫困生资助管理平台</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link href="${APP_PATH}/static/css/login.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript" src="${APP_PATH}/static/js/jQuery.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/fun.base.js"></script>
    <script type="text/javascript" src="${APP_PATH}/static/js/script.js"></script>
</head>

<body>
<div class="login">
    <div class="login-box">
        <div class="logo">重庆籍建卡贫困生资助管理平台</div>
        <div class="login-form">
            <form class="form">
                <div class="name">
                    <label>账号</label><input type="text" class="text" id="uid"
                    placeholder="账号" name="userName" tabindex="1"
                    required="required"></br>
                </div>
                <br>

                <div class="pwd">
                    <label>密&nbsp;&nbsp;码</label><input type="password" class="text" id="pwd"
                    placeholder="密码" name="userPassword" tabindex="2" required="required"></br>
                    <input class="submit"  value="登陆" />
                    <input class="reset" type="reset" value="重置" /> </br>
                    <font color="red" id="tip"></font></br>
                </div>
            </form>
        </div>
    </div>
    <div class="air-balloon ab-1 png"></div>
    <div class="air-balloon ab-2 png"></div>
    <div class="footer"></div>
</div>

<script type="text/javascript">
    $(".submit").click(function () {
        var uid = $("#uid").val();
        var pwd = $("#pwd").val();
        $.ajax({
            url:"${APP_PATH}/login",
            data:{uid:uid,pwd:pwd},
            type:"POST",
            success: function(result){
                if(result.code==100){
                    if(result.extend.identity==1){
                        window.location.href="${APP_PATH}/index.jsp";
                    }else{
                        window.location.href="${APP_PATH}/studentModule.jsp";
                    }
                }else{
                    $("#tip").text("账号或密码错误")
                }
            }
        });
    });
    $(".reset").click(function () {
        $("#tip").text("");
    });
</script>
</body>
</html>