<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/20
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>合同号</th>
        <th>批次</th>
        <th>到矿时间</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td><a href="/stage/edit?id=${list.id}">${list.id}</a> </td>
            <td>${list.conSN}</td>
            <td>${list.stageNum}</td>
            <td>${list.goodsArriveCoalDate}</td>

        </tr>
    </c:forEach>
</table>

</body>
</html>
