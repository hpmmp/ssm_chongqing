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
<!-- 审核模态框 -->
<div class="modal fade" id="examineModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">资助对象审核</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">审核情况:</label>
                        <div class="col-sm-9">
                            <label class="radio-inline">
                                <input type="radio" name="status" id="status1_examine_input" value=3 checked="checked">审核通过
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="status" id="status2_examine_input" value=2 >审核未通过
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">审核未通过原因</label>
                        <div class="col-sm-6">
                            <input type="text" name="noPassReason" class="form-control" id="noPassReason_examine_input"
                                   placeholder="审核通过则不要填写">
                            <span class="help-block"></span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="examine_confirm_btn">确认</button>
            </div>
        </div>
    </div>
</div>
<!-- 查看模态框 -->
<div class="modal fade" id="lookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">资助对象详情</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="col-sm-3 control-label">姓名</label>
                        <div class="col-sm-6">
                            <input type="text" name="name" class="form-control" id="name_look_input" disabled="disabled">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">项目名</label>
                        <div class="col-sm-6">
                            <input type="text" name="projectName" class="form-control" id="projectName_look_input" disabled="disabled">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">状态</label>
                        <div class="col-sm-6">
                            <input type="text" name="status" class="form-control" id="status_look_input" disabled="disabled">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">退回时间</label>
                        <div class="col-sm-6">
                            <input type="text" name="returnedAt" class="form-control" id="returnedAt_look_input" disabled="disabled">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label">不通过原因</label>
                        <div class="col-sm-6">
                            <input type="text" name="noPassReason" class="form-control" id="noPassReason_look_input" disabled="disabled">
                            <span class="help-block"></span>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row">
        <h3 class="title"></h3>
    </div>

    <%--按钮--%>
    <div class="row"></div>
    <div class="col-md-offset-8">
        <a class="file btn btn-success glyphicon glyphicon-star">资助对象导入
            <input type="file" onchange="importf(this)" />
        </a>
        <button class="btn btn-warning" id="projectStatus_change_btn">变更项目状态</button>
    </div>

    <div class="row">
        <div class=".col-md-12">
            <table class="table table-hover" id="fundedObject_table">
                <thead>
                <tr class="title-tr">
                    <td>姓名</td>
                    <td>性别</td>
                    <td>身份证号码</td>
                    <td>户籍所在地</td>
                    <td>学校名称</td>
                    <td>资助来源类型</td>
                    <td>项目说明</td>
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

    var totalRecord, currentPage,fundedProjectResult;

    //1页面加载完成发送ajax请求，要到分页数据
    $(document).ready(function(){
        to_page(1);
    });

    //跳转到对应页码
    function to_page(pn) {
        build_title();
        $.ajax({
            url: "${APP_PATH}/fundedObject/getFundedObjects",
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
                fundedProjectResult =  result.extend.fundedProject;
                $(".title").html(fundedProjectResult.name+"("+fundedProjectResult.status+")");
            }
        });
    }

    //解析显示table
    function build_fundedObject_table(result) {
        $("#fundedObject_table tbody").empty();
        var projectStudents = result.extend.pageInfo.list;
        $.each(projectStudents, function (index, item) {
            var nameTd = $("<td></td>").append(item.student.name);
            var genderTd = $("<td></td>").append(item.student.gender == 1 ? "男" : "女");
            var idNumberTd = $("<td></td>").append(item.idNumber);
            var censusRegisterTd = $("<td></td>").append(item.student.censusRegister);
            var schoolNameTd = $("<td></td>").append(item.schoolName);
            var fromTypeTd = $("<td></td>").append(item.fromType==1?"Excel导入":"在线申请");
            var descriptionTd = $("<td></td>").append(item.fundedProject.description);
            if(item.status=="审核未通过"){
                var statusTd = $("<td></td>").append(item.status).css("color","red");
            }else if(item.status=="审核通过"||item.status=="资助金已发放"){
                var statusTd = $("<td></td>").append(item.status).css("color","green");
            }else if(item.status=="待审核"){
                var statusTd = $("<td></td>").append(item.status).css("color","FF9900");
            }else if(item.status=="审核超时"){
                var statusTd = $("<td></td>").append(item.status).css("color","000077");
            }

            if(item.status=="待审核"){
                var operationBtn = $("<td></td>").addClass("btn btn-primary btn-sm examine_btn")
                    .append("<span></span>").addClass("glyphicon glyphicon-pencil").append("审核");
                operationBtn.attr("examine-id", item.id);
            }else{
                var operationBtn = $("<td></td>").addClass("btn btn-primary btn-sm look_btn")
                    .append("<span></span>").addClass("glyphicon glyphicon-pencil").append("查看");
                operationBtn.attr("look-id",item.id);
            }
            $("<tr></tr>").append(nameTd)
                .append(genderTd)
                .append(idNumberTd)
                .append(censusRegisterTd)
                .append(schoolNameTd)
                .append(fromTypeTd)
                .append(descriptionTd)
                .append(statusTd)
                .append(operationBtn)
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

    var wb;//读取完成的数据
    var rABS = false; //是否将文件读取为二进制字符串
    function importf(obj) {
        //判断项目状态不为申请中不能导入excel
        if(fundedProjectResult.status!="资助申请中"){
            alert("项目状态不为申请中，无法导入资助对象文件")
            return;
        }
        //资助对象导入
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


            var studentIdList = XLSX.utils.sheet_to_json(wb.Sheets[wb.SheetNames[0]]);
            var list = [];
            for (let i = 0; i <studentIdList.length ; i++) {
                list.push(studentIdList[i].studentId);
            }
            list.push(${projectId});
            list = JSON.stringify(list);
            $.ajax({
                url: "${APP_PATH}/fundedObject/readFundedObjectInfo",
                type: 'POST',
                data: list,
                contentType: 'application/json',
                success: function (result) {
                    if(result.extend.number>0){
                        alert("成功上传了"+result.extend.number+"条资助申请");
                        to_page(1);
                    }else{
                        alert("资助申请未通过或文件格式错误");
                        to_page(1);
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

    //点击更换项目状态
    $("#projectStatus_change_btn").click(function () {
        if (confirm("确认进入下一项目状态？")){
            $.ajax({
                url: "${APP_PATH}/fundedProject/updateProjectStatus",
                type: "POST",
                data :"projectId="+${projectId},
                success: function (result) {
                    if(result.code==100){
                        alert("已更换项目状态");
                        to_page(currentPage);
                    }else{
                        alert("项目已完成无法更换状态");
                        to_page(currentPage);
                    }
                }
            })
        }
    });

    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        $(ele).find(".help-block").text("");
    }
    //点击审核
    $(document).on("click", ".examine_btn", function () {
        //判断状态是否为资助审核中
        if(fundedProjectResult.status!="资助审核中"){
            alert("项目状态不为资助审核中，无法进行审核");
            return;
        }
        reset_form("#examineModal form");
        $("#examine_confirm_btn").attr("examine-id", $(this).attr("examine-id"));
        $("#examineModal").modal({
            backdrop: 'static'
        })
    });

    //点击确认，提交审核
    $("#examine_confirm_btn").click(function () {
        $.ajax({
            url: "${APP_PATH}/fundedObject/examine/" + $(this).attr("examine-id"),
            type: "PUT",
            data :$("#examineModal form").serialize(),
            success: function (result) {
                $("#examineModal").modal("hide");
                alert(result.msg);
                to_page(currentPage);
            }
        })
    });
    //点击查看
    $(document).on("click", ".look_btn", function () {
        getLook($(this).attr("look-id"));
        $("#lookModal").modal({
            backdrop: 'static'
        });
    });
    function getLook(id) {
        $.ajax({
            url: "${APP_PATH}/fundedObject/getLook",
            data: "id="+id,
            type: "GET",
            success: function (result) {
                var projectStudent = result.extend.projectStudent;
                $("#name_look_input").val(projectStudent.student.name);
                $("#projectName_look_input").val(projectStudent.fundedProject.name);
                $("#status_look_input").val(projectStudent.status);
                $("#returnedAt_look_input").val(projectStudent.returnedAt);
                $("#noPassReason_look_input").val(projectStudent.noPassReason);
            }
        });
    }
</script>
</html>