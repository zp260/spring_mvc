<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/1
  Time: 上午11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>编辑货物</title>
</head>
<body>
<form:form action="/goods/update" method="post" modelAttribute="goods">
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
        <tr>
            <td><form:hidden path="goodsId" value="${good.goodsId}" />${good.goodsId}</td>
            <td><form:input path="conSN" value="${good.conSN}" /></td>
            <td><form:input path="stageId" value="${good.stageId}" /></td>
            <td><form:input path="goodsName" value="${good.goodsName}" /></td>
            <td><form:input path="goodsPrice" value="${good.goodsPrice}" /></td>
            <td><form:input path="goodsModel" value="${good.goodsModel}" /></td>
            <td><form:input path="goodsCount" value="${good.goodsCount}" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改"></td>
        </tr>
    </table>
</form:form>

</body>
</html>
