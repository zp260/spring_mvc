package com.wt.services;

import com.wt.model.Port;

import java.util.List;

/**
 * Created by mrz on 16/7/8.
 */
public interface PortService {
    public void insertPort(Port port);
    public void updatePort(Port port);
    public void delPort(int id);
    public Port  getPortById(int id);
    public List<Port> getPortList();
}
