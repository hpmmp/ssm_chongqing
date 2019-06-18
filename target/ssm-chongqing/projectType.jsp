<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>项目分类管理</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/userList.css"/>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.1.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>

<body>
<!-- 项目分类修改模态框 -->
<div class="modal fade" id="projectTypeUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">项目分类编辑</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="projectType-update-info">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="name_update_input"
                                   placeholder="name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">说明</label>
                        <div class="col-sm-10">
                            <input type="text" name="description" class="form-control" id="description_update_input"
                                   placeholder="description">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资助频率</label>
                        <div class="col-sm-4">
                            <select name="frequency" class="form-control" id="frequency_update_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目级别</label>
                        <div class="col-sm-4">
                            <select name="level" class="form-control" id="level_update_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="status" id="status1_update_input" value="0" > 停用
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="status" id="status2_update_input" value="1" checked="checked">启用
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="projectType_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<!-- 项目分类添加模态框 -->
<div class="modal fade" id="projectTypeAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">项目分类添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="projectType-add-info">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">名称</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="name_add_input"
                                   placeholder="name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">说明</label>
                        <div class="col-sm-10">
                            <input type="text" name="description" class="form-control" id="description_add_input"
                                   placeholder="description">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">资助频率</label>
                        <div class="col-sm-4">
                            <select name="frequency" class="form-control" id="frequency_add_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">项目级别</label>
                        <div class="col-sm-4">
                            <select name="level" class="form-control" id="level_add_select">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">状态</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="status" id="status1_add_input" value="0" > 停用
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="status" id="status2_add_input" value="1" checked="checked">启用
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="projectType_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
        <h3 class="title">项目分类管理</h3>
    </div>

    <%--按钮--%>
    <div class="row"></div>
    <div class="col-md-offset-9">
        <button class="btn btn-success glyphicon glyphicon-plus" id="projectType_add_modal_btn">新增</button>
        <button class="btn btn-warning glyphicon glyphicon-refresh" id="projectType_statusChange_all_btn">停/启用</button>
    </div>

    <div class="row">
        <div class=".col-md-12">
            <table class="table table-hover" id="projectType_table">
                <thead>
                <tr class="title-tr">
                    <th>
                        <input type="checkbox" id="check_all"/>
                    </th>
                    <td>Id</td>
                    <td>项目分类名称</td>
                    <td>说明</td>
                    <td>资助频率</td>
                    <td>项目级别</td>
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
            url: "${APP_PATH}/projectType/getProjectTypeInfo",
            data: "pn=" + pn,
            type: "GET",
            success: function (result) {
                build_projectType_table(result);
                build_page_info(result);
                build_page_nav(result);
            }
        });
    }
    //解析显示table
    function build_projectType_table(result) {
        $("#projectType_table tbody").empty();
        var projectTypes = result.extend.pageInfo.list;
        $.each(projectTypes, function (index, item) {
            var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>");
            var idTd = $("<td></td>").append(item.id);
            var nameTd = $("<td></td>").append(item.name);
            var descriptionTd = $("<td></td>").append(item.description);
            var frequencyTd = $("<td></td>").append(item.frequency);
            var levelTd = $("<td></td>").append(item.level);
            if(item.status==1){
                var statusTd = $("<td></td>").append("启用").css("color","green");
            }else if(item.status==0){
                var statusTd = $("<td></td>").append("停用").css("color","red");
            }

            var editBtn = $("<td></td>").addClass("btn btn-primary btn-sm edit_btn")
                .append("<span></span>").append("编辑");
            editBtn.attr("edit-id", item.id);
            var statusChangeBtn = $("<td></td>").addClass("btn btn-warning btn-sm statusChange_btn")
                .append("<span></span>").append("停/启用");
            statusChangeBtn.attr("statusChange-id",item.id);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(statusChangeBtn);

            $("<tr></tr>").append(checkBoxTd)
                .append(idTd)
                .append(nameTd)
                .append(descriptionTd)
                .append(frequencyTd)
                .append(levelTd)
                .append(statusTd)
                .append(btnTd)
                .appendTo("#projectType_table tbody");
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
    /*单个停启用*/
    $(document).on("click", ".statusChange_btn", function () {
        //弹出是否停启用对话框
        var name = $(this).parents("tr").find("td:eq(2)").text();
        var id = $(this).attr("statusChange-id");
        if (confirm("确认停启用【" + name + "】吗？")) {
            //确认发送AJAX请求
            $.ajax({
                url: "${APP_PATH}/projectType/statusChange/" + id,
                type: "PUT",
                success: function (result) {
                    to_page(currentPage);
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

    //点击停启用则批量停启用
    $("#projectType_statusChange_all_btn").click(function () {
        var names = "";
        var del_idstr = "";
        $.each($(".check_item:checked"), function () {
            names += $(this).parents("tr").find("td:eq(2)").text() + ",";
            del_idstr += $(this).parents("tr").find("td:eq(1)").text() + "-";
        });
        names = names.substring(0, names.length - 1);
        del_idstr = del_idstr.substring(0, del_idstr.length - 1);
        if (confirm("确认停启用【" + names + "】吗？")) {
            //发送AJAX请求
            $.ajax({
                url: "${APP_PATH}/projectType/statusChange/" + del_idstr,
                type: "PUT",
                success: function (result) {
                    alert(result.msg);
                    to_page(currentPage);
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
    $("#projectType_add_modal_btn").click(function () {
        reset_form("#projectTypeAddModal form");
        //查询信息，显示下拉列表
        getFrequencyAndLevel1();
        $("#projectTypeAddModal").modal({
            backdrop: 'static'
        })
    });
    function getFrequencyAndLevel1(){
        /*清空信息*/
        $("#frequency_add_select").empty();
        $("#level_add_select").empty();

        /*获取填充*/
        $.ajax({
            url: "${APP_PATH}/projectType/getFrequencyAndLevel",
            type: "GET",
            success: function (result) {
                $.each(result.extend.dictionaries, function () {
                    if(this.dicType=="PROJECT_FREQUENCY"){
                        var optionEle = $("<option></option>").append(this.dicName).attr("value", this.dicValue);
                        optionEle.appendTo("#frequency_add_select");
                    }
                    if(this.dicType=="PROJECT_LEVEL"){
                        var optionEle = $("<option></option>").append(this.dicName).attr("value", this.dicValue);
                        optionEle.appendTo("#level_add_select");
                    }
                });
            }
        });

    }
    function getFrequencyAndLevel2(id){
        /*清空信息*/
        $("#frequency_update_select").empty();
        $("#level_update_select").empty();

        /*获取填充*/
        $.ajax({
            url: "${APP_PATH}/projectType/getFrequencyAndLevel",
            type: "GET",
            success: function (result) {
                $.each(result.extend.dictionaries, function () {
                    if(this.dicType=="PROJECT_FREQUENCY"){
                        var optionEle = $("<option></option>").append(this.dicName).attr("value", this.dicValue);
                        optionEle.appendTo("#frequency_update_select");
                    }
                    if(this.dicType=="PROJECT_LEVEL"){
                        var optionEle = $("<option></option>").append(this.dicName).attr("value", this.dicValue);
                        optionEle.appendTo("#level_update_select");
                    }
                });
                getProjectType(id);
            }
        });

    }
    /*新增保存按钮*/
    $("#projectType_save_btn").click(function () {

        //1将input框内消息提交保存
        $.ajax({
            url: "${APP_PATH}/projectType/addProjectType",
            type: "POST",
            data: $("#projectTypeAddModal form").serialize(),
            success: function (result) {
                $("#projectTypeAddModal").modal("hide");
                alert(result.msg);
                to_page(totalRecord);
            }
        });
    });

    //点击编辑
    $(document).on("click", ".edit_btn", function () {
        getFrequencyAndLevel2($(this).attr("edit-id"));
        $("#projectType_update_btn").attr("edit-id", $(this).attr("edit-id"));
        $("#projectTypeUpdateModal").modal({
            backdrop: 'static'
        })
    });

    function getProjectType(id) {
        $.ajax({
            url: "${APP_PATH}/projectType/getProjectTypeBy/" + id,
            meth: "GET",
            success: function (result) {
                var projectType = result.extend.projectType;
                $("#name_update_input").val(projectType.name);
                $("#description_update_input").val(projectType.description);
                $("#projectTypeUpdateModal input[name=status]").val([projectType.status]);
                $("#frequency_update_select").val(projectType.frequency);
                $("#level_update_select").val(projectType.level);
            }
        });
    }
    //点击更新，更新项目分类信息
    $("#projectType_update_btn").click(function () {
        $.ajax({
            url: "${APP_PATH}/projectType/updateProjectType/" + $(this).attr("edit-id"),
            type: "PUT",
            data: $("#projectTypeUpdateModal form").serialize(),
            success: function (result) {
                $("#projectTypeUpdateModal").modal("hide");
                to_page(currentPage);
            }
        })
    });

</script>
</html>