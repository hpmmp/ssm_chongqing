<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2019/5/8
  Time: 19:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学籍查询</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/userList.css"/>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.1.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <h3 class="title">学籍查询</h3>
    </div>
    <%--搜索框--%>
    <div class="row idNumber_search_div">
        <form class="form-inline .col-md-offset-1">
            <div class="form-group">
                <label>身份证号码</label>
                <input class="form-control" id="idNumber_input">
            </div>
            <button type="button" class="btn btn-primary glyphicon glyphicon-search" id="search-button">查询</button>
        </form>
    </div>
    <%--学籍结果表格--%>
    <div class="row studentStatus_table_div">
        <table class="table table-striped" id="studentStatus_table">
            <thead>
            <tr class="title-tr">
                <td>姓名</td>
                <td>身份证号码</td>
                <td>学段</td>
                <td>毕业学校名称</td>
                <td>入学日期</td>
                <td>学制</td>
                <td>学籍状态</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
</div>
</body>
<script type="text/javascript">

    /*点击搜索*/
    $("#search-button").click(function () {
        $("#studentStatus_table tbody").empty();
        var idNumber = $("#idNumber_input").val();
        $.ajax({
            url: "${APP_PATH}/studentStatus/findByIdNumber",
            data:"idNumber="+idNumber,
            type: "GET",
            success: function (result) {
                $("#table tbody").empty();
                var studentStatus = result.extend.studentStatus;
                var student = result.extend.student;


                var nameTd=$("<td></td>").append(student.name);
                var idNumberTd = $("<td></td>").append(studentStatus.idNumber);
                var schoolPhaseTd = $("<td></td>").append(studentStatus.schoolPhase);
                var schoolNameTd = $("<td></td>").append(studentStatus.schoolName);
                var startDateTd = $("<td></td>").append(studentStatus.startDate);

                var schoolLengthTd = $("<td></td>").append(studentStatus.schoolLength);
                var statusTd = $("<td></td>").append(studentStatus.status);


                $("<tr></tr>").append(nameTd)
                    .append(idNumberTd)
                    .append(schoolPhaseTd)
                    .append(schoolNameTd)
                    .append(startDateTd)
                    .append(schoolLengthTd)
                    .append(statusTd)
                    .appendTo("#studentStatus_table tbody");
            }
        });
    });
</script>
</html>
