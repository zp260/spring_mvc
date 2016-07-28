package com.wt.services;

import com.wt.model.Contract;

import java.util.List;

/**
 * Created by mrz on 16/7/14.
 */
public interface ContractService {
    public void insert(Contract contract);
    public void delete(int id);
    public void update(Contract contract);
    public List<Contract> ContractList();
    public Contract getContractById(int id);

    public void verify(int id); //审核
}
