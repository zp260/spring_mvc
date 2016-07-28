package com.wt.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by mrz on 16/7/20.
 */
public class Stage {
    private int id;
    private String conSN;                   //合同号
    private int stageNum;                   //批次号

    private String goodsArriveCoalDate;     //到矿时间
    private String goodsSendETime;          //（进出口）批次（货物）预计发货时间
    private String goodsSendATime;          //（进出口）批次（货物）实际发货时间
    private String goodsArriveETime;        //（进出口）批次（货物）预计到港时间
    private String goodsArriveATime;        //（进出口）批次   (货物)  实际到港时间

    private String ebDate;                  //（进出口）（交出或收到）电子单据日期    -------------------
    private String bankNoticeBillTime;      // 银行通知来单日期                    |                 ｜
    private String BillTime;                //（进出口）（交出或收到）银行单据日期    |     单据         ｜
    private String billToCustomsDate;       // 单据给大同海关日期                  --------------------

    private String cdSN;	                //（进出口）报关单号
    private String cdPdf;	                //（进出口）报关单电子版
    private String cdTime;	                //（进出口）报关申报日期
    private BigDecimal cdPrice; 	        //（进出口）报关金额
    private String portDate;	            //（进出口）日期
    private String Port;                    // 进出口）口岸

    private String getDocPdf;	            //提单
    private String invoicePdf;	            //发票
    private String coPdf;	                //原产地证
    private String boxDocPdf;	            //箱单

    private String taxDate;	                //（进出口）缴税日期
    private BigDecimal tariffs;	            //关税
    private String tariffsPdf;	            //关税电子版
    private BigDecimal vat;	                //增值税
    private String vatPdf;	                //增值税电子版
    private BigDecimal specialTariff;	    //特别关税
    private String specialTariffPdf;	    //特别关税电子版
    private BigDecimal paytax;	            //补税
    private BigDecimal lateFee;	            //滞报金

    private String InspectionSN;	        //报检编号
    private String inspectionPdf;	        //报检电子版
    private String InspectionTime;	        //（进出口）报检日期
    private String passTime;	            //（进出口）放行日期
    private String containerCheckTime;	    //集装箱检日期
    private BigDecimal inspectionCharges;	//商检费
    private BigDecimal fumigationCharges;	//熏蒸费
    private String openContainerTime;	    //开箱时间
    private String openContainerResoult;	//开箱结果

    private String fhApproveBillTime;	    //付汇审批单时间
    private String fhReason;	            //（收付）汇原因
    private BigDecimal fhPrice;	            //（收付）汇金额
    private String fhMoneySeed;	            //（收付）汇币种
    private BigDecimal fhMoneyExchange;	    //（收付）汇币种汇率
    private BigDecimal fhRMBprice;	        //（收付）汇金额折人民币金额
    private BigDecimal fhRMBexchange;	    //（收付）汇币种兑人民币汇率
    private BigDecimal fhDollarPrice;	    //（收付）汇金额折美元金额
    private BigDecimal fhDollarExchange;    //（收付）汇兑美元汇率
    private String bankFHtime;	            //银行（收付）汇日期
    private String getFHtime;	            //收汇方收汇日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConSN() {
        return conSN;
    }

    public void setConSN(String conSN) {
        this.conSN = conSN;
    }

    public int getStageNum() {
        return stageNum;
    }

    public void setStageNum(int stageNum) {
        this.stageNum = stageNum;
    }

    public String getGoodsArriveCoalDate() {
        return goodsArriveCoalDate;
    }

    public void setGoodsArriveCoalDate(String goodsArriveCoalDate) {
        this.goodsArriveCoalDate = goodsArriveCoalDate;
    }

    public String getGoodsSendETime() {
        return goodsSendETime;
    }

    public void setGoodsSendETime(String goodsSendETime) {
        this.goodsSendETime = goodsSendETime;
    }

    public String getGoodsSendATime() {
        return goodsSendATime;
    }

    public void setGoodsSendATime(String goodsSendATime) {
        this.goodsSendATime = goodsSendATime;
    }

    public String getGoodsArriveETime() {
        return goodsArriveETime;
    }

    public void setGoodsArriveETime(String goodsArriveETime) {
        this.goodsArriveETime = goodsArriveETime;
    }

    public String getGoodsArriveATime() {
        return goodsArriveATime;
    }

    public void setGoodsArriveATime(String goodsArriveATime) {
        this.goodsArriveATime = goodsArriveATime;
    }

    public String getEbDate() {
        return ebDate;
    }

    public void setEbDate(String ebDate) {
        this.ebDate = ebDate;
    }

    public String getBankNoticeBillTime() {
        return bankNoticeBillTime;
    }

    public void setBankNoticeBillTime(String bankNoticeBillTime) {
        this.bankNoticeBillTime = bankNoticeBillTime;
    }

    public String getBillTime() {
        return BillTime;
    }

    public void setBillTime(String billTime) {
        BillTime = billTime;
    }

    public String getBillToCustomsDate() {
        return billToCustomsDate;
    }

    public void setBillToCustomsDate(String billToCustomsDate) {
        this.billToCustomsDate = billToCustomsDate;
    }

    public String getCdSN() {
        return cdSN;
    }

    public void setCdSN(String cdSN) {
        this.cdSN = cdSN;
    }

    public String getCdPdf() {
        return cdPdf;
    }

    public void setCdPdf(String cdPdf) {
        this.cdPdf = cdPdf;
    }

    public String getCdTime() {
        return cdTime;
    }

    public void setCdTime(String cdTime) {
        this.cdTime = cdTime;
    }

    public BigDecimal getCdPrice() {
        return cdPrice;
    }

    public void setCdPrice(BigDecimal cdPrice) {
        this.cdPrice = cdPrice;
    }

    public String getPortDate() {
        return portDate;
    }

    public void setPortDate(String portDate) {
        this.portDate = portDate;
    }

    public String getPort() {
        return Port;
    }

    public void setPort(String port) {
        Port = port;
    }

    public String getGetDocPdf() {
        return getDocPdf;
    }

    public void setGetDocPdf(String getDocPdf) {
        this.getDocPdf = getDocPdf;
    }

    public String getInvoicePdf() {
        return invoicePdf;
    }

    public void setInvoicePdf(String invoicePdf) {
        this.invoicePdf = invoicePdf;
    }

    public String getCoPdf() {
        return coPdf;
    }

    public void setCoPdf(String coPdf) {
        this.coPdf = coPdf;
    }

    public String getBoxDocPdf() {
        return boxDocPdf;
    }

    public void setBoxDocPdf(String boxDocPdf) {
        this.boxDocPdf = boxDocPdf;
    }

    public String getTaxDate() {
        return taxDate;
    }

    public void setTaxDate(String taxDate) {
        this.taxDate = taxDate;
    }

    public BigDecimal getTariffs() {
        return tariffs;
    }

    public void setTariffs(BigDecimal tariffs) {
        this.tariffs = tariffs;
    }

    public String getTariffsPdf() {
        return tariffsPdf;
    }

    public void setTariffsPdf(String tariffsPdf) {
        this.tariffsPdf = tariffsPdf;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    public String getVatPdf() {
        return vatPdf;
    }

    public void setVatPdf(String vatPdf) {
        this.vatPdf = vatPdf;
    }

    public BigDecimal getSpecialTariff() {
        return specialTariff;
    }

    public void setSpecialTariff(BigDecimal specialTariff) {
        this.specialTariff = specialTariff;
    }

    public String getSpecialTariffPdf() {
        return specialTariffPdf;
    }

    public void setSpecialTariffPdf(String specialTariffPdf) {
        this.specialTariffPdf = specialTariffPdf;
    }

    public BigDecimal getPaytax() {
        return paytax;
    }

    public void setPaytax(BigDecimal paytax) {
        this.paytax = paytax;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    public String getInspectionSN() {
        return InspectionSN;
    }

    public void setInspectionSN(String inspectionSN) {
        InspectionSN = inspectionSN;
    }

    public String getInspectionPdf() {
        return inspectionPdf;
    }

    public void setInspectionPdf(String inspectionPdf) {
        this.inspectionPdf = inspectionPdf;
    }

    public String getInspectionTime() {
        return InspectionTime;
    }

    public void setInspectionTime(String inspectionTime) {
        InspectionTime = inspectionTime;
    }

    public String getPassTime() {
        return passTime;
    }

    public void setPassTime(String passTime) {
        this.passTime = passTime;
    }

    public String getContainerCheckTime() {
        return containerCheckTime;
    }

    public void setContainerCheckTime(String containerCheckTime) {
        this.containerCheckTime = containerCheckTime;
    }

    public BigDecimal getInspectionCharges() {
        return inspectionCharges;
    }

    public void setInspectionCharges(BigDecimal inspectionCharges) {
        this.inspectionCharges = inspectionCharges;
    }

    public BigDecimal getFumigationCharges() {
        return fumigationCharges;
    }

    public void setFumigationCharges(BigDecimal fumigationCharges) {
        this.fumigationCharges = fumigationCharges;
    }

    public String getOpenContainerTime() {
        return openContainerTime;
    }

    public void setOpenContainerTime(String openContainerTime) {
        this.openContainerTime = openContainerTime;
    }

    public String getOpenContainerResoult() {
        return openContainerResoult;
    }

    public void setOpenContainerResoult(String openContainerResoult) {
        this.openContainerResoult = openContainerResoult;
    }

    public String getFhApproveBillTime() {
        return fhApproveBillTime;
    }

    public void setFhApproveBillTime(String fhApproveBillTime) {
        this.fhApproveBillTime = fhApproveBillTime;
    }

    public String getFhReason() {
        return fhReason;
    }

    public void setFhReason(String fhReason) {
        this.fhReason = fhReason;
    }

    public BigDecimal getFhPrice() {
        return fhPrice;
    }

    public void setFhPrice(BigDecimal fhPrice) {
        this.fhPrice = fhPrice;
    }

    public String getFhMoneySeed() {
        return fhMoneySeed;
    }

    public void setFhMoneySeed(String fhMoneySeed) {
        this.fhMoneySeed = fhMoneySeed;
    }

    public BigDecimal getFhMoneyExchange() {
        return fhMoneyExchange;
    }

    public void setFhMoneyExchange(BigDecimal fhMoneyExchange) {
        this.fhMoneyExchange = fhMoneyExchange;
    }

    public BigDecimal getFhRMBprice() {
        return fhRMBprice;
    }

    public void setFhRMBprice(BigDecimal fhRMBprice) {
        this.fhRMBprice = fhRMBprice;
    }

    public BigDecimal getFhRMBexchange() {
        return fhRMBexchange;
    }

    public void setFhRMBexchange(BigDecimal fhRMBexchange) {
        this.fhRMBexchange = fhRMBexchange;
    }

    public BigDecimal getFhDollarPrice() {
        return fhDollarPrice;
    }

    public void setFhDollarPrice(BigDecimal fhDollarPrice) {
        this.fhDollarPrice = fhDollarPrice;
    }

    public BigDecimal getFhDollarExchange() {
        return fhDollarExchange;
    }

    public void setFhDollarExchange(BigDecimal fhDollarExchange) {
        this.fhDollarExchange = fhDollarExchange;
    }

    public String getBankFHtime() {
        return bankFHtime;
    }

    public void setBankFHtime(String bankFHtime) {
        this.bankFHtime = bankFHtime;
    }

    public String getGetFHtime() {
        return getFHtime;
    }

    public void setGetFHtime(String getFHtime) {
        this.getFHtime = getFHtime;
    }
}
