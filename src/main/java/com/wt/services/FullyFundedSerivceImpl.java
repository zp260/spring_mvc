package com.wt.services;

import com.wt.dao.FullyFundedDao;
import com.wt.model.FullyFunded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrz on 16/8/4.
 */
@Service
public class FullyFundedSerivceImpl implements FullyFundedService {
    @Autowired
    FullyFundedDao fullyFundedDao;

    @Override
    public void insert(FullyFunded fullyFunded){fullyFundedDao.insert(fullyFunded);}
    @Override
    public void delete(int id){fullyFundedDao.delete(id);}
    @Override
    public void update(FullyFunded fullyFunded){fullyFundedDao.update(fullyFunded);}
    @Override
    public List<FullyFunded> list(){return  fullyFundedDao.list();}
    @Override
    public List<FullyFunded> getFullyFundedByConSN(String conSn){return  fullyFundedDao.getFullyFundedByConSN(conSn);}
    @Override
    public FullyFunded getFullyFundedById(int id){ return  fullyFundedDao.getFullyFundedById(id);}
}
