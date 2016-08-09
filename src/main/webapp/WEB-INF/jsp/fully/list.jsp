<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/4
  Time: 下午6:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
</head>
<body>
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
    <c:forEach var="list" items="${list}">
        <tr>
           <td><a href="/fully/edit?id=${list.id}">${list.id}</a></td>
           <td>${list.conSN}</td>
           <td>${list.askForReportSN}</td>
           <td>${list.askForMoney}</td>
           <td>${list.askForDate}</td>
           <td>${list.receiveMoney}</td>
           <td>${list.receiveMoneyDate}</td>
           <td>${list.success}</td>
            <td><a href="/fully/del?id=${list.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
