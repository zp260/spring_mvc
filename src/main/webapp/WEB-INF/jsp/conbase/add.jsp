<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/14
  Time: 下午5:42
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/conbase/insert" method="post" modelAttribute="contract">

            <li>合同号         <form:input path="conSN"/></li>
            <li>合同签订时间  <form:input path="conDate"/></li>
            <li>是否是进口 <form:input path="isInport"/></li>
            <li>是否审核通过 <form:input path="conVerify"/></li>
            <li>使用单位 <form:input path="useORG"/></li>
            <li>供货商 <form:input path="supplier"/></li>
            <li>中标通知书编码 <form:input path="biddingSN"/></li>
            <li>合同金额 <form:input path="conPrice"/></li>
            <li>折美元金额 <form:input path="atDoller"/></li>
            <li>折人民币金额 <form:input path="atRMB"/></li>
            <li>LC编号 <form:input path="lcSN"/></li>
            <li>LC开出期限 <form:input path="lcTimeLimit"/></li>
            <li>LC开出行 <form:input path="lcFrom"/></li>
            <li>lc开证金额 <form:input path="lcPrice"/></li>
            <li>LC开出时间 <form:input path="lcStartDate"/></li>
            <li>lc改证时间 <form:input path="lcChangeDate"/></li>
            <li>LC改证原因 <form:input path="lcChangeReason"/></li>
            <li>交货日期 <form:input path="deliveryDate"/></li>
            <li>合同来源 <form:input path="conFrom"/></li>
            <li><input type="submit" value="提交"></li>

</form:form>

</body>
</html>
