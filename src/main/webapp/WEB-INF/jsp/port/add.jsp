<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/8
  Time: 下午5:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>增加港口</title>
</head>
<body>
 <form:form action="/port/insert"  method="post" modelAttribute="port">
     <table>
         <tr>
             <th>排序</th>
             <th>港口名称</th>
         </tr>
         <tr>
             <td><form:input path="orders" /></td>
             <td><form:input path="portName" /></td>
         </tr>
     </table>


     <input type="submit" value="增加">
 </form:form>
</body>
</html>
