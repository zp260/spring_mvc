<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/4
  Time: 下午4:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/fully/insert" method="post" modelAttribute="fullyFunded">

    <table>
        <tr>
            <th>合同号</th>
            <th>申请报告编号</th>
            <th>申请资金</th>
            <th>申请日期</th>
            <th>资金到位金额</th>
            <th>资金到位日期</th>
            <th>申请成功</th>
        </tr>
        <tr>
            <td><form:input path="conSN"/></td>
            <td><form:input path="askForReportSN"/></td>
            <td><form:input path="askForMoney"/></td>
            <td><form:input path="askForDate"/></td>
            <td><form:input path="receiveMoney"/></td>
            <td><form:input path="receiveMoneyDate"/></td>
            <td><form:input path="success"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
        </tr>
    </table>

</form:form>
</body>
</html>
