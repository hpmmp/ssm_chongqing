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
    <script src="${APP_PATH}/static/js/xlsx.full.min.js"></script>
</head>

<body>

<div class="container">
    <div class="row">
        <h3 class="title">贫困生管理</h3>
    </div>

    <div class="row">
        <form>
            <input type="text" placeholder="按身份证查询" name="idNumber"
                   id="search-input" class="search-input col-md-4 col-md-offset-3"/>
            <button id="search-button" class="glyphicon glyphicon-search" type="button">搜索</button>
        </form>
    </div>


    <%--按钮--%>
    <div class="row"></div>
    <div class="col-md-offset-8">
        <a class="file btn btn-success glyphicon glyphicon-star">学生信息导入
            <input type="file" onchange="importf(this)" >
        </a>
        <a class="file btn btn-info glyphicon glyphicon-star-empty">家庭信息导入
            <input type="file" onchange="importf2(this)" >
        </a>
        <button class="btn btn-danger" id="student_delete_all_btn">删除</button>
    </div>

    <div class="row">
        <div class=".col-md-12">
            <table class="table table-hover" id="student_table">
                <thead>
                <tr class="title-tr">
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <td>Id</td>
                    <td>姓名</td>
                    <td>性别</td>
                    <td>身份证号码</td>
                    <td>出生年月日</td>
                    <td>户籍地</td>
                    <td>贫困类型</td>
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
            url: "${APP_PATH}/student/getStudentInfo",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
                build_students_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }
    function to_page_with_conditon(pn){
        var idNumber = $("#search-input").val();
        $.ajax({
            url: "${APP_PATH}/student/findByIdNumber",
            data:{idNumber:idNumber,pn:pn},
            type: "GET",
            /*async: false,*/
            success: function (result) {
                build_students_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }
    //解析显示table
    function build_students_table(result) {
        $("#student_table tbody").empty();
        var students = result.extend.pageInfo.list;
        $.each(students, function (index, item) {
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var idTd = $("<td></td>").append(item.id);
            var nameTd = $("<td></td>").append(item.name);
            var genderTd = $("<td></td>").append(item.gender == 1 ? "男" : "女");
            var idNumberTd = $("<td></td>").append(item.idNumber);
            var censusRegisterTd = $("<td></td>").append(item.censusRegister);
            var birthdayTd = $("<td></td>").append(item.birthday);
            var povertyTypeTd = $("<td></td>").append(item.povertyType);


            var detailBtn = $("<td></td>").addClass("btn btn-primary btn-sm detail_btn")
                .append("<span></span>").addClass("glyphicon glyphicon-pencil")
                .append("详情");
            detailBtn.attr("detail-id", item.id);
            var delBtn = $("<td></td>").addClass("btn btn-danger btn-sm delete_btn")
                .append("<span></span>").addClass("glyphicon glyphicon-trash")
                .append("删除");
            delBtn.attr("del-id",item.id);
            var btnTd = $("<td></td>").append(detailBtn).append(" ").append(delBtn);

            $("<tr></tr>").append(checkBoxTd)
                .append(idTd)
                .append(nameTd)
                .append(genderTd)
                .append(idNumberTd)
                .append(birthdayTd)
                .append(censusRegisterTd)
                .append(povertyTypeTd)
                .append(btnTd)
                .appendTo("#student_table tbody");
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
        var idNumber = document.getElementById("search-input").value;
        var url = $("<url></url>").addClass("pagination");
        var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href", "#"));
        var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
        if (result.extend.pageInfo.hasPreviousPage != true) {
            firstPageLi.addClass("disabled");
            prePageLi.addClass("disabled");
        } else {
            //为元素添加点击翻页事件
            firstPageLi.click(function () {
                if (idNumber.length!=0){
                    to_page_with_conditon(1);
                }else{
                    to_page(1);
                }

            });
            prePageLi.click(function () {
                if (idNumber.length!=0){
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
                if (idNumber.length!=0){
                    to_page_with_conditon(result.extend.pageInfo.pageNum + 1);
                }else{
                    to_page(result.extend.pageInfo.pageNum + 1);
                }
            });
            lastPageLi.click(function () {
                if (idNumber.length!=0){
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
                if (idNumber.length!=0){
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

    /*单个删除*/
    $(document).on("click", ".delete_btn", function () {
        //弹出是否删除对话框
        var name = $(this).parents("tr").find("td:eq(2)").text();
        var id = $(this).attr("del-id");
        var idNumber = document.getElementById("search-input").value;
        if (confirm("确认删除【" + name + "】吗？")) {
            //确认发送AJAX请求
            $.ajax({
                url: "${APP_PATH}/student/deleteBy/" + id,
                type: "PUT",
                success: function (result) {
                    alert(result.msg);
                    if (idNumber.length!=0){
                        to_page_with_conditon(currentPage);
                    }else{
                        to_page(currentPage);
                    }
                }
            });
        }
    });

    //全选全不选
    $("#check_all").click(function () {
        $(".check_item").prop("checked", $(this).prop("checked"));
    });

    $(document).on("click", ".check_item", function () {
        //判断check_item是否全选
        var flag = $(".check_item:checked").length == $(".check_item").length;
        $("#check_all").prop("checked", flag);
    });

    //点击删除则批量删除
    $("#student_delete_all_btn").click(function () {
        var names = "";
        var del_idstr = "";
        var idNumber = document.getElementById("search-input").value;
        $.each($(".check_item:checked"), function () {
            names += $(this).parents("tr").find("td:eq(2)").text() + ",";
            del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });
        names = names.substring(0, names.length - 1);
        del_idstr = del_idstr.substring(0, del_idstr.length - 1);
        if (confirm("确认删除【" + names + "】吗？")) {
            //发送AJAX请求
            $.ajax({
                url: "${APP_PATH}/student/deleteBy/" + del_idstr,
                type: "PUT",
                success: function (result) {
                    alert(result.msg);
                    if (idNumber.length!=0){
                        to_page_with_conditon(currentPage);
                    }else{
                        to_page(currentPage);
                    }
                }
            });
        }
    });

    $(document).on("click", ".detail_btn", function () {
        var id = $(this).attr("detail-id");
        $.ajax({
            url: "${APP_PATH}/student/toStudentDetail",
            data: "id="+id,
            type: "POST",
            success: function (result) {
                window.location.href="${APP_PATH}/studentDetail.jsp";
            }
        });
    });
    var wb;//读取完成的数据
    var rABS = false; //是否将文件读取为二进制字符串

    function importf(obj) {
        //学生信息导入
        if (!obj.files) {
            return;
        }
        var f = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var data = e.target.result;
            if (rABS) {
                wb = XLSX.read(btoa(fixdata(data)), {//手动转化
                    type: 'base64'
                });
            } else {
                wb = XLSX.read(data, {
                    type: 'binary'
                });
            }
            //wb.SheetNames[0]是获取Sheets中第一个Sheet的名字
            //wb.Sheets[Sheet名]获取第一个Sheet的数据
            // document.getElementById("demo").innerHTML = JSON.stringify(XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]));
            // console.log(wb)
             //console.log(XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]))
            var json = JSON.stringify(XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]));
            console.log(json);
            $.ajax({
                url: "${APP_PATH}/student/readStudentInfo",
                type: 'post',
                data: json,
                contentType: 'application/json',
                success: function (result) {
                    if(result.code == 100){
                        console.log(result.extend.studentFullInfos);
                        openCard(result.extend.studentFullInfos);
                    }else if(result.code == 200){
                        alert("上传失败，Excel请严格按照格式填写信息");
                    }
                }
            });
        };
        if (rABS) {
            reader.readAsArrayBuffer(f);
        } else {
            reader.readAsBinaryString(f);
        }
    }

    function importf2(obj) {
        //家庭成员信息导入
        var idNumber = document.getElementById("search-input").value;
        if (!obj.files) {
            return;
        }
        var f = obj.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            var data = e.target.result;
            if (rABS) {
                wb = XLSX.read(btoa(fixdata(data)), {//手动转化
                    type: 'base64'
                });
            } else {
                wb = XLSX.read(data, {
                    type: 'binary'
                });
            }
            //wb.SheetNames[0]是获取Sheets中第一个Sheet的名字
            //wb.Sheets[Sheet名]获取第一个Sheet的数据
            // document.getElementById("demo").innerHTML = JSON.stringify(XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]));
            // console.log(wb)
            //console.log(XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]))
            var json = JSON.stringify(XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]));
            console.log(json);
            $.ajax({
                url: "${APP_PATH}/student/readFamily",
                type: 'post',
                data: json,
                contentType: 'application/json',
                success: function (result) {
                    if(result.code == 100){
                        alert("上传成功");
                        if (idNumber.length!=0){
                            to_page_with_conditon(currentPage);
                        }else{
                            to_page(currentPage);
                        }
                    }else if(result.code == 200){
                        alert("上传失败，Excel请严格按照格式填写信息");
                    }
                }
            });
        };
        if (rABS) {
            reader.readAsArrayBuffer(f);
        } else {
            reader.readAsBinaryString(f);
        }
    }
    function openCard(info) {
        var idNumber = document.getElementById("search-input").value;
        var json = JSON.stringify(info);
        $.ajax({
            url: "${APP_PATH}/opendCard",
            type: "POST",
            data:json,
            contentType: 'application/json',
            success: function (result) {
                if (idNumber.length!=0){
                    alert("上传成功");
                    to_page_with_conditon(currentPage);
                }else{
                    alert("上传成功");
                    to_page(currentPage);
                }
            }
        });
    }
</script>
</html>