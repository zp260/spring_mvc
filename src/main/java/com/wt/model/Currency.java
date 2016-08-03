package com.wt.model;

/**
 * Created by mrz on 16/8/3.
 */
public class Currency {
    private int id;
    private String moneyName;  //货币名称

    public void setMoneyName(String moneyName){this.moneyName = moneyName;}
    public String getMoneyName(){return moneyName;}

    public void setId(int id){this.id = id;}
    public int getId(){return id;}
}
