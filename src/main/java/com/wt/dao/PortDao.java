package com.wt.dao;

import com.wt.model.Port;

import java.util.List;

/**
 * Created by mrz on 16/7/8.
 */
public interface PortDao {
    public void insertPort(Port port);
    public void updatePort(Port port);
    public void delPort(int id);
    public List<Port> getPortList();
    public Port  getPortById(int id);
}
