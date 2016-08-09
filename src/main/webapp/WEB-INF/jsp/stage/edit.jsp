<%--
  Created by IntelliJ IDEA.
  User: mrz
  Date: 16/7/25
  Time: 上午10:22
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
</head>
<body>
<form:form action="/stage/update" method="post" modelAttribute="stage">
    <table>
        <tr>
           <th>id</th>
           <th>合同号</th>
           <th>批次号</th>
           <th>到矿时间</th>
           <th>（进出口）批次（货物）预计发货时间</th>
           <th>（进出口）批次（货物）实际发货时间</th>
           <th>（进出口）批次（货物）预计到港时间</th>
           <th>（进出口）批次   (货物)  实际到港时间</th>
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
        <tr>

            <td><form:input path="id" value="${stage.id}" /></td>
            <td><form:input path="conSN" value="${stage.conSN}" /></td>
            <td><form:input path="stageNum" value="${stage.stageNum}" /></td>
            <td><form:input path="goodsArriveCoalDate" value="${stage.goodsArriveCoalDate}" /></td>
            <td><form:input path="goodsSendETime" value="${stage.goodsSendETime}" /></td>
            <td><form:input path="goodsSendATime" value="${stage.goodsSendATime}" /></td>
            <td><form:input path="goodsArriveETime" value="${stage.goodsArriveETime}" /></td>
            <td><form:input path="goodsArriveATime" value="${stage.goodsArriveATime}" /></td>
            <td><form:input path="ebDate" value="${stage.ebDate}" /></td>
            <td><form:input path="bankNoticeBillTime" value="${stage.bankNoticeBillTime}" /></td>
            <td><form:input path="billTime" value="${stage.billTime}" /></td>
            <td><form:input path="billToCustomsDate" value="${stage.billToCustomsDate}" /></td>
            <td><form:input path="cdSN" value="${stage.cdSN}" /></td>
            <td><form:input path="cdPdf" value="${stage.cdPdf}" /></td>
            <td><form:input path="cdTime" value="${stage.cdTime}" /></td>
            <td><form:input path="cdPrice" value="${stage.cdPrice}" /></td>
            <td><form:input path="portDate" value="${stage.portDate}" /></td>
            <td><form:input path="port" value="${stage.port}" /></td>
            <td><form:input path="getDocPdf" value="${stage.getDocPdf}" /></td>
            <td><form:input path="invoicePdf" value="${stage.invoicePdf}" /></td>
            <td><form:input path="coPdf" value="${stage.coPdf}" /></td>
            <td><form:input path="boxDocPdf" value="${stage.boxDocPdf}" /></td>
            <td><form:input path="taxDate" value="${stage.taxDate}" /></td>
            <td><form:input path="tariffs" value="${stage.tariffs}" /></td>
            <td><form:input path="tariffsPdf" value="${stage.tariffsPdf}" /></td>
            <td><form:input path="vat" value="${stage.vat}" /></td>
            <td><form:input path="vatPdf" value="${stage.vatPdf}" /></td>
            <td><form:input path="specialTariff" value="${stage.specialTariff}" /></td>
            <td><form:input path="specialTariffPdf" value="${stage.specialTariffPdf}" /></td>
            <td><form:input path="paytax" value="${stage.paytax}" /></td>
            <td><form:input path="lateFee" value="${stage.lateFee}" /></td>
            <td><form:input path="inspectionSN" value="${stage.inspectionSN}" /></td>
            <td><form:input path="inspectionPdf" value="${stage.inspectionPdf}" /></td>
            <td><form:input path="inspectionTime" value="${stage.inspectionTime}" /></td>
            <td><form:input path="passTime" value="${stage.passTime}" /></td>
            <td><form:input path="containerCheckTime" value="${stage.containerCheckTime}" /></td>
            <td><form:input path="inspectionCharges" value="${stage.inspectionCharges}" /></td>
            <td><form:input path="fumigationCharges" value="${stage.fumigationCharges}" /></td>
            <td><form:input path="openContainerTime" value="${stage.openContainerTime}" /></td>
            <td><form:input path="openContainerResoult" value="${stage.openContainerResoult}" /></td>
            <td><form:input path="fhApproveBillTime" value="${stage.fhApproveBillTime}" /></td>
            <td><form:input path="fhReason" value="${stage.fhReason}" /></td>
            <td><form:input path="fhPrice" value="${stage.fhPrice}" /></td>
            <td><form:input path="fhMoneySeed" value="${stage.fhMoneySeed}" /></td>
            <td><form:input path="fhMoneyExchange" value="${stage.fhMoneyExchange}" /></td>
            <td><form:input path="fhRMBprice" value="${stage.fhRMBprice}" /></td>
            <td><form:input path="fhRMBexchange" value="${stage.fhRMBexchange}" /></td>
            <td><form:input path="fhDollarPrice" value="${stage.fhDollarPrice}" /></td>
            <td><form:input path="fhDollarExchange" value="${stage.fhDollarExchange}" /></td>
            <td><form:input path="bankFHtime" value="${stage.bankFHtime}" /></td>
            <td><form:input path="getFHtime" value="${stage.getFHtime}" /></td>

        </tr>
        <tr>
            <TD><input type="submit" value="修改"> </TD>
        </tr>
    </table>
</form:form>

</body>
</html>
