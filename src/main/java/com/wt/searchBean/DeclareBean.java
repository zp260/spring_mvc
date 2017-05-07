package com.wt.searchBean;

import java.math.BigDecimal;

/**
 * Created by mrz on 16/9/14.
 * 报关查询BEAN
 */
public class DeclareBean {
    private int id;
    private String cdTime;
    private String conSN;
    private String cdSN;
    private BigDecimal cdPrice;
    private Integer stageNum;
    private String useORG;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCdTime() {
        return cdTime;
    }

    public void setCdTime(String cdTime) {
        this.cdTime = cdTime;
    }

    public String getConSN() {
        return conSN;
    }

    public void setConSN(String conSN) {
        this.conSN = conSN;
    }

    public String getCdSN() {
        return cdSN;
    }

    public void setCdSN(String cdSN) {
        this.cdSN = cdSN;
    }

    public BigDecimal getCdPrice() {
        return cdPrice;
    }

    public void setCdPrice(BigDecimal cdPrice) {
        this.cdPrice = cdPrice;
    }

    public Integer getStageNum() {
        return stageNum;
    }

    public void setStageNum(Integer stageNum) {
        this.stageNum = stageNum;
    }

    public String getUseORG() {
        return useORG;
    }

    public void setUseORG(String useORG) {
        this.useORG = useORG;
    }
}
