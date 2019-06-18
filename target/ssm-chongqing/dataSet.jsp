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
    <script src="${APP_PATH}/static/js/echarts.min.js"></script>
    <script src="${APP_PATH}/static/js/xlsx.full.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <h3 class="title">资助金统计分析</h3>
    </div>
    <%--按钮--%>
    <div class="row"></div>
    <div class="col-md-offset-8">
        <button class="btn btn-info glyphicon glyphicon-adjust" id="get_pieChart_btn">生成饼图</button>
        <button class="btn btn-warning glyphicon glyphicon-align-left" id="get_barGraph_btn">生成柱状图</button>
    </div>
    <br><br><br><br>
    <div class="row"></div>
        <div id="main" class="col-md-offset-3" style="width: 600px;height:400px;"></div>
    <div>
</div>

<script type="text/javascript">

    //点击生成柱状图
    $("#get_barGraph_btn").click(function () {
        $.ajax({
            url: "${APP_PATH}/getbarGraph",
            type: "GET",
            success: function (result) {

                XchartDataList = result.extend.XchartDataList;
                YchartDataList = result.extend.YchartDataList;

                if($.isEmptyObject(XchartDataList)){
                    alert("暂无资助记录,无法生成柱状图");
                    return;
                }


                console.log(XchartDataList);
                console.log(XchartDataList);

                option = {
                    color: ['#3398DB'],
                    tooltip : {
                        trigger: 'axis',
                        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data : XchartDataList,
                            axisTick: {
                                alignWithLabel: true
                            }
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            name:'资助总金额',
                            type:'bar',
                            barWidth: '60%',
                            data:YchartDataList
                        }
                    ]
                };

                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));
                myChart.clear();
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        });
    });

    //点击生成饼图
    $("#get_pieChart_btn").click(function () {
        $.ajax({
            url: "${APP_PATH}/getPieChart",
            type: "GET",
            success: function (result) {

                chartDataList = result.extend.chartDataList;
                nameList = result.extend.nameList;

                if($.isEmptyObject(nameList)){
                    alert("暂无资助记录,无法生成饼图");
                    return;
                }

                option = {
                    title : {
                        text: '资助金发放学段统计饼图',
                        subtext: 'by -重庆籍建卡贫困资助管理信息系统',
                        x:'center'
                    },
                    tooltip : {
                        trigger: 'item',
                        formatter: "{a} <br/>{b} : {c} ({d}%)"
                    },
                    legend: {
                        orient: 'vertical',
                        left: 'left',
                        data: nameList
                    },
                    series : [
                        {
                            name: '资助金总额',
                            type: 'pie',
                            radius : '55%',
                            center: ['50%', '60%'],
                            data:chartDataList,
                            itemStyle: {
                                emphasis: {
                                    shadowBlur: 10,
                                    shadowOffsetX: 0,
                                    shadowColor: 'rgba(0, 0, 0, 0.5)'
                                }
                            }
                        }
                    ]
                };

                // 基于准备好的dom，初始化echarts实例
                var myChart = echarts.init(document.getElementById('main'));
                myChart.clear();
                // 使用刚指定的配置项和数据显示图表。
                myChart.setOption(option);
            }
        });
    });
</script>
</body>
</html>