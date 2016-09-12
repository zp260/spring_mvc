package com.wt.searchBean;

import java.math.BigDecimal;

/**货物搜索返回的BEAN
 * Created by mrz on 16/9/12.
 */
public class GoodAndCon {
    private int           goodsId;              //货物ID
    private String        conSN;                //所属合同号
    private Integer       stageNum;             //所属批次id
    private String        goodsName;            //货物名称
    private BigDecimal    goodsPrice;           //货物金额
    private String        goodsModel;           //规格型号
    private Integer       goodsCount;           //货物数量
    private String        useORG;               //使用单位
    private String        supplier;             //供货商
    private String        goodsArriveCoalDate;  //具体到矿时间（年-月-日）

    public String getGoodsArriveCoalDate() {
        return goodsArriveCoalDate;
    }

    public void setGoodsArriveCoalDate(String goodsArriveCoalDate) {
        this.goodsArriveCoalDate = goodsArriveCoalDate;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getConSN() {
        return conSN;
    }

    public void setConSN(String conSN) {
        this.conSN = conSN;
    }

    public Integer getStageNum() {
        return stageNum;
    }

    public void setStageNum(Integer stageNum) {
        this.stageNum = stageNum;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsModel() {
        return goodsModel;
    }

    public void setGoodsModel(String goodsModel) {
        this.goodsModel = goodsModel;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getUseORG() {
        return useORG;
    }

    public void setUseORG(String useORG) {
        this.useORG = useORG;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }


}