<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/3
  Time: 上午10:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form:form method="post" action="/currency/update" modelAttribute="currency">
    <table>
        <tr>
            <th>id</th>
            <th>货币名称</th>
        </tr>
        <tr>
            <td><form:hidden path="id" value="${currency.id}" />${currency.id}</td>
            <td><form:input path="moneyName" value="${currency.moneyName}"/></td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="修改">
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
