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
    <title>增加币种</title>
</head>
<body>
<form:form action="/currency/insert" method="post" modelAttribute="currency">
    <ul>
        <li><label>币种</label><form:input path="moneyName" /></li>
        <li><input type="submit" value="提交"></li>
    </ul>
</form:form>

</body>
</html>
