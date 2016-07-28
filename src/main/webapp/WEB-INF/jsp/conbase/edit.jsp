<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/14
  Time: 下午5:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html>
<head>
    <title>合同资料修改</title>
</head>
<body>
<form:form action="/conbase/update" method="post" modelAttribute="contract">
    <table>
        <tr>
            <th>id</th>
            <th>合同号</th>
            <th>合同签订时间</th>
            <th>是否是进口</th>
            <th>是否审核通过</th>
            <th>使用单位</th>
            <th>供货商</th>
            <th>中标通知书编码</th>
            <th>合同金额</th>
            <th>折美元金额</th>
            <th>折人民币金额</th>
            <th>LC编号</th>
            <th>LC开出期限</th>
            <th>LC开出行</th>
            <th>lc开证金额</th>
            <th>LC开出时间</th>
            <th>lc改证时间</th>
            <th>LC改证原因</th>
            <th>交货日期</th>
            <th>合同来源</th>
        </tr>
        <tr>
            <td><form:hidden path="id" value="${map.contract.id}"/>${map.contract.id}</td>
            <td><form:input path="conSN" value="${map.contract.conSN}"/></td>
            <td><form:input path="conDate" value="${map.contract.conDate}"/></td>
            <td><form:select path="isInport" items="${map.inport}"/></td>
            <td><form:input path="conVerify" value="${map.contract.conVerify}"/></td>
            <td><form:input path="useORG" value="${map.contract.useORG}"/></td>
            <td><form:input path="supplier" value="${map.contract.supplier}"/></td>
            <td><form:input path="biddingSN" value="${map.contract.biddingSN}"/></td>
            <td><form:input path="conPrice" value="${map.contract.conPrice}"/></td>
            <td><form:input path="atDoller" value="${map.contract.atDoller}"/></td>
            <td><form:input path="atRMB" value="${map.contract.atRMB}"/></td>
            <td><form:input path="lcSN" value="${map.contract.lcSN}"/></td>
            <td><form:input path="lcTimeLimit" value="${map.contract.lcTimeLimit}"/></td>
            <td><form:input path="lcFrom" value="${map.contract.lcFrom}"/></td>
            <td><form:input path="lcPrice" value="${map.contract.lcPrice}"/></td>
            <td><form:input path="lcStartDate" value="${map.contract.lcStartDate}"/></td>
            <td><form:input path="lcChangeDate" value="${map.contract.lcChangeDate}"/></td>
            <td><form:input path="lcChangeReason" value="${map.contract.lcChangeReason}"/></td>
            <td><form:input path="deliveryDate" value="${map.contract.deliveryDate}"/></td>
            <td><form:input path="conFrom" value="${map.contract.conFrom}"/></td>
        </tr>
        <tr>
            <td> <td><input type="submit" value="修改"/></td></td>
        </tr>
    </table>
</form:form>
</body>
</html>
