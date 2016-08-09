<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/3
  Time: 下午5:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/finance/insert" method="post" modelAttribute="finance">
    <table>
        <tr>
            <th>合同号</th>
            <th>批次id</th>
            <th>凭证号</th>
            <th>申请资金到位金额</th>
            <th>已付金额</th>
            <th>未付金额</th>
            <th>付款日期</th>

        </tr>
        <tr>
            <td><form:input path="conSN" /></td>
            <td><form:input path="stageId" /></td>
            <td><form:input path="certificate" /></td>
            <td><form:input path="receiveMoney" /></td>
            <td><form:input path="paidMoney" /></td>
            <td><form:input path="unpaidMoney" /></td>
            <td><form:input path="paidMoneyDate"/> </td>

        </tr>
        <tr>
            <td><input type="submit" value="添加"></td>
        </tr>

    </table>
</form:form>
</body>
</html>
