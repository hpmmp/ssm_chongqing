<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8" />
<title>资助管理系统学生使用模块</title>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
<link rel="stylesheet" href="${APP_PATH}/static/css/studentStyle.css" />
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.1.1.min.js"></script>
</head>

<body>
	<div class="page-left">
		<!--左边标题模块-->
		<div class="logoDiv">
			<img src="${APP_PATH}/static/img/logo.png" class="logoImg" />
			<p class="logoTitle">学生模块</p>
		</div>
		<!--用户模块-->
		<div class="user_name">
			<h4 class="userName">用户:${u.name} </h4>
			<a href="${APP_PATH}/login.jsp" class="back_login">退出登录</a>
		</div>
		<!--菜单模块-->
		<div class="menu">
			<div class="navi">
				<button class="btn" id="submit">项目申请</button>
			</div>
			<div class="navi">
				<button class="btn" id="myProject">我的项目</button>
			</div>
			<div class="navi">
				<button class="btn" id="changePwd">密码修改</button>
			</div>
		</div>
	</div>
	<div class="page-right">
		<iframe class="iframes" id="iframes" src="${APP_PATH}/home.jsp"></iframe>
	</div>

</body>
<script type="text/javascript">
	/*资助申请*/
	$("#submit").click(function() {
		var iframes = document.getElementById("iframes");
		/* 点击访问 获取用户接口 ，成功跳转 成功页面显示 */
		iframes.src = "${APP_PATH}/submit.jsp?studentId=${u.id}";
	});
	/*我的资助申请*/
	$("#myProject").click(function() {
		var iframes = document.getElementById("iframes");
		iframes.src = "${APP_PATH}/myProject.jsp?studentId=${u.id}";
	});
	/*我的资助申请*/
	$("#changePwd").click(function() {
		var iframes = document.getElementById("iframes");
		iframes.src = "${APP_PATH}/updatePasw.jsp?studentId=${u.id}";
	});
</script>

</html>