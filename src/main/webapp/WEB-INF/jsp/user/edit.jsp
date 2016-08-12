<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/4
  Time: 下午4:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户编辑</title>
</head>
<body>
 <form:form method="post" action="/user/update" modelAttribute="user">
     <table>
         <tr>
             <th>ID</th>
             <th>员工姓名</th>
             <th>登录名</th>
             <th>登陆密码</th>
             <th>用户权限</th>
         </tr>
         <tr>
             <td>
                  ${map.user.id}<form:hidden path="id" value="${map.user.id}" />
             </td>
             <td>
                <form:input path="userName" value="${map.user.userName}"/>
             </td>
             <td>
                 <form:input path="loginName" value="${map.user.loginName}"/>
             </td>
             <td>
                 <form:input path="password" value="${map.user.password}"/>
             </td>
             <td>
                 <spring:bind path="userPower">
                     <select name="userPower">
                     <c:forEach items="${map.powerList}" var="power">
                         <c:choose>
                             <c:when test="${power eq map.user.userPower}">
                                 <option value="${power}" selected="true">${power}</option>
                             </c:when>
                             <c:otherwise>
                                <option value="${power}">${power}</option>
                             </c:otherwise>
                         </c:choose>
                     </c:forEach>
                     </select>
                 </spring:bind>
             </td>
             <td>
                 <input type="submit" value="修改">
             </td>
         </tr>
     </table>
 </form:form>
</body>
</html>
