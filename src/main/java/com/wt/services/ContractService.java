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
    public Contract getContractByConSN(String conSN);  //根据合同号查询
    /**
     * 根据字段名进行搜索
     * @param fieldName 字段名
     * @param value     字段值
     * @return          合同列表
     */
    public List<Contract> selectAll(String fieldName,Object value);

    /**
     * 根据时间段搜索
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return          合同列表
     */
    public List<Contract> getConByDate(String startDate,String endDate); //根据合同签订时间查询

    /**
     * 根据合同查询
     * @param goodName  货物名称
     * @return          合同列表
     */
    public List<Contract> getConByGood(String goodName);
    public void verify(int id); //审核
    public Boolean hasContract(String conSN); //是否已经存在合同
}
