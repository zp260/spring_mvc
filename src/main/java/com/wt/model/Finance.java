package com.wt.model;

import java.math.BigDecimal;

/**
 * Created by mrz on 16/8/3.
 */
public class Finance {
    private int         id;
    private String      conSN;	            //合同号
    private int         stageId;	        //批次id
    private String      certificate;	    //凭证号
    private BigDecimal  receiveMoney;	    //申请资金到位金额
    private BigDecimal  paidMoney;	        //已付金额
    private BigDecimal  unpaidMoney;	    //未付金额
    private String paidMoneyDate;	    //付款日期


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

    public int getStageId() {
        return stageId;
    }

    public void setStageId(int stageId) {
        this.stageId = stageId;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public BigDecimal getReceiveMoney() {
        return receiveMoney;
    }

    public void setReceiveMoney(BigDecimal receiveMoney) {
        this.receiveMoney = receiveMoney;
    }

    public BigDecimal getPaidMoney() {
        return paidMoney;
    }

    public void setPaidMoney(BigDecimal paidMoney) {
        this.paidMoney = paidMoney;
    }

    public BigDecimal getUnpaidMoney() {
        return unpaidMoney;
    }

    public void setUnpaidMoney(BigDecimal unpaidMoney) {
        this.unpaidMoney = unpaidMoney;
    }

    public String getPaidMoneyDate() {
        return paidMoneyDate;
    }

    public void setPaidMoneyDate(String paidMoneyDate) {
        this.paidMoneyDate = paidMoneyDate;
    }


}
