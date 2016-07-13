<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/12
  Time: 下午2:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>海关列表</title>
</head>
<body>
<c:forEach var="port" items="${ports}" >
    <div>${port.portName}-${port.orders}<a href="/port/edit?id=${port.id}">编辑</a>
        <a href="/port/delete?id=${port.id}">删除</a></div>
</c:forEach>
</body>
</html>
