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
    public List<Contract> ContractList(); //审核通过的合同列表
    public List<Contract> noVerify();     //未审核的合同列表
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
    public List<Contract> getConByGood(String goodName);//根据商品名查询
    public void verify(int id); //审核
    public Boolean hasContract(String conSN); //是否已经存在合同
}
