<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/9/14
  Time: 上午11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <!--引用CSS-->
    <link type="text/css" rel="stylesheet" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery.min8.js"></script>
    <script type="text/javascript" src="/js/jquery.date_input.pack.js"></script>

</head>
<body>
<div class="del fl">
    <a href="" class="bt">报关查询</a>
</div>

<div class="start currency_top fl">
    <!--查询栏 start-->
    <form action="/declare" method="post">
    <ul class="oh">
        <li>
            <div class="currency_date">开始日期</div>
            <input class="currency_time date_picker" type="text" name="startDate">
        </li>
        <li>
            <div class="currency_date">结束日期</div>
            <input class="currency_time date_picker" type="text" name="endDate">
        </li>
        <li>
            <input type="submit" class="zj fz" value="查询">
        </li>
    </ul>
    </form>
    <!--查询栏 end-->
</div>

<div class="start currency_wrap">
    <table border="0" cellpadding="0" cellspacing="0" id="declareTab">
        <thead>
        <tr>
            <th>序号</th>
            <th>申报时间</th>
            <th>报关单号</th>
            <th>合同号</th>
            <th>货物名称</th>
            <th>使用单位</th>
            <th>报关金额</th>
        </tr>
        </thead>
<c:forEach var="stage" items="${list}">
        <tr>
            <td>${stage.id}</td>
            <td>${stage.cdTime}</td>
            <td>${stage.cdSN}</td>
            <td>${stage.conSN}</td>
            <td><a href="/goods/getByConStage?stageNum=${stage.stageNum}&conSN=${stage.conSN}">货物列表</a> </td>
            <td>${stage.useORG}</td>
            <td>${stage.cdPrice}</td>
        </tr>
</c:forEach>
    </table>
</div>
<div class="totalPrice currency_cxo">统计：<span></span></div>

<div class="footer fz ra fl">
    <span>版权所有 &copy; 大同煤矿集团有限责任公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：大同市万腾科技股份有限公司</span>
</div>


</body>

<!-- 日历控件 Js -->
<script type="text/javascript">
    $(function () {
        $('.date_picker').date_input();
        sumCdPrice();
    })
    function sumCdPrice(){
       var totalNum =Number(0);
        $("#declareTab tr").each(function(){
            var price = Number($(this).find("td:eq(6)").html());
            if(!isNaN(price)){
                totalNum += price ;
            }
            $(".totalPrice span").html(totalNum);
        });
    }
</script>


</html>
