<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/1
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>货物查询</title>
    <link type="text/css" rel="stylesheet" href="/css/main.css">
    <script type="text/javascript" src="/js/jquery.min8.js"></script>
    <script type="text/javascript" src="/js/jquery.date_input.pack.js"></script>
</head>
<body>
<div class="del fl">
    <a href="" class="bt">货物查询</a>
</div>

<div class="start currency_top fl">
    <!--查询栏 start-->
    <form action="/goods/search" method="post">
    <ul class="oh">
        <li class="currency_li">
            <select class="currency_select" name="filedName">
                <option value="supplier">按供应商查询</option>
                <option value="goodsName">按货物名称查询</option>
                <option value="useORG">按用户名称查询</option>
            </select>
        </li>
        <li>
            <input class="currency_input" type="text" name="value">
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
            <th>货物名称</th>
            <th>供货商</th>
            <th>使用单位</th>
            <th>具体到矿时间</th>
            <th>货物金额</th>
            <th>合同号</th>
        </tr>
        </thead>
        <c:forEach var="list" items="${list}">
            <tr>
                <td>${list.goodsId}</td>
                <td>${list.goodsName}</td>
                <td>${list.supplier}</td>
                <td>${list.useORG}</td>
                <td>${list.goodsArriveCoalDate}</td>
                <td>${list.goodsPrice}</td>
                <td><a href="/conbase/search?fieldName=conSN&value=${list.conSN}">${list.conSN}</a> </td>
            </tr>
        </c:forEach>

    </table>
</div>


<div class="footer fz ra fl">
    <span>版权所有 &copy; 大同煤矿集团有限责任公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;技术支持：大同市万腾科技股份有限公司</span>
</div>


</body>

<!-- 日历控件 Js -->
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

</body>
</html>
