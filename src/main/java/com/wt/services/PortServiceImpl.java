package com.wt.services;

import com.wt.dao.PortDao;
import com.wt.model.Port;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrz on 16/7/8.
 */
@Service
public class PortServiceImpl implements PortService{
    @Autowired
    PortDao portDao;

    @Override
    public void insertPort(Port port){
        portDao.insertPort(port);
    }

    @Override
    public void updatePort(Port port){
        portDao.updatePort(port);

    }

    @Override
    public void delPort(int id){
        portDao.delPort(id);
    }

    @Override
    public List<Port> getPortList(){
      return   portDao.getPortList();
    }

    @Override
    public Port  getPortById(int id){return  portDao.getPortById(id);}
}

