package com.wt.model;

/**
 * Created by mrz on 16/7/8.
 */
public class Port {
    private int id;
    private String portName;
    private int orders;

    public int getId() {
        return id;
    }
    public void setId(int portId)
    {
        this.id = portId;
    }

    public String getPortName(){
        return  portName;
    }
    public void setPortName(String portName){
        this.portName = portName;
    }

    public int getOrders(){return  orders;}
    public void  setOrders(int orders){this.orders = orders;}
}
