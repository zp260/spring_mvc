<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/5
  Time: 下午3:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/fully/update" method="post" modelAttribute="fullyFunded">
<table>
    <tr>
        <th>id</th>
        <th>合同号</th>
        <th>申请报告编号</th>
        <th>申请资金</th>
        <th>申请日期</th>
        <th>资金到位金额</th>
        <th>资金到位日期</th>
        <th>申请成功</th>
    </tr>

        <tr>
            <td><input value="${list.id}" name="id" type="hidden" />${list.id}</td>
            <td><input value="${list.conSN}" name="conSN" type="text" /></td>
            <td><input value="${list.askForReportSN}" name="askForReportSN" type="text" /></td>
            <td><input value="${list.askForMoney}" name="askForMoney" type="text" /></td>
            <td><input value="${list.askForDate}" name="askForDate" type="text" /></td>
            <td><input value="${list.receiveMoney}" name="receiveMoney" type="text" /></td>
            <td><input value="${list.receiveMoneyDate}" name="receiveMoneyDate" type="text" /></td>
            <td><input value="${list.success}" name="success" type="text" /></td>
        </tr>
    <tr>
        <td><input type="submit" value="修改"></td>
    </tr>
</table>
</form:form>
</body>
</html>
