<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<head>
<meta charset="UTF-8">
<title>主页</title>
	<%
		pageContext.setAttribute("APP_PATH", request.getContextPath());
	%>
<link rel="stylesheet"
	href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
</head>
<body>
<img src="${APP_PATH}/static/img/home.jpg" height="700" width="1200">
</body>
<script src="js/bootstrap.min.js"></script>
</html>