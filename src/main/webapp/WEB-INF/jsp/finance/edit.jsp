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
<form:form action="/finance/update" method="post" modelAttribute="finance">
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

        <tr>
            <td><form:hidden path="id" value="${one.id}"/>${one.id}</td>
            <td><form:input path="conSN"  value="${one.conSN}"/></td>
            <td><form:input path="stageId" value="${one.stageId}"/></td>
            <td><form:input path="certificate" value="${one.certificate}"/></td>
            <td><form:input path="receiveMoney" value="${one.receiveMoney}"/></td>
            <td><form:input path="paidMoney" value="${one.paidMoney}"/></td>
            <td><form:input path="unpaidMoney" value="${one.unpaidMoney}"/></td>
            <td><form:input path="paidMoneyDate" value="${one.paidMoneyDate}" /> </td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
