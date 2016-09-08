package com.wt.model;

import java.math.BigDecimal;

/**
 * Created by mrz on 16/8/1.
 */
public class Goods {
  private int           goodsId;      //货物ID
  private String        conSN;        //所属合同号
  private Integer       stageNum;      //所属批次id
  private String        goodsName;    //货物名称
  private BigDecimal    goodsPrice;   //货物金额
  private String        goodsModel;   //规格型号
  private int           goodsCount;   //货物数量

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

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }
}
