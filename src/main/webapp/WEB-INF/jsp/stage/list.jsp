<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/20
  Time: 下午4:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
      <th>id</th>
      <th>合同号</th>
      <th>批次号</th>
      <th>到矿时间</th>
      <th>（进出口）批次（货物）预计发货时间</th>
      <th>（进出口）批次（货物）实际发货时间</th>
      <th>（进出口）批次（货物）预计到港时间</th>
      <th>（进出口）批次   (货物)  实际到港时</th>
      <th>（进出口）（交出或收到）电子单据日期</th>
      <th>银行通知来单日期</th>
      <th>（进出口）（交出或收到）银行单据日期</th>
      <th>单据给大同海关日期</th>
      <th>（进出口）报关单号</th>
      <th>（进出口）报关单电子版</th>
      <th>（进出口）报关申报日期</th>
      <th>（进出口）报关金额</th>
      <th>（进出口）日期</th>
      <th>进出口）口岸</th>
      <th>提单</th>
      <th>发票</th>
      <th>原产地证</th>
      <th>箱单</th>
      <th>（进出口）缴税日期</th>
      <th>关税</th>
      <th>关税电子版</th>
      <th>增值税</th>
      <th>增值税电子版</th>
      <th>特别关税</th>
      <th>特别关税电子版</th>
      <th>补税</th>
      <th>滞报金</th>
      <th>报检编号</th>
      <th>报检电子版</th>
      <th>（进出口）报检日期</th>
      <th>（进出口）放行日期</th>
      <th>集装箱检日期</th>
      <th>商检费</th>
      <th>熏蒸费</th>
      <th>开箱时间</th>
      <th>开箱结果</th>
      <th>付汇审批单时间</th>
      <th>（收付）汇原因</th>
      <th>（收付）汇金额</th>
      <th>（收付）汇币种</th>
      <th>（收付）汇币种汇率</th>
      <th>（收付）汇金额折人民币金额</th>
      <th>（收付）汇币种兑人民币汇率</th>
      <th>（收付）汇金额折美元金额</th>
      <th>（收付）汇兑美元汇率</th>
      <th>银行（收付）汇日期</th>
      <th>收汇方收汇日期</th>
    </tr>
    <c:forEach var="list" items="${list}">
        <tr>
          <td><a href="/stage/edit?id=${list.id}">${list.id}</a></td>
          <td>${list.conSN}</td>
          <td>${list.stageNum}</td>
          <td>${list.goodsArriveCoalDate}</td>
          <td>${list.goodsSendETime}</td>
          <td>${list.goodsSendATime}</td>
          <td>${list.goodsArriveETime}</td>
          <td>${list.goodsArriveATime}</td>
          <td>${list.ebDate}</td>
          <td>${list.bankNoticeBillTime}</td>
          <td>${list.billTime}</td>
          <td>${list.billToCustomsDate}</td>
          <td>${list.cdSN}</td>
          <td>${list.cdPdf}</td>
          <td>${list.cdTime}</td>
          <td>${list.cdPrice}</td>
          <td>${list.portDate}</td>
          <td>${list.port}</td>
          <td>${list.getDocPdf}</td>
          <td>${list.invoicePdf}</td>
          <td>${list.coPdf}</td>
          <td>${list.boxDocPdf}</td>
          <td>${list.taxDate}</td>
          <td>${list.tariffs}</td>
          <td>${list.tariffsPdf}</td>
          <td>${list.vat}</td>
          <td>${list.vatPdf}</td>
          <td>${list.specialTariff}</td>
          <td>${list.specialTariffPdf}</td>
          <td>${list.paytax}</td>
          <td>${list.lateFee}</td>
          <td>${list.inspectionSN}</td>
          <td>${list.inspectionPdf}</td>
          <td>${list.inspectionTime}</td>
          <td>${list.passTime}</td>
          <td>${list.containerCheckTime}</td>
          <td>${list.inspectionCharges}</td>
          <td>${list.fumigationCharges}</td>
          <td>${list.openContainerTime}</td>
          <td>${list.openContainerResoult}</td>
          <td>${list.fhApproveBillTime}</td>
          <td>${list.fhReason}</td>
          <td>${list.fhPrice}</td>
          <td>${list.fhMoneySeed}</td>
          <td>${list.fhMoneyExchange}</td>
          <td>${list.fhRMBprice}</td>
          <td>${list.fhRMBexchange}</td>
          <td>${list.fhDollarPrice}</td>
          <td>${list.fhDollarExchange}</td>
          <td>${list.bankFHtime}</td>
          <td>${list.getFHtime}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
