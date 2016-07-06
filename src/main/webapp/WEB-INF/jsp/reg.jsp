<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/1
  Time: 下午5:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" action="/insert" modelAttribute="user">
    <table>
        <tr>
            <td>员工姓名 :</td>
            <td><form:input path="userName" /></td>
        </tr>
        <tr>
            <td>登陆名 :</td>
            <td><form:input path="loginName" /></td>
        </tr>
        <tr>
            <td>密码 :</td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td>权限 :</td>
            <td><form:select path="userPower" items="${map.powerList}" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="添加新员工" /></td>
        </tr>
        <tr>

            <td colspan="2"><a href="/userlist">用户列表</a></td>
        </tr>
    </table>
</form:form>

</body>
</html>
