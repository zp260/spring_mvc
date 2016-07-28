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
    public void insert(Contract contract){
        contractDao.insert(contract);

    }
    public void delete(int id){
        contractDao.delete(id);

    }
    public void update(Contract contract){
        contractDao.update(contract);
    }
    public List<Contract> ContractList(){
      return   contractDao.ContractList();
    }
    public Contract getContractById(int id){
        return  contractDao.getContractById(id);

    }
    public void verify(int id){ contractDao.verify(id);}
}
