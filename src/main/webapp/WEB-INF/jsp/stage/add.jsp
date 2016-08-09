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
        <li>
            <label>合同号</label>
            <form:input path="conSN"/></li>
        <li>
            <label>批次号</label>
            <form:input path="stageNum"/></li>
        <li>
            <label>到矿时间</label>
            <form:input path="goodsArriveCoalDate"/></li>
        <li>
            <label>（进出口）批次（货物）预计发货时间</label>
            <form:input path="goodsSendETime"/></li>
        <li>
            <label>（进出口）批次（货物）实际发货时间</label>
            <form:input path="goodsSendATime"/></li>
        <li>
            <label>（进出口）批次（货物）预计到港时间</label>
            <form:input path="goodsArriveETime"/></li>
        <li>
            <label>（进出口）批次 (货物) 实际到港时间</label>
            <form:input path="goodsArriveATime"/></li>
        <li>
            <label>（进出口）（交出或收到）电子单据日期</label>
            <form:input path="ebDate"/></li>
        <li>
            <label> 银行通知来单日期 </label>
            <form:input path="bankNoticeBillTime"/></li>
        <li>
            <label>（进出口）（交出或收到）银行单据日期</label>
            <form:input path="BillTime"/></li>
        <li>
            <label> 单据给大同海关日期</label>
            <form:input path="billToCustomsDate"/></li>
        <li>
            <label>（进出口）报关单号</label>
            <form:input path="cdSN"/></li>
        <li>
            <label>（进出口）报关单电子版</label>
            <form:input path="cdPdf"/>
        </li>
        <li>
            <label>（进出口）报关申报日期</label>
            <form:input path="cdTime"/></li>
        <li>
            <label>（进出口）报关金额</label>
            <form:input path="cdPrice"/></li>
        <li>
            <label>（进出口）日期</label>
            <form:input path="portDate"/></li>
        <li>
            <label> 进出口）口岸</label>
            <form:input path="Port"/></li>
        <li>
            <label>提单</label>
            <form:input path="getDocPdf"/></li>
        <li>
            <label>发票</label>
            <form:input path="invoicePdf"/></li>
        <li>
            <label>原产地证</label>
            <form:input path="coPdf"/></li>
        <li>
            <label>箱单</label>
            <form:input path="boxDocPdf"/></li>
        <li>
            <label>（进出口）缴税日期</label>
            <form:input path="taxDate"/></li>
        <li>
            <label>关税</label>
            <form:input path="tariffs"/></li>
        <li>
            <label>关税电子版</label>
            <form:input path="tariffsPdf"/></li>
        <li>
            <label>增值税</label>
            <form:input path="vat"/></li>
        <li>
            <label>增值税电子版</label>
            <form:input path="vatPdf"/></li>
        <li>
            <label>特别关税</label>
            <form:input path="specialTariff"/></li>
        <li>
            <label>特别关税电子版</label>
            <form:input path="specialTariffPdf"/></li>
        <li>
            <label>补税</label>
            <form:input path="paytax"/></li>
        <li>
            <label>滞报金</label>
            <form:input path="lateFee"/></li>
        <li>
            <label>报检编号</label>
            <form:input path="InspectionSN"/></li>
        <li>
            <label>报检电子版</label>
            <form:input path="inspectionPdf"/></li>
        <li>
            <label>（进出口）报检日期</label>
            <form:input path="InspectionTime"/></li>
        <li>
            <label>（进出口）放行日期</label>
            <form:input path="passTime"/></li>
        <li>
            <label>集装箱检日期</label>
            <form:input path="containerCheckTime"/></li>
        <li>
            <label>商检费</label>
            <form:input path="inspectionCharges"/></li>
        <li>
            <label>熏蒸费</label>
            <form:input path="fumigationCharges"/></li>
        <li>
            <label>开箱时间</label>
            <form:input path="openContainerTime"/></li>
        <li>
            <label>开箱结果</label>
            <form:input path="openContainerResoult"/></li>
        <li>
            <label>付汇审批单时间</label>
            <form:input path="fhApproveBillTime"/></li>
        <li>
            <label>（收付）汇原因</label>
            <form:input path="fhReason"/></li>
        <li>
            <label>（收付）汇金额</label>
            <form:input path="fhPrice"/></li>
        <li>
            <label>（收付）汇币种</label>
            <form:input path="fhMoneySeed"/></li>
        <li>
            <label>（收付）汇币种汇率</label>
            <form:input path="fhMoneyExchange"/></li>
        <li>
            <label>（收付）汇金额折人民币金额</label>
            <form:input path="fhRMBprice"/></li>
        <li>
            <label>（收付）汇币种兑人民币汇率</label>
            <form:input path="fhRMBexchange"/></li>
        <li>
            <label>（收付）汇金额折美元金额</label>
            <form:input path="fhDollarPrice"/></li>
        <li>
            <label>（收付）汇兑美元汇率</label>
            <form:input path="fhDollarExchange"/></li>
        <li>
            <label>银行（收付）汇日期</label>
            <form:input path="bankFHtime"/></li>
        <li>
            <label>收汇方收汇日期</label>
            <form:input path="getFHtime"/></li>


        <li><input type="submit" value="提交"></li>
    </ul>
</form:form>

</body>
</html>
