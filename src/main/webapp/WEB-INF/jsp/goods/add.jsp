<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/1
  Time: 上午11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/goods/insert" method="post" modelAttribute="goods">
    <ul>
        <li><label>所属合同号</label><form:input path="conSN"/></li>
        <li><label>所属批次id</label><form:input path="stageId"/></li>
        <li><label>货物名称</label><form:input path="goodsname"/></li>
        <li><label>货物金额</label><form:input path="goodsPrice"/></li>
        <li><label>规格型号</label><form:input path="goodsModel"/></li>
        <li><label>货物数量</label><form:input path="goodsCount"/></li>
        <li><input type="submit" value="添加"></li>
    </ul>
</form:form>

</body>
</html>
