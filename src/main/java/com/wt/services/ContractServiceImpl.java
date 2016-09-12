package com.wt.services;

import com.wt.dao.ContractDao;
import com.wt.dao.GoodsDao;
import com.wt.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mrz on 16/7/14.
 */
public class ContractServiceImpl implements ContractService {
    @Autowired
    ContractDao contractDao;
    @Override
    public void insert(Contract contract){contractDao.insert(contract);}
    @Override
    public void delete(int id){contractDao.delete(id);}
    @Override
    public void update(Contract contract){
        contractDao.update(contract);
    }
    @Override
    public List<Contract> ContractList(){return   contractDao.ContractList();}
    @Override
    public List<Contract> noVerify(){return contractDao.noVerify();}
    @Override
    public Contract getContractById(int id){return  contractDao.getContractById(id);}
    @Override
    public Contract getContractByConSN(String conSN){return contractDao.getContractByConSN(conSN);}
    @Override
    public List<Contract> selectAll(String fieldName,Object value){return contractDao.selectAll(fieldName,value);}
    @Override
    public List<Contract> getConByDate(String startDate,String endDate){return  contractDao.getConByDate(startDate,endDate);}
    @Override
    public List<Contract> getConByGood(String goodName){return  contractDao.getConByGood(goodName);}
    @Override
    public void verify(int id){ contractDao.verify(id);}
    @Override
    public Boolean hasContract(String conSN){return  contractDao.hasContract(conSN);}
}
