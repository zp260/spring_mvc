<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/1
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>货物ID</th>
        <th>所属合同号</th>
        <th>所属批次id</th>
        <th>货物名称</th>
        <th>货物金额</th>
        <th>规格型号</th>
        <th>货物数量</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
            <td><a href="/goods/editByid?id=${list.goodsId}">${list.goodsId}</a> </td>
            <td>${list.conSN}</td>
            <td>${list.stageId}</td>
            <td><a href="/goods/editByName?goodname=${list.goodsName}">${list.goodsName}</a> </td>
            <td>${list.goodsPrice}</td>
            <td>${list.goodsModel}</td>
            <td>${list.goodsCount}</td>
            <td><a href="/goods/del?id=${list.goodsId}">删除</a> </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
