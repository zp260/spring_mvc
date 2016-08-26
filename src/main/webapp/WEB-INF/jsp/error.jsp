<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/8/24
  Time: 上午9:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty opmsg}">
    <h2>
        ${opmsg}
    </h2>
</c:if>

</body>
</html>
