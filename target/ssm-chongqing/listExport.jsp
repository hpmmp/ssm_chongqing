<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <meta charset="UTF-8">
    <title>贫困生资助管理信息系统</title>
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
    <div class="col-md-offset-10">
        <button class="btn btn-info glyphicon glyphicon-star-empty" onclick="getJsono()">公示名单导出</button>
    </div>

    <script type="text/javascript">

        function getJsono(){
            $.ajax({
                url: "${APP_PATH}/projectPublicity/getListExportInfo",
                type: "POST",
                data: "projectId="+${projectId},
                success: function (result) {
                    var projectName = result.extend.listExportInfoList[0].projectName;
                    downloadExl(result.extend.listExportInfoList,projectName);
                }
            });
        }
        //如果使用 FileSaver.js 就不要同时使用以下函数
        function saveAs(obj, fileName) {//当然可以自定义简单的下载文件实现方式
            var tmpa = document.createElement("a");
            tmpa.download = fileName || "下载";
            tmpa.href = URL.createObjectURL(obj); //绑定a标签
            tmpa.click(); //模拟点击实现下载
            setTimeout(function () { //延时释放
                URL.revokeObjectURL(obj); //用URL.revokeObjectURL()来释放这个object URL
            }, 100);
        }

        const wopts = { bookType: 'xlsx', bookSST: false, type: 'binary' };//这里的数据是用来定义导出的格式类型


        function downloadExl(data,type) {
            const wb = { SheetNames: ['Sheet1'], Sheets: {}, Props: {} };
            wb.Sheets['Sheet1'] = XLSX.utils.json_to_sheet(data);//通过json_to_sheet转成单页(Sheet)数据
            saveAs(new Blob([s2ab(XLSX.write(wb, wopts))], { type: "application/octet-stream" }), type + '.' + (wopts.bookType=="biff2"?"xls":wopts.bookType));
        }
        function s2ab(s) {
            if (typeof ArrayBuffer !== 'undefined') {
                var buf = new ArrayBuffer(s.length);
                var view = new Uint8Array(buf);
                for (var i = 0; i != s.length; ++i) view[i] = s.charCodeAt(i) & 0xFF;
                return buf;
            } else {
                var buf = new Array(s.length);
                for (var i = 0; i != s.length; ++i) buf[i] = s.charCodeAt(i) & 0xFF;
                return buf;
            }
        }
    </script>

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
                    <td>项目对象补充说明</td>
                    <td>状态</td>
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
            var nameTd = $("<td></td>").append(item.student.name);
            var genderTd = $("<td></td>").append(item.student.gender == 1 ? "男" : "女");
            var idNumberTd = $("<td></td>").append(item.idNumber);
            var censusRegisterTd = $("<td></td>").append(item.student.censusRegister);
            var schoolNameTd = $("<td></td>").append(item.schoolName);
            var fromTypeTd = $("<td></td>").append(item.fromType==1?"Excel导入":"在线申请");
            var limitCommentTd = $("<td></td>").append(item.fundedProject.limitComment);
            if(item.status=="审核未通过"){
                var statusTd = $("<td></td>").append(item.status).css("color","red");
            }else if(item.status=="审核通过"){
                var statusTd = $("<td></td>").append(item.status).css("color","green");
            }else if(item.status=="待审核"){
                var statusTd = $("<td></td>").append(item.status).css("color","FF9900");
            }else if(item.status=="审核超时"){
                var statusTd = $("<td></td>").append(item.status).css("color","000077");
            }

            $("<tr></tr>").append(nameTd)
                .append(genderTd)
                .append(idNumberTd)
                .append(censusRegisterTd)
                .append(schoolNameTd)
                .append(fromTypeTd)
                .append(limitCommentTd)
                .append(statusTd)
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

</script>
</html>