<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/9/13
  Time: 下午5:29
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

</head>
<body>
<div class="del fl">
    <a href="" class="bt">付汇查询</a>
</div>

<div class="start currency_top fl">
    <!--查询栏 start-->
    <form action="/payment" method="post">
    <ul class="oh">
        <%--<li class="currency_li">--%>
            <%--<select class="currency_select">--%>
                <%--<option value="001">按使用单位查询</option>--%>
                <%--<option value="002">按时间查询</option>--%>
            <%--</select>--%>
        <%--</li>--%>
        <%--<li>--%>
            <%--<input class="currency_input" type="text">--%>
        <%--</li>--%>
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
    <table border="0" cellpadding="0" cellspacing="0">
        <thead>
        <tr>
            <th>序号</th>
            <th>审批时间</th>
            <th>合同号</th>
            <th>货物</th>
            <th>银行付汇日期</th>
            <th>收汇方收汇日期</th>
            <th>付款币种</th>
            <th>付款金额</th>
            <th>汇率(人民币)</th>
            <th>折人民币金额</th>
            <th>汇率(美元)</th>
            <th>折美元金额</th>
        </tr>
        </thead>
<c:forEach var="stage" items="${list}">
        <tr>
            <td>${stage.stageNum}</td>
            <td>${stage.fhApproveBillTime}</td>
            <td>${stage.conSN}</td>
            <td>查看货物</td>
            <td>${stage.bankFHtime}</td>
            <td>${stage.getFHtime}</td>
            <td>${stage.fhMoneySeed}</td>
            <td>${stage.fhPrice}</td>
            <td>${stage.fhMoneyExchange}</td>
            <td>${stage.fhRMBprice}</td>
            <td>${stage.fhDollarExchange}</td>
            <td>${stage.fhDollarPrice}</td>
        </tr>
</c:forEach>
        <tr class="currency_cxo">
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td>统计：</td>
            <td></td>
            <td>统计：</td>
            <td></td>
            <td>统计：</td>
        </tr>
    </table>
</div>


<div class="footer fz ra fl">
    <span>版权所有 &copy; 大同煤矿集团有限责任公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：大同市万腾科技股份有限公司</span>
</div>


</body>

<!-- 日历控件 Js -->
<script type="text/javascript" src="js/jquery.min8.js"></script>
<script type="text/javascript" src="js/jquery.date_input.pack.js"></script>
<script type="text/javascript">
    $(function () {
        $('.date_picker').date_input();
    })
</script>

<!-- 控制上传文件 Js -->
<script type="text/javascript">
    function app() {
        $("#new_a").click(function () {
            $("#file1").click();
        });
    }
</script>

</html>
