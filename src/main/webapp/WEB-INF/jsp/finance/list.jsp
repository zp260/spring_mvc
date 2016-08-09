<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/3
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>合同号</th>
        <th>批次id</th>
        <th>凭证号</th>
        <th>申请资金到位金额</th>
        <th>已付金额</th>
        <th>未付金额</th>
        <th>付款日期</th>

    </tr>
    <c:forEach var="list" items="${list}">
    <tr>
        <td><a href="/finance/edit?id=${list.id}">${list.id}</a> </td>
        <td>${list.conSN}</td>
        <td>${list.stageId}</td>
        <td>${list.certificate}</td>
        <td>${list.receiveMoney}</td>
        <td>${list.paidMoney}</td>
        <td>${list.unpaidMoney} </td>
        <td>${list.paidMoneyDate} </td>
        <td><a href="/finance/del?id=${list.id}">删除</a> </td>
    </tr>
    </c:forEach>

</table>
</body>
</html>
