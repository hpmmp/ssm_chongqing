<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>贫困生管理系统</title>
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
        <h3 class="title"></h3>
    </div>

    <%--按钮--%>
    <div class="row"></div>
    <div class="col-md-offset-9">
        <button class="btn btn-info" id="funds_payment_btn">提交银行发放资金</button>
    </div>

    <div class="row">
        <div class=".col-md-12">
            <table class="table table-hover" id="fundedObject_table">
                <thead>
                <tr class="title-tr">
                    <td>状态</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>身份证号码</td>
                    <td>户籍所在地</td>
                    <td>学校名称</td>
                    <td>资助来源类型</td>
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
        build_title();
        $.ajax({
            url: "${APP_PATH}/fundedObject/getPassedFundedObjects",
            data: {projectId:${projectId},pn:pn},
            type: "GET",
            success: function (result) {
                build_fundedObject_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }

    function build_title() {
        $.ajax({
            url: "${APP_PATH}/fundedProject/getFundedProject",
            data: "projectId="+${projectId},
            type: "GET",
            success: function (result) {
                var project =  result.extend.fundedProject;
                $(".title").html(project.name+"("+project.status+")");
            }
        });
    }

    //解析显示table
    function build_fundedObject_table(result) {
        $("#fundedObject_table tbody").empty();
        var projectStudents = result.extend.pageInfo.list;
        $.each(projectStudents, function (index, item) {
            if(item.status=="审核通过"){
                var statusTd = $("<td></td>").append(item.status).css("color","FF9900");
            }else if(item.status=="资助金已发放"){
                var statusTd = $("<td></td>").append(item.status).css("color","green");
            }

            var nameTd = $("<td></td>").append(item.student.name);
            var genderTd = $("<td></td>").append(item.student.gender == 1 ? "男" : "女");
            var idNumberTd = $("<td></td>").append(item.idNumber);
            var censusRegisterTd = $("<td></td>").append(item.student.censusRegister);
            var schoolNameTd = $("<td></td>").append(item.schoolName);
            var fromTypeTd = $("<td></td>").append(item.fromType==1?"Excel导入":"在线申请");


            $("<tr></tr>").append(statusTd)
                .append(nameTd)
                .append(genderTd)
                .append(idNumberTd)
                .append(censusRegisterTd)
                .append(schoolNameTd)
                .append(fromTypeTd)
                .appendTo("#fundedObject_table tbody");
        })
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
        var url = $("<url></url>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage != true) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页事件
            firstPageLi.click(function () {
                to_page(1);

            });
            prePageLi.click(function () {
                to_page(result.extend.pageInfo.pageNum - 1);
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
                to_page(result.extend.pageInfo.pageNum + 1);
            });
            lastPageLi.click(function () {
                to_page(result.extend.pageInfo.pages);
            });
        }

        $.each(result.extend.pageInfo.navigatepageNums, function (index, item) {
            var numLi = $("<li></li>").append($("<a></a>").append(item));
            if (result.extend.pageInfo.pageNum == item) {
                numLi.addClass("active");
            }
            numLi.click(function () {
                to_page(item);
            });
            url.append(numLi);
        });
        url.append(nextPageLi).append(lastPageLi);
        var navEle = $("<nav></nav>").append(url).appendTo("#page_nav_area");
    }

    //点击银行资金发放按钮
    $("#funds_payment_btn").click(function () {
        if (confirm("确认发起资助金发放吗？")) {
            $.ajax({
                url: "${APP_PATH}/grant",
                type: "POST",
                data :"projectId="+${projectId},
                success: function (result) {
                    if(result.code==100){
                        alert("发放资助金"+result.extend.number+"人");
                        to_page(currentPage);
                    }else{
                        alert("该项目资助已经发放");
                    }

                }
            })
        }
    });
</script>
</html>