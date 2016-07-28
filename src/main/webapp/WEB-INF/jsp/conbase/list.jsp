<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/14
  Time: 下午5:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>合同列表</title>
</head>
<body>
<table>
    <tr>
     <th>id</th>
     <th>合同号 </th>
     <th>合同签订时间 </th>
     <th>是否是进口 </th>
     <th>是否审核通过 </th>
     <th>使用单位 </th>
     <th>供货商 </th>
     <th>中标通知书编码 </th>
     <th>合同金额 </th>
     <th>折美元金额 </th>
     <th>折人民币金额 </th>
     <th>LC编号 </th>
     <th>LC开出期限 </th>
     <th>LC开出行 </th>
     <th>lc开证金额 </th>
     <th>LC开出时间 </th>
     <th>lc改证时间 </th>
     <th>LC改证原因 </th>
     <th>交货日期 </th>
     <th>合同来源 </th>
    </tr>
<c:forEach var="con" items="${list}">
    <tr>
      <td><a href="/conbase/edit?id=${con.id}">${con.id}</a></td>
      <td>${con.conSN}</td>
      <td>${con.conDate}</td>
      <td>${con.isInport}</td>
      <td>${con.conVerify}</td>
      <td>${con.useORG}</td>
      <td>${con.supplier}</td>
      <td>${con.biddingSN}</td>
      <td>${con.conPrice}</td>
      <td>${con.atDoller}</td>
      <td>${con.atRMB}</td>
      <td>${con.lcSN}</td>
      <td>${con.lcTimeLimit}</td>
      <td>${con.lcFrom}</td>
      <td>${con.lcPrice}</td>
      <td>${con.lcStartDate}</td>
      <td>${con.lcChangeDate}</td>
      <td>${con.lcChangeReason}</td>
      <td>${con.deliveryDate}</td>
      <td>${con.conFrom}</td>
        <td><a href="/conbase/del?id=${con.id}">删除</a></td>
        <td><a href="/conbase/verify?id=${con.id}">审核</a></td>
    </tr>
</c:forEach>
</table>

</body>
</html>
