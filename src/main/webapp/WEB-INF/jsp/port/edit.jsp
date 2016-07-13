<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/12
  Time: 下午3:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/port/update" method="post" modelAttribute="port">
    <table>
        <tr>
            <th>ID</th>
            <th>海关名称</th>
        </tr>

        <tr>
            <td>${map.port.id}<form:hidden path="id" value="${map.port.id}"/></td>
            <td><form:input path="portName" value="${map.port.portName}" /></td>
            <td><form:input path="orders" value="${map.port.orders}" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="修改" /> </td>
        </tr>
    </table>

</form:form>

</body>
</html>
