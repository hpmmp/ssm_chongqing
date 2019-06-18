<%@page import="java.util.List"%>
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
	pageContext.setAttribute("studentId", request.getParameter("studentId"));
%>
<!DOCTYPE html>
<html>

	<head>
		<title>密码修改</title>
		<link rel="stylesheet" href="${APP_PATH}/static/css/updatePasw.css" />
		<script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.1.1.min.js"></script>
		<link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
		<script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	</head>
	<body>
		<div class="box">
			<form action="" id="form" method="post">
				<div class="box-th">
					<p>用户ID</p>
					<h4>:${studentId}</h4>
				</div>
				<div class="box-th">
					<p>原密码</p>
					<input type="password" name="original" id="original" class="original" />
				</div>
				<div class="box-th">
					<p>修改后密码</p>
					<input type="password" name="modify" id="modify" class="modify" />
				</div>
				<div class="box-th">
					<p>确认密码</p>
					<input type="password" name="confirm" id="confirm" class="confirm" />
				</div>
				<input type="submit" class="submit" value="提交" />
			</form>
		</div>
	</body>
	<script type="text/javascript">
	//添加
	$(".submit").click(function(){
		password = $("#form").serialize();
		$.ajax({
			type:"POST",
			url:"${APP_PATH}/updatePwd",
			data:password+"&studentId="+${studentId},
			async:false,
			success:function(result){
				alert(result.msg);
			}
		});
	})
	</script>
</html>