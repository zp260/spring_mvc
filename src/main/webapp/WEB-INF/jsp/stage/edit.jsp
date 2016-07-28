<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/25
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<form:form action="/stage/update" method="post" modelAttribute="stage">
    <table>
        <tr>
            <th>id</th>
            <th>合同号</th>
            <th>批次号</th>
            <th>到矿时间</th>
        </tr>
        <tr>
            <td>${map.stage.id}<form:hidden path="id" value="${map.stage.id}"/></td>
            <td><form:input path="conSN" value="${map.stage.conSN}" /></td>
            <td><form:input path="stageNum" value="${map.stage.stageNum}" /></td>
            <td><form:input path="goodsArriveCoalDate" value="${map.stage.goodsArriveCoalDate}" /></td>
        </tr>
        <tr>
            <TD><input type="submit" value="修改"> </TD></tr>
    </table>
</form:form>

</body>
</html>
