<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8" />
<title>重庆籍建卡贫困生资助管理系统后台</title>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
<link rel="stylesheet" href="${APP_PATH}/static/css/style.css" />
<script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.1.1.min.js"></script>
</head>

<body>
	<div class="page-left">
		<!--左边标题模块-->
		<div class="logoDiv">
			<img src="${APP_PATH}/static/img/logo.png" class="logoImg" />
			<p class="logoTitle">资助管理系统</p>
		</div>
		<!--用户模块-->
		<div class="user_name">
			<h4 class="userName">用户:${u.name} </h4>
			<a href="${APP_PATH}/login.jsp" class="back_login">退出登录</a>
		</div>
		<!--菜单模块-->
		<div class="menu">
			<h4 class="needyDatabase-title">贫困生数据库</h4>
			<div class="navi one">
				<button class="btn" id="student_Info">贫困生管理</button>
			</div>
			<div class="navi one">
				<button class="btn" id="get_Student_Status">学籍查询</button>
			</div>


			<h4 class="project-title">资助项目</h4>
			<div class="navi">
				<button class="btn" id="project_type">项目分类管理</button>
			</div>
			<div class="navi two">
				<button class="btn" id="project_Info">资助项目管理</button>
			</div>
			<div class="navi two">
				<button class="btn" id="object_Info">资助对象管理</button>
			</div>
			<div class="navi two">
				<button class="btn" id="list_export">项目公示</button>
			</div>


			<h4 class="subventionAndStatistics-title">资助金发放与统计</h4>
			<div class="navi three">
				<button class="btn" id="grant_disbursement">资助金发放</button>
			</div>
			<%--<div class="navi three">
				<button class="btn" id="release_result">发放结果管理</button>
			</div>--%>
			<div class="navi three">
				<button class="btn" id="statistics">资助统计分析</button>
			</div>

		</div>
	</div>
	<div class="page-right">
		<iframe class="iframes" id="iframes" src="${APP_PATH}/home.jsp"></iframe>
	</div>

</body>
<script type="text/javascript">
	/*设置点击动画  slideToggle() 方法通过使用滑动效果（高度变化）来切换元素的可见状态*/
	$(".needyDatabase-title").click(function() {
		$(".one").slideToggle(500);
	});

	$(".project-title").click(function() {
		$(".two").slideToggle(500);
	});
	$(".subventionAndStatistics-title").click(function() {
		$(".three").slideToggle(500);
	});

	/*--------------------------贫困生数据库--------------------------------------------*/
	/*贫困生管理*/
	$("#student_Info").click(function() {
		var iframes = document.getElementById("iframes");
		/* 点击访问 获取用户接口 ，成功跳转 成功页面显示 */
		iframes.src = "${APP_PATH}/studentInfo.jsp";
	});
	/*学籍查询*/
	$("#get_Student_Status").click(function() {
		var iframes = document.getElementById("iframes");
		iframes.src = "${APP_PATH}/studentStatus.jsp";
	});
	/*--------------------------资助项目--------------------------------------------*/
	$("#project_type").click(function() {
		var iframes = document.getElementById("iframes");
		/!* 点击访问 获取用户接口 ，成功跳转 成功页面显示 *!/
		iframes.src = "${APP_PATH}/projectType.jsp";
	});

	$("#project_Info").click(function() {
		var iframes = document.getElementById("iframes");
		/!* 点击访问 获取用户接口 ，成功跳转 成功页面显示 *!/

		iframes.src = "${APP_PATH}/fundedProject.jsp?adminId=${u.id}";
	});
	$("#object_Info").click(function() {
		var iframes = document.getElementById("iframes");
		/!* 点击访问 获取用户接口 ，成功跳转 成功页面显示 *!/

		iframes.src = "${APP_PATH}/fundedObject.jsp?adminId=${u.id}";
	});
	$("#list_export").click(function() {
		var iframes = document.getElementById("iframes");
		/!* 点击访问 获取用户接口 ，成功跳转 成功页面显示 *!/

		iframes.src = "${APP_PATH}/projectPublicity.jsp?adminId=${u.id}";
	});
	/*--------------------------资助金发放与分析统计--------------------------------------------*/
	$("#grant_disbursement").click(function() {
		var iframes = document.getElementById("iframes");
		/!* 点击访问 获取用户接口 ，成功跳转 成功页面显示 *!/
		iframes.src = "${APP_PATH}/subvention.jsp?adminId=${u.id}";
	});
	$("#statistics").click(function() {
		var iframes = document.getElementById("iframes");
		/!* 点击访问 获取用户接口 ，成功跳转 成功页面显示 *!/
		iframes.src = "${APP_PATH}/dataSet.jsp";
	});
</script>

</html>