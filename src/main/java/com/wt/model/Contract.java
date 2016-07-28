package com.wt.model;

import java.math.BigDecimal;
import java.sql.Date;


/**
 * Created by mrz on 16/7/13.
 */
public class Contract {
    private int         id;
    private String      conSN;          //合同号
    private String        conDate;        //合同签订时间
    private Boolean     isInport;       //是否是进口
    private Boolean     conVerify;      //是否审核通过
    private String      useORG;         //使用单位
    private String      supplier;        //供货商
    private String      biddingSN;      //中标通知书编码
    private BigDecimal  conPrice;       //合同金额
    private BigDecimal  atDoller;       //折美元金额
    private BigDecimal  atRMB;          //折人民币金额
    private String      lcSN;           //LC编号
    private String        lcTimeLimit;    //LC开出期限
    private String      lcFrom;         //LC开出行
    private BigDecimal  lcPrice;        //lc开证金额
    private String        lcStartDate;    //LC开出时间
    private String        lcChangeDate;   //lc改证时间
    private String      lcChangeReason; //LC改证原因
    private String        deliveryDate;   //交货日期
    private String      conFrom;        //合同来源

    public int getId(){ return id;}
    public void setId(int id){this.id = id;}

    public String getConSN(){return conSN;}
    public void setConSN(String conSN){this.conSN = conSN;}

    public String getConDate(){return conDate;}
    public void  setConDate(String conDate){this.conDate = conDate;}

    public Boolean getIsInport(){return isInport;}
    public void  setIsInport(Boolean isInport){this.isInport =  isInport;}

    public Boolean getConVerify(){return conVerify;}
    public void setConVerify(Boolean conVerify){this.conVerify = conVerify;}

    public String getUseORG(){return useORG;}
    public void  setUseORG(String useORG){this.useORG= useORG;}

    public String getSupplier(){return supplier;}
    public void setSupplier(String suppier){this.supplier = suppier;}

    public String getBiddingSN(){return  biddingSN;}
    public void  setBiddingSN(String biddingSN){this.biddingSN =biddingSN;}

    public BigDecimal getConPrice(){return  conPrice;}
    public void  setConPrice(BigDecimal conPrice){this.conPrice = conPrice;}

    public BigDecimal getAtDoller(){return atDoller;}
    public void  setAtDoller(BigDecimal atDoller){this.atDoller = atDoller;}

    public BigDecimal getAtRMB(){return  atRMB;}
    public void  setAtRMB(BigDecimal atRMB){this.atRMB = atRMB;}

    public String  getLcSN(){return  lcSN;}
    public void  setLcSN(String lcSN){this.lcSN = lcSN;}

    public String getLcTimeLimit(){return lcTimeLimit;}
    public void setLcTimeLimit(String lcTimeLimit){this.lcTimeLimit = lcTimeLimit;}

    public String getLcFrom (){return lcFrom;}
    public void  setLcFrom(String lcFrom){this.lcFrom = lcFrom;}

    public BigDecimal getLcPrice(){return lcPrice;}
    public void  setLcPrice(BigDecimal lcPrice){this.lcPrice = lcPrice;}

    public String getLcStartDate(){return lcStartDate;}
    public void setLcStartDate(String lcStartDate){this.lcStartDate = lcStartDate;}

    public String getLcChangeDate(){return  lcChangeDate;}
    public void setLcChangeDate(String lcChangeDate){this.lcChangeDate = lcChangeDate;}

    public String getLcChangeReason(){return lcChangeReason;}
    public void  setLcChangeReason(String lcChangeReason){this.lcChangeReason = lcChangeReason;}

    public String getDeliveryDate(){return  deliveryDate;}
    public void setDeliveryDate(String deliveryDate){this.deliveryDate = deliveryDate;}

    public String getConFrom(){return conFrom;}
    public void setConFrom(String conFrom){this.conFrom = conFrom;}

}
