package com.wt.services;

import com.wt.dao.ContractDao;
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
    public List<Contract> ContractList(){
      return   contractDao.ContractList();
    }
    @Override
    public Contract getContractById(int id){return  contractDao.getContractById(id);}
    @Override
    public Contract getContractByConSN(String conSN){return contractDao.getContractByConSN(conSN);}
    @Override
    public void verify(int id){ contractDao.verify(id);}
    @Override
    public Boolean hasContract(String conSN){return  contractDao.hasContract(conSN);}
}
