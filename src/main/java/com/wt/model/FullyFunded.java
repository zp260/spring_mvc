package com.wt.model;

import java.math.BigDecimal;

/**
 * Created by mrz on 16/8/4.
 * 资金到位
 */
public class FullyFunded {
   private int          id;
   private String       conSN;	            //合同号
   private String       askForReportSN;	    //申请报告编号
   private BigDecimal   askForMoney;	    //申请资金
   private String       askForDate;	        //申请日期
   private BigDecimal   receiveMoney;	    //资金到位金额
   private String       receiveMoneyDate;	//资金到位日期
   private Boolean      success;	        //申请成功

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

    public String getAskForReportSN() {
        return askForReportSN;
    }

    public void setAskForReportSN(String askForReportSN) {
        this.askForReportSN = askForReportSN;
    }

    public BigDecimal getAskForMoney() {
        return askForMoney;
    }

    public void setAskForMoney(BigDecimal askForMoney) {
        this.askForMoney = askForMoney;
    }

    public String getAskForDate() {
        return askForDate;
    }

    public void setAskForDate(String askForDate) {
        this.askForDate = askForDate;
    }

    public BigDecimal getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(BigDecimal receiveMoney) {
        this.receiveMoney = receiveMoney;
    }

    public String getReceiveMoneyDate() {
        return receiveMoneyDate;
    }

    public void setReceiveMoneyDate(String receiveMoneyDate) {
        this.receiveMoneyDate = receiveMoneyDate;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }
}
