<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>学生使用模块</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
        pageContext.setAttribute("studentId", request.getParameter("studentId"));

    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/userList.css"/>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.1.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <div class="row">
        <h3 class="title">资助申请</h3>
    </div>

    <div class="row">
        <form>
            <input type="text" placeholder="项目名称" name="projectName"
                   id="search-input" class="search-input col-md-4 col-md-offset-3"/>
            <button id="search-button" class="glyphicon glyphicon-search" type="button">搜索</button>
        </form>
    </div>

    <div class="row">
        <div class=".col-md-12">
            <table class="table table-hover" id="project_table" style="font-size:15px;">
                <thead>
                <tr class="title-tr">
                    <td>Id</td>
                    <td>项目名称</td>
                    <td>年份学期</td>
                    <td>资助金额</td>
                    <td>要求学段</td>
                    <td>贫困类型</td>
                    <td>项目说明</td>
                    <td>操作</td>
                </tr>
                </thead>
                <tbody>

                </tbody>
            </table>
        </div>

    </div>
    <%--分页信息--%>
    <div class="row">
        <%--文字文字信息--%>
        <div class="col-md-6" id="page_info_area"></div>
        <%--分页条信息--%>
        <div class="col-md-6" id="page_nav_area"></div>
    </div>
</div>

</body>

<script type="text/javascript">

    var totalRecord, currentPage;

    //1页面加载完成发送ajax请求，要到分页数据
    $(document).ready(function(){
        to_page(1);
    });

    //跳转到对应页码
    function to_page(pn) {
        $.ajax({
            url: "${APP_PATH}/fundedProject/getApplicationStatus",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
                build_projectStudent_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }
    function to_page_with_conditon(pn){
        var projectName = $("#search-input").val();
        $.ajax({
            url: "${APP_PATH}/fundedProject/findByProjectName",
            data:{projectName:projectName,pn:pn},
            type: "GET",
            /*async: false,*/
            success: function (result) {
                build_projectStudent_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }
    //解析显示table
    function build_projectStudent_table(result) {
        $("#project_table tbody").empty();
        var fundedProjects = result.extend.pageInfo.list;
        $.each(fundedProjects, function (index, item) {
            var idTd = $("<td></td>").append(item.id);
            var nameTd = $("<td></td>").append(item.name);
            var timeTd = $("<td></td>").append(item.year).append("/").append(item.term);
            var amountTd = $("<td></td>").append(item.amount);
            var phaseTd = $("<td></td>").append(item.phase);
            var typeTd = $("<td></td>").append(item.type);
            var descriptionTd = $("<td></td>").append(item.description);

            var submitBtn = $("<td></td>").addClass("btn btn-success btn-sm submit_btn")
                .append("<span></span>").addClass("glyphicon glyphicon-ok")
                .append("申请");
            submitBtn.attr("submit-id", item.id);


            $("<tr></tr>").append(idTd)
                .append(nameTd)
                .append(timeTd)
                .append(amountTd)
                .append(phaseTd)
                .append(typeTd)
                .append(descriptionTd)
                .append(submitBtn)
                .appendTo("#project_table tbody");
        });
    }
    //解析显示分页信息
    function build_page_info(result) {
        $("#page_info_area").empty();
        $("#page_info_area").append("当前第" + result.extend.pageInfo.pageNum + "页,总"
            + result.extend.pageInfo.pages + "页,"
            + "总共有" + result.extend.pageInfo.total + "条记录");
        totalRecord = result.extend.pageInfo.total;
        currentPage = result.extend.pageInfo.pageNum;
    }

    //解析显示分页条信息
    function build_page_nav(result) {
        $("#page_nav_area").empty();
        var projectName = document.getElementById("search-input").value;
        var url = $("<url></url>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage != true) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页事件
            firstPageLi.click(function () {
                if (projectName.length!=0){
                    to_page_with_conditon(1);
                }else{
                    to_page(1);
                }

            });
            prePageLi.click(function () {
                if (projectName.length!=0){
                    to_page_with_conditon(result.extend.pageInfo.pageNum - 1);
                }else{
                    to_page(result.extend.pageInfo.pageNum - 1);
                }
            });
        }
        url.append(firstPageLi).append(prePageLi);

        var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
        var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href", "#"));
        if (result.extend.pageInfo.hasNextPage != true) {
            nextPageLi.addClass("disabled");
            lastPageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页事件
            nextPageLi.click(function () {
                if (projectName.length!=0){
                    to_page_with_conditon(result.extend.pageInfo.pageNum + 1);
                }else{
                    to_page(result.extend.pageInfo.pageNum + 1);
                }
            });
            lastPageLi.click(function () {
                if (projectName.length!=0){
                    to_page_with_conditon(result.extend.pageInfo.pages);
                }else{
                    to_page(result.extend.pageInfo.pages);
                }
            });
        }

        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                if (projectName.length!=0){
                    to_page_with_conditon(item);
                }else{
                    to_page(item);
                }

            });
            url.append(numLi);
        });
        url.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(url).appendTo("#page_nav_area");
    }
    /*点击搜索*/
    $("#search-button").click(function () {
        to_page_with_conditon();
    });

    /*点击申请按钮*/
    $(document).on("click", ".submit_btn", function () {
        var projectId= $(this).attr("submit-id");
        $.ajax({
            url: "${APP_PATH}/submit",
            data:{studentId:${studentId},projectId:projectId},
            type:"PUT",
            success: function (result) {
                if(result.code == 100){
                    alert("申请成功");
                }else{
                    alert(result.msg);
                }
            }
        })
    });

</script>
</html>