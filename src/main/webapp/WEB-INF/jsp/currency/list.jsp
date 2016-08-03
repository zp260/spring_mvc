<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/3
  Time: 上午10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表</title>
</head>
<body>
<table>
    <tr>
        <th>id</th>
        <th>货币名称</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td><a href="/currency/edit?id=${list.id}">${list.id}</a> </td>
            <td>${list.moneyName}</td>
            <td><a href="/currency/del?id=${list.id}">删除</a> </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
