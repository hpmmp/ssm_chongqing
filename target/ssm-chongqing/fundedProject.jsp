<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>贫困生管理系统</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
        pageContext.setAttribute("adminId", request.getParameter("adminId"));

    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/userList.css"/>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.1.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

<body>
<!-- 项目编辑模态框 -->
<div class="modal fade" id="projectUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">资助项目编辑</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="projectType-update-info">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目分类</label>
                        <div class="col-sm-6">
                            <select name="projectTypeId" class="form-control" id="projectTypeId_update_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学年</label>
                        <div class="col-sm-2">
                            <input type="text" name="year" class="form-control" id="year_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学期</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="term" id="term1_update_input" value="1" checked="checked"> 第一学期
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="term" id="term2_update_input" value="2">第二学期
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="name_update_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">发起单位</label>
                        <div class="col-sm-4">
                            <input type="text" name="sponsor" class="form-control" id="sponsor_update_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目说明</label>
                        <div class="col-sm-10">
                            <input type="text" name="description" class="form-control" id="description_update_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资助标准</label>
                        <div class="col-sm-4">
                            <input type="text" name="amount" class="form-control" id="amount_update_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资助标准补充说明</label>
                        <div class="col-sm-10">
                            <input type="text" name="standardComment" class="form-control" id="standardComment_update_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学段</label>
                        <div class="col-sm-4">
                            <select name="phase" class="form-control" id="phase_update_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">贫困类型</label>
                        <div class="col-sm-4">
                            <select name="type" class="form-control" id="type_update_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资助对象补充说明</label>
                        <div class="col-sm-10">
                            <input type="text" name="limitComment" class="form-control" id="limitComment_update_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="project_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<!-- 项目添加模态框 -->
<div class="modal fade" id="projectAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">资助项目添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="projectType-add-info">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目分类</label>
                        <div class="col-sm-6">
                            <select name="projectTypeId" class="form-control" id="projectTypeId_add_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学年</label>
                        <div class="col-sm-2">
                            <input type="text" name="year" class="form-control" id="year_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学期</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="term" id="term1_add_input" value="1" checked="checked"> 第一学期
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="term" id="term2_add_input" value="2">第二学期
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-8">
                            <input type="text" name="name" class="form-control" id="name_add_input">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">发起单位</label>
                        <div class="col-sm-4">
                            <input type="text" name="sponsor" class="form-control" id="sponsor_add_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目说明</label>
                        <div class="col-sm-10">
                            <input type="text" name="description" class="form-control" id="description_add_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资助标准</label>
                        <div class="col-sm-4">
                            <input type="text" name="amount" class="form-control" id="amount_add_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资助标准补充说明</label>
                        <div class="col-sm-10">
                            <input type="text" name="standardComment" class="form-control" id="standardComment_add_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">学段</label>
                        <div class="col-sm-4">
                            <select name="phase" class="form-control" id="phase_add_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">贫困类型</label>
                        <div class="col-sm-4">
                            <select name="type" class="form-control" id="type_add_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资助对象补充说明</label>
                        <div class="col-sm-10">
                            <input type="text" name="limitComment" class="form-control" id="limitComment_add_select">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="project_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <h3 class="title">资助项目管理</h3>
    </div>

    <div class="row">
        <form>
            <input type="text" placeholder="项目名称" name="projectName"
                   id="search-input" class="search-input col-md-4 col-md-offset-3"/>
            <button id="search-button" class="glyphicon glyphicon-search" type="button">搜索</button>
        </form>
    </div>

    <%--按钮--%>
    <div class="row"></div>
    <div class="col-md-offset-10">
        <button class="btn btn-success glyphicon glyphicon-plus" id="project_add_btn">发起新项目</button>
        <button class="btn btn-danger" id="project_delete_all_btn">删除</button>
    </div>

    <div class="row">
        <div class=".col-md-12">
            <table class="table table-hover" id="project_table">
                <thead>
                <tr class="title-tr">
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <td>Id</td>
                    <td>项目</td>
                    <td>项目分类</td>
                    <td>学年/学期</td>
                    <td>资助学段</td>
                    <td>资助标准</td>
                    <td>发起单位</td>
                    <td>发起日期</td>
                    <td>状态</td>
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
            url: "${APP_PATH}/fundedProject/getFundedProjectInfo",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
                build_fundedProject_table(result);
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
            success: function (result) {
                build_fundedProject_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }
    //解析显示table
    function build_fundedProject_table(result) {
        $("#project_table tbody").empty();
        var fundedProjects = result.extend.pageInfo.list;
        $.each(fundedProjects, function (index, item) {
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var idTd = $("<td></td>").append(item.id);
            var nameTd = $("<td></td>").append(item.name);
            var projectTypeNameTd = $("<td></td>").append(item.projectType.name);
            var time = $("<td></td>").append(item.year+"/"+item.term);
            var phaseTd = $("<td></td>").append(item.phase);
            var amountTd = $("<td></td>").append(item.amount);
            var sponsorTd = $("<td></td>").append(item.sponsor);
            var creatAtTd = $("<td></td>").append(item.creatAt);
            var statusTd = $("<td></td>").append(item.status);

            var editBtn = $("<td></td>").addClass("btn btn-primary btn-sm edit_btn")
                .append("<span></span>").append("编辑");
            editBtn.attr("edit-id", item.id);
            var delBtn = $("<td></td>").addClass("btn btn-danger btn-sm delete_btn")
                .append("<span></span>").append("删除");
            delBtn.attr("del-id",item.id);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);
            $("<tr></tr>").append(checkBoxTd)
                .append(idTd)
                .append(nameTd)
                .append(projectTypeNameTd)
                .append(time)
                .append(phaseTd)
                .append(amountTd)
                .append(sponsorTd)
                .append(creatAtTd)
                .append(statusTd)
                .append(btnTd)
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

    /*单个删除*/
    $(document).on("click", ".delete_btn", function () {
        //弹出是否删除对话框
        var name = $(this).parents("tr").find("td:eq(2)").text();
        var id = $(this).attr("del-id");
        var projectName = document.getElementById("search-input").value;
        if (confirm("确认删除【" + name + "】吗？")) {
            //确认发送AJAX请求
            $.ajax({
                url: "${APP_PATH}/fundedProject/deleteBy/" + id,
                type: "PUT",
                success: function (result) {
                    alert(result.msg);
                    if (projectName.length!=0){
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
    $("#project_delete_all_btn").click(function () {
        var names = "";
        var del_idstr = "";
        var projectName = document.getElementById("search-input").value;
        $.each($(".check_item:checked"), function () {
            names += $(this).parents("tr").find("td:eq(2)").text() + ",";
            del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });
        names = names.substring(0, names.length - 1);
        del_idstr = del_idstr.substring(0, del_idstr.length - 1);
        if (confirm("确认删除【" + names + "】吗？")) {
            //发送AJAX请求
            $.ajax({
                url: "${APP_PATH}/fundedProject/deleteBy/" + del_idstr,
                type: "PUT",
                success: function (result) {
                    alert(result.msg);
                    if (projectName.length!=0){
                        to_page_with_conditon(currentPage);
                    }else{
                        to_page(currentPage);
                    }
                }
            });
        }
    });
    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        $(ele).find(".help-block").text("");
    }

    //点击新增按钮，弹出模态框
    $("#project_add_btn").click(function () {
        reset_form("#projectAddModal form");
        //查询信息，显示下拉列表
        getDropDown1();
        $("#projectAddModal").modal({
            backdrop: 'static'
        })
    });
    function getDropDown1(){
        /*清空信息*/
        $("#projectTypeId_add_select").empty();
        $("#phase_add_select").empty();
        $("#type_add_select").empty();

        /*获取填充*/
        $.ajax({
            url: "${APP_PATH}/fundedProject/getAddDropDown",
            type: "GET",
            success: function (result) {
                $.each(result.extend.dictionaries, function () {
                    if(this.dicType=="NEED_SCHOOL_PHASE"){
                        var optionEle = $("<option></option>").append(this.dicName).attr("value", this.dicValue);
                        optionEle.appendTo("#phase_add_select");
                    }
                    if(this.dicType=="POVERTY_TYPE"){
                        var optionEle = $("<option></option>").append(this.dicName).attr("value", this.dicValue);
                        optionEle.appendTo("#type_add_select");
                    }
                });
                $.each(result.extend.projectTypes, function () {
                    var optionEle = $("<option></option>").append(this.name).attr("value", this.id);
                    optionEle.appendTo("#projectTypeId_add_select");
                });
            }
        });
    }
        function getDropDown2(id){
        /*清空信息*/
        $("#projectTypeId_update_select").empty();
        $("#phase_update_select").empty();
        $("#type_update_select").empty();
        /*获取填充*/
        $.ajax({
            url: "${APP_PATH}/fundedProject/getUpdateDropDown",
            type: "GET",
            success: function (result) {

                $.each(result.extend.dictionaries, function () {
                    if(this.dicType=="NEED_SCHOOL_PHASE"){
                        var optionEle = $("<option></option>").append(this.dicName).attr("value", this.dicValue);
                        optionEle.appendTo("#phase_update_select");
                    }
                    if(this.dicType=="POVERTY_TYPE"){
                        var optionEle = $("<option></option>").append(this.dicName).attr("value", this.dicValue);
                        optionEle.appendTo("#type_update_select");
                    }
                });
                $.each(result.extend.projectTypes, function () {
                    var optionEle = $("<option></option>").append(this.name).attr("value", this.id);
                    optionEle.appendTo("#projectTypeId_update_select");
                });
                getProject(id);
            }
        });
    }
    /*新增保存按钮*/
    $("#project_save_btn").click(function () {
        var projectName = document.getElementById("search-input").value;
        var project = $("#projectAddModal form").serialize();
        //1将input框内消息提交保存
        $.ajax({
            url: "${APP_PATH}/fundedProject/addProject",
            type: "POST",
            data :project+"&userId="+${adminId},
            success: function (result) {
                $("#projectAddModal").modal("hide");
                if (projectName.length!=0){
                    alert(result.msg);
                    to_page_with_conditon(totalRecord);
                }else{
                    alert(result.msg);
                    to_page(totalRecord);
                }
            }
        });
    });
    //点击编辑
    $(document).on("click", ".edit_btn", function () {
        getDropDown2($(this).attr("edit-id"));
        $("#project_update_btn").attr("edit-id", $(this).attr("edit-id"));
        $("#projectUpdateModal").modal({
            backdrop: 'static'
        })
    });
    /*获取信息填入模态框*/
    function getProject(id) {
        $.ajax({
            url: "${APP_PATH}/fundedProject/getProjectInfo/" + id,
            meth: "GET",
            success: function (result) {
                var project = result.extend.project;
                $("#projectTypeId_update_select").val(project.projectTypeId);
                $("#year_update_input").val(project.year);
                $("#projectUpdateModal input[name=term]").val([project.term]);
                $("#name_update_input").val(project.name);
                $("#sponsor_update_select").val(project.sponsor);
                $("#description_update_select").val(project.description);
                $("#amount_update_select").val(project.amount);
                $("#standardComment_update_select").val(project.standardComment);
                $("#phase_update_select").val(project.phase);
                $("#type_update_select").val(project.type);
                $("#limitComment_update_select").val(project.limitComment);
            }
        });
    }
    //点击更新，更新项目分类信息
    $("#project_update_btn").click(function () {
        var projectName = document.getElementById("search-input").value;
        $.ajax({
            url: "${APP_PATH}/fundedProject/updateProject/" + $(this).attr("edit-id"),
            type: "PUT",
            data :$("#projectUpdateModal form").serialize(),
            success: function (result) {
                $("#projectUpdateModal").modal("hide");
                if (projectName.length!=0){
                    alert(result.msg);
                    to_page_with_conditon(currentPage);
                }else{
                    alert(result.msg);
                    to_page(currentPage);
                }
            }
        })
    });
</script>
</html>