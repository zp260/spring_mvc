<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/20
  Time: 下午5:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/stage/insert" method="post" modelAttribute="stage">
<ul>
    <li><label>合同号</label><form:input path="conSN"/></li>
    <li><label>批次号</label><form:input path="stageNum"/></li>
    <li><label>到矿时间</label><form:input path="goodsArriveCoalDate"/></li>
    <li><input type="submit" value="提交"></li>
</ul>
</form:form>
</body>
</html>
