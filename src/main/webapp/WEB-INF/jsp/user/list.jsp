<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/4
  Time: 上午9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
<a href="/user/add">添加用户</a>
 <table>
     <tr>
         <th>ID</th>
         <th>员工姓名</th>
         <th>登录名</th>
         <th>登陆密码</th>
         <th>用户权限</th>
     </tr>
    <c:forEach var="user" items="${userlist}">
     <tr>
         <td>${user.id}</td>
         <td>${user.userName}</td>
         <td>${user.loginName}</td>
         <td>${user.passWord}</td>
         <td>${user.userPower}</td>
         <td>
             <a href="/user/edit?id=${user.id}">编辑</a>
         </td>
         <td> <a href="/user/delete?id=${user.id}">删除</a></td>
     </tr>
    </c:forEach>
 </table>
</body>
</html>
