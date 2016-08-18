<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/8
  Time: 上午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
<body onload='document.loginForm.loginName.focus();'>

<h1>用户登陆</h1>

<div id="login-box">

    <form:form name='loginForm' action="/logincheck" method='POST' modelAttribute="user">

        <c:if test="${not empty error}">
            <H1>${error}</H1>
        </c:if>
        <table>
            <tr>
                <td>登陆名:</td>
                <td><input type='text' name='loginName'></td>
            </tr>
            <tr>
                <td>密码:</td>
                <td><input type='password' name='passWord' /></td>
            </tr>

            <tr>
                <td colspan='2'><input name="submit" type="submit" value="登陆" /></td>
            </tr>

        </table>

    </form:form>

</div>

</body>
</body>
</html>
