package com.wt.model;

import java.sql.Date;

/**
 * Created by mrz on 16/7/20.
 */
public class Stage {
    private int id;
    private String conSN;
    private int stageNum;
    private Date goodsArriveCoalDate;

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getConSN(){return conSN;}
    public void  setConSN(String conSN){this.conSN = conSN;}

    public int getStageNum(){return stageNum;}
    public void setStageNum(int stageNum){this.stageNum = stageNum;}

    public Date getGoodsArriveCoalDate(){return goodsArriveCoalDate;}
    public void setGoodsArriveCoalDate(Date goodsArriveCoalDate){this.goodsArriveCoalDate = goodsArriveCoalDate;}
}
