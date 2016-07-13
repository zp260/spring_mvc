<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/8
  Time: 上午9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆界面</title>
</head>
<body>
<body onload='document.loginForm.loginName.focus();'>

<h1>Spring Security Password Encoder</h1>

<div id="login-box">

    <h3>Login with Username and Password</h3>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>

    <form name='loginForm'
          action="<c:url value='/auth/login_check?targetUrl=${targetUrl}' />"
          method='POST'>

        <table>
            <tr>
                <td>User:</td>
                <td><input type='text' name='loginName'></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type='password' name='password' /></td>
            </tr>

            <tr>
                <td colspan='2'><input name="submit" type="submit"
                                       value="submit" /></td>
            </tr>

        </table>

        <input type="hidden" name="${_csrf.parameterName}"
               value="${_csrf.token}" />

    </form>

</div>

</body>
</body>
</html>
