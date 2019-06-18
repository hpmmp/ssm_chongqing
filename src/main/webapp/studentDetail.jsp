<%--
  Created by IntelliJ IDEA.
  User: hello
  Date: 2019/5/5
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>学生详细信息</title>
    <%
        pageContext.setAttribute("APP_PATH", request.getContextPath());
    %>
    <link rel="stylesheet" type="text/css" href="${APP_PATH}/static/css/userList.css"/>
    <script type="text/javascript" src="${APP_PATH}/static/js/jquery-2.1.1.min.js"></script>
    <link href="${APP_PATH}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 家庭成员编辑模态框 -->
<div class="modal fade" id="familyMemberUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">家庭成员修改</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="familyMember-info">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="name_update_input"
                                   placeholder="name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">文化程度</label>
                        <div class="col-sm-10">
                            <input type="text" name="education" class="form-control" id="education_update_input"
                                   placeholder="education">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职业</label>
                        <div class="col-sm-10">
                            <input type="text" name="career" class="form-control" id="career_update_input"
                                   placeholder="career">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">年收入</label>
                        <div class="col-sm-10">
                            <input type="text" name="annualIncome" class="form-control" id="annualIncome_update_input"
                                   placeholder="annualIncome">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" name="phone" class="form-control" id="phone_update_input"
                                   placeholder="phone">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <input type="text" name="remark" class="form-control" id="remark_update_input"
                                   placeholder="remark">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">户主</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="isHouseholder" id="isHouseholder1_update_input" value=1 > 是
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="isHouseholder" id="isHouseholder2_update_input" value=2 > 否
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="familyMember_update_btn">更新</button>
            </div>
        </div>
    </div>
</div>
<!-- 家庭成员添加模态框 -->
<div class="modal fade" id="familyMemberAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title">家庭成员添加</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="familyMember-add-info">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">姓名</label>
                        <div class="col-sm-10">
                            <input type="text" name="name" class="form-control" id="name_add_input"
                                   placeholder="name">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">身份证号码</label>
                        <div class="col-sm-10">
                            <input type="text" name="idNumber" class="form-control" id="idNumber_add_input"
                                   placeholder="idNumber">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">与学生关系</label>
                        <div class="col-sm-10">
                            <input type="text" name="relationship" class="form-control" id="relationship_add_input"
                                   placeholder="relationship">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">文化程度</label>
                        <div class="col-sm-10">
                            <input type="text" name="education" class="form-control" id="education_add_input"
                                   placeholder="education">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">职业</label>
                        <div class="col-sm-10">
                            <input type="text" name="career" class="form-control" id="career_add_input"
                                   placeholder="career">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">年收入</label>
                        <div class="col-sm-10">
                            <input type="text" name="annualIncome" class="form-control" id="annualIncome_add_input"
                                   placeholder="annualIncome">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">联系电话</label>
                        <div class="col-sm-10">
                            <input type="text" name="phone" class="form-control" id="phone_add_input"
                                   placeholder="phone">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">备注</label>
                        <div class="col-sm-10">
                            <input type="text" name="remark" class="form-control" id="remark_add_input"
                                   placeholder="remark">
                            <span class="help-block"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">户主</label>
                        <div class="col-sm-10">
                            <label class="radio-inline">
                                <input type="radio" name="isHouseholder" id="isHouseholder1_add_input" value=1 > 是
                            </label>
                            <label class="radio-inline">
                                <input type="radio" name="isHouseholder" id="isHouseholder2_add_input" value=2 checked="checked"> 否
                            </label>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" id="familyMember_save_btn">保存</button>
            </div>
        </div>
    </div>
</div>
<div class="container">
    <!--个人资料-->
    <div class="row">
        <div class=".col-md-12">
            <h4 class="title">个人资料</h4>
        </div>
    </div>

    <form class="form-inline" id="student_info">
        <div class="row">
            <div class="form-group">
                <label class="control-label" >姓&emsp;&emsp;&emsp;名:</label>
                <label><input type="text" name="name" id="student_name" disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">性&emsp;&emsp;别:&emsp;&emsp;&emsp;&emsp;</label>
                <label class="radio-inline"><input type="radio" name="gender" id="gender1_update_input"
                value=1 disabled="disabled"/>男</label>
                <label class="radio-inline"><input type="radio" name="gender" id="gender2_update_input"
                value=2 disabled="disabled"/> 女</label>
            </div>
            <div class="form-group">
                <label class="control-label">&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;  身份证&emsp;:</label>
                <%--<label><input type="text" name="idNumber" id="student_idNumber" disabled="disabled"/></label>--%>
                <label><p class="form-control-static" name="idNumber" id="student_idNumber"></p>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label class="control-label">监护人姓名:</label>
                <label><input type="text" name="guardianName" id="student_guardianName" disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">监护人身份证:</label>
                <label><input type="text" name="guardianIdNumber" id="student_guardianIdNumber"
                              disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">政治面貌:</label>
                <label><input type="text" name="polity" id="student_polity" disabled="disabled"/></label>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label class="control-label">民&emsp;&emsp;&emsp;族:</label>
                <label><input type="text" name="nation" id="student_nation" disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">手机号码&emsp;&emsp;:</label>
                <label><input type="text" name="phone" id="student_phone" disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">联系人&emsp;:</label>
                <label><input type="text" name="linkman" id="student_linkman" disabled="disabled"/></label>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label class="control-label">联系人电话:</label>
                <label><input type="text" name="linkmanPhone" id="student_linkmanPhone" disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">户籍所在地&emsp;:</label>
                <label><input type="text" name="censusRegister" id="student_censusRegister"
                              disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">详细住址:</label>
                <label><input type="text" name="address" id="student_address" disabled="disabled"/></label>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label class="control-label">邮政编码&emsp;:</label>
                <label><input type="text" name="postcode" id="student_postcode" disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">邮箱&emsp;&emsp;&emsp;&emsp;:</label>
                <label><input type="text" name="email" id="student_email" disabled="disabled"/></label>
            </div>
            <div class="form-group">
                <label class="control-label">&emsp;&emsp;qq&emsp;:</label>
                <label><input type="text" name="qq" id="student_qq" disabled="disabled"/></label>
            </div>
        </div>
        <div class="row">
            <div class="form-group">
                <label class="control-label">贫困说明&emsp;:</label>
                <label><input type="text" name="familyPovertyDesc" id="student_familyPovertyDesc" disabled="disabled"/></label>
            </div>

            <div class="form-group">
                <label class="control-label">贫困类型:&emsp;&emsp;</label>

                <select name="povertyType" class="form-control" id="povertyTypeSelecter" disabled="disabled">
                    <option id="povertyType0" value=0>其他</option>
                    <option id="povertyType1" value=1>建档立卡</option>
                    <option id="povertyType2" value=2>低保</option>
                    <option id="povertyType3" value=3>特困救助</option>
                    <option id="povertyType4" value=4>残疾</option>
                    <option id="povertyType5" value=5>孤儿</option>
                </select>

            </div>
        </div>
    </form>

    <div class="row">
        <div class="col-md-offset-8">
            <button class="btn btn-primary glyphicon glyphicon-pencil" id="student_update_btn">编辑</button>
            <button class="btn btn-info glyphicon glyphicon-ok" id="student_save_btn">保存</button>
        </div>
    </div>
    <!--学籍信息-->
    <div class="row">
        <div class=".col-md-12">
            <h4 class="title">学籍信息</h4>
        </div>
    </div>
    <form class="form-inline" id="student_status">
        <div class="row">
            <div class="form-group col-md-4">
                <label class="control-label">学校名称:&emsp;&emsp;&emsp;</label>
                <label class="control-label"><p class="form-control-static" id="studentStatus_schoolName"></p>
                </label>
            </div>
            <div class="form-group col-md-4">
                <label class="control-label">学段&emsp;&emsp;:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</label>
                <label class="control-label"><p class="form-control-static" id="studentStatus_schoolPhase"></p></label>
            </div>
            <div class="form-group col-md-4">
                <label class="control-label">专业名称:&emsp;&emsp;&emsp;&emsp;</label>
                <label class="control-label"><p class="form-control-static" id="studentStatus_majorName"></p>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label class="control-label">生源地&emsp;:&emsp;&emsp;&emsp;&emsp;&emsp;</label>
                <label class="control-label"><p class="form-control-static" id="studentStatus_origin"></p>
                </label>
            </div>
            <div class="form-group col-md-4">
                <label class="control-label">录取年份:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</label>
                <%--<label><input type="text" name="birthday" id="student_birthday" disabled="disabled"/></label>--%>
                <label class="control-label"><p class="form-control-static" id="studentStatus_enrollYear"></p></label>
            </div>
            <div class="form-group col-md-4">
                <label class="control-label">学制&emsp;&emsp;:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</label>
                <%--<label><input type="text" name="idNumber" id="student_idNumber" disabled="disabled"/></label>--%>
                <label class="control-label"><p class="form-control-static" id="studentStatus_schoolLength"></p>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label class="control-label">期间&emsp;&emsp;:&emsp;&emsp;</label>
                <%--<label><input type="text" name="idNumber" id="student_idNumber" disabled="disabled"/></label>--%>
                <label class="control-label"><p class="form-control-static" id="studentStatus_Period"></p>
                </label>
            </div>
            <div class="form-group col-md-4">
                <label class="control-label">学号&emsp;&emsp;:&emsp;&emsp;&emsp;&emsp;&emsp;</label>
                <%--<label><input type="text" name="birthday" id="student_birthday" disabled="disabled"/></label>--%>
                <label class="control-label"><p class="form-control-static" id="studentStatus_schoolNo"></p></label>
            </div>
            <div class="form-group col-md-4">
                <label class="control-label">学籍号&emsp;:&emsp;&emsp;&emsp;&emsp;</label>
                <%--<label><input type="text" name="idNumber" id="student_idNumber" disabled="disabled"/></label>--%>
                <label class="control-label"><p class="form-control-static" id="studentStatus_studentCode"></p>
                </label>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-md-4">
                <label class="control-label">培养层次:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</label>
                <%--<label><input type="text" name="birthday" id="student_birthday" disabled="disabled"/></label>--%>
                <label class="control-label"><p class="form-control-static" id="studentStatus_schoolLevel"></p></label>
            </div>
            <div class="form-group col-md-4">
                <label class="control-label">学籍状态:&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</label>
                <%--<label><input type="text" name="idNumber" id="student_idNumber" disabled="disabled"/></label>--%>
                <label class="control-label"><p class="form-control-static" id="studentStatus_status"></p>
                </label>
            </div>
        </div>
    </form>
    <!--家庭信息-->
    <div class="row">
        <div class=".col-md-12">
            <h4 class="title">家庭成员信息</h4>
        </div>
    </div>
    <div class=".col-md-12">
        <table class="table table-hover" id="familyMember_table">
            <thead>
            <tr class="title-tr">
                <td>id</td>
                <td>姓名</td>
                <td>出生年月日</td>
                <td>与学生关系</td>
                <td>文化程度</td>
                <td>职业</td>
                <td>年收入</td>
                <td>联系电话</td>
                <td>备注</td>
                <td>操作</td>
            </tr>
            </thead>
            <tbody>

            </tbody>
        </table>
    </div>
    <div class="row">
        <div>
            <button class="btn btn btn-success glyphicon glyphicon-plus" id="familyMember_add_btn">新增</button>
        </div>
    </div>
</div>
</body>

<script type="text/javascript">

    var InfoResult;

    //进入界面加载内容
    $(document).ready(function(){
        loadInfo();
    });

    function loadInfo(){
        $.ajax({
            url: "${APP_PATH}/student/getInfoById",
            data: "id=" + ${studentId},
            type: "GET",
            success: function (result) {
                InfoResult = result;
                fill_studentInfo(result);
                fill_studentStatus(result);
                fill_familyMember(result);
            }
        });
    }

    /*填入学生表信息*/
    function fill_studentInfo(result){
        var student = result.extend.student;
        $("#student_name").val(student.name);
        if(student.gender==1){
            $("#gender1_update_input").attr("checked","checked");
        }else{
            $("#gender2_update_input").attr("checked","checked");
        }
        document.getElementById("student_idNumber").innerText= student.idNumber;
        $("#student_guardianName").val(student.guardianName);
        $("#student_guardianIdNumber").val(student.guardianIdNumber);
        $("#student_polity").val(student.polity);
        $("#student_nation").val(student.nation);
        $("#student_phone").val(student.phone);
        $("#student_linkman").val(student.linkman);
        $("#student_linkmanPhone").val(student.linkmanPhone);
        $("#student_censusRegister").val(student.censusRegister);
        $("#student_address").val(student.address);
        $("#student_postcode").val(student.postcode);
        $("#student_email").val(student.email);
        $("#student_qq").val(student.qq);
        $("#student_familyPovertyDesc").val(student.familyPovertyDesc);
        $("#povertyTypeSelecter").val(student.povertyType);

    }
    /*插入学籍信息*/
    function fill_studentStatus(result){
        var studentStatus = result.extend.studentStatus;
        document.getElementById("studentStatus_schoolName").innerText= studentStatus.schoolName;
        document.getElementById("studentStatus_schoolPhase").innerText= studentStatus.schoolPhase;
        document.getElementById("studentStatus_majorName").innerText= studentStatus.majorName;
        document.getElementById("studentStatus_origin").innerText= studentStatus.origin;
        document.getElementById("studentStatus_enrollYear").innerText= studentStatus.enrollYear;
        document.getElementById("studentStatus_schoolLength").innerText= studentStatus.schoolLength;
        document.getElementById("studentStatus_Period").innerText= studentStatus.startDate+"至"+studentStatus.endDate;
        document.getElementById("studentStatus_schoolNo").innerText= studentStatus.schoolNo;
        document.getElementById("studentStatus_studentCode").innerText= studentStatus.studentCode;
        document.getElementById("studentStatus_schoolLevel").innerText= studentStatus.schoolLevel;
        document.getElementById("studentStatus_status").innerText= studentStatus.status;
    }
    /*插入家庭成员信息*/
    function fill_familyMember(result){
        $("#familyMember_table tbody").empty();
        var familyMembers = result.extend.familyMembers;
        $.each(familyMembers, function (index, item) {
            var idTd = $("<td></td>").append(item.id);
            var nameTd = $("<td></td>").append(item.name).append(item.isHouseholder==1?"(户主)":"");
            var birthdayTd = $("<td></td>").append(item.birthday);
            var relationshipTd = $("<td></td>").append(item.relationship);
            var educationTd = $("<td></td>").append(item.education);
            var careerTd = $("<td></td>").append(item.career);
            var annualIncomeTd = $("<td></td>").append(item.annualIncome);
            var phoneTd = $("<td></td>").append(item.phone);
            var remark = $("<td></td>").append(item.remark);



            var editBtn = $("<td></td>").addClass("btn btn-primary btn-sm edit_btn")
                .append("<span></span>").addClass("glyphicon glyphicon-pencil")
                .append("编辑");
            editBtn.attr("edit-id", item.id);
            var delBtn = $("<td></td>").addClass("btn btn-danger btn-sm delete_btn")
                .append("<span></span>").addClass("glyphicon glyphicon-trash")
                .append("删除");
            delBtn.attr("del-id",item.id);
            var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn);

            $("<tr></tr>").append(idTd)
                .append(nameTd)
                .append(birthdayTd)
                .append(relationshipTd)
                .append(educationTd)
                .append(careerTd)
                .append(annualIncomeTd)
                .append(phoneTd)
                .append(remark)
                .append(btnTd)
                .appendTo("#familyMember_table tbody");
        })
    }
    /*学生编辑按钮*/
    $("#student_update_btn").click(function () {
        var inputs = $('#student_info input');
        //遍历input标签并将状态设为可编辑
        $.each(inputs, function (index, item) {
            item.disabled = false;
        });
        $("#povertyTypeSelecter").removeAttr("disabled");
    });
    /*学生保存按钮*/
    $("#student_save_btn").click(function () {

        //1将input框内消息提交保存
        var student =$("#student_info").serialize();
        var id = ${studentId};
        $.ajax({
            url: "${APP_PATH}/student/saveStudentInfo",
            type: "POST",
            data:student+"&id="+id,
            success: function (result) {
                //判断是否保存成功
                if (result.code == 100) {
                    loadInfo();
                    alert(result.msg);
                } else {
                    fill_studentInfo(InfoResult);
                    alert(result.msg);
                }
            }
        });
        var inputs = $('#student_info input');
        //遍历input标签并将状态设为不可编辑
        $.each(inputs, function (index, item) {
            item.disabled = true;
        });
        $("#povertyTypeSelecter").attr("disabled", "disabled");
    });
    /*家庭成员删除*/
    $(document).on("click", ".delete_btn", function () {
        //弹出是否删除对话框
        var name = $(this).parents("tr").find("td:eq(1)").text();
        var id = $(this).attr("del-id");
        if (confirm("确认删除【" + name + "】吗？")) {
            //确认发送AJAX请求
            $.ajax({
                url: "${APP_PATH}/student/deleteFamilyById/" + id,
                type: "PUT",
                success: function (result) {
                    loadInfo();
                }
            });
        }
    });
    //点击编辑
    $(document).on("click", ".edit_btn", function () {
        getFamilyMember($(this).attr("edit-id"));
        $("#familyMember_update_btn").attr("edit-id", $(this).attr("edit-id"));
        $("#familyMemberUpdateModal").modal({
            backdrop: 'static'
        })
    });
    /*获取家庭成员信息填入模态框*/
    function getFamilyMember(id) {
        $.ajax({
            url: "${APP_PATH}/student/getFamilyMemberInfo/" + id,
            meth: "GET",
            success: function (result) {
                var familyMember = result.extend.familyMember;
                $("#name_update_input").val(familyMember.name);
                $("#education_update_input").val(familyMember.education);
                $("#career_update_input").val(familyMember.career);
                $("#annualIncome_update_input").val(familyMember.annualIncome);
                $("#phone_update_input").val(familyMember.phone);
                $("#remark_update_input").val(familyMember.remark);
                $("#familyMemberUpdateModal input[name=isHouseholder]").val([familyMember.isHouseholder]);
            }
        });
    }
    //点击更新，更新家庭成员信息
    $("#familyMember_update_btn").click(function () {
        $.ajax({
            url: "${APP_PATH}/student/updateFamilyMember/" + $(this).attr("edit-id"),
            type: "PUT",
            data: $("#familyMemberUpdateModal form").serialize(),
            success: function (result) {
                $("#familyMemberUpdateModal").modal("hide");
                loadInfo();
            }
        })
    });
    //清空表单样式及内容
    function reset_form(ele) {
        $(ele)[0].reset();
        $(ele).find(".help-block").text("");
    }
    //点击新增家庭成员按钮，弹出模态框
    $("#familyMember_add_btn").click(function () {
        reset_form("#familyMemberAddModal form");
        //查询部门信息，显示下拉列表
        $("#familyMemberAddModal").modal({
            backdrop: 'static'
        })
    });
    /*家庭成员新增保存按钮*/
    $("#familyMember_save_btn").click(function () {

        //1将input框内消息提交保存
        var familyMember =$("#familyMember-add-info").serialize();
        var studentId = ${studentId};
        $.ajax({
            url: "${APP_PATH}/student/addFamilyMemberInfo",
            type: "POST",
            //data:familyMember+"&id="+id,
            data :familyMember+"&studentId="+studentId,
            success: function (result) {
                $("#familyMemberAddModal").modal("hide");
                alert(result.msg);
                loadInfo();
            }
        });
    });


</script>
</html>
