package com.wt.dao;

import com.wt.model.Contract;

import java.util.List;

/**
 * Created by mrz on 16/7/14.
 */
public interface ContractDao {
    public void insert(Contract contract);
    public void delete(int id);
    public void update(Contract contract);
    public List<Contract> ContractList();
    public Contract getContractById(int id);
    public Contract getContractByConSN(String conSN);
    public void verify(int id); //审核
    public Boolean hasContract(String conSN); //是否已经存在合同
}
