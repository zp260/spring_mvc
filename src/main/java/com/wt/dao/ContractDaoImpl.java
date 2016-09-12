package com.wt.dao;

import com.wt.controller.BaseController;
import com.wt.jdbc.ContractRowMapper;
import com.wt.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by mrz on 16/7/14.
 */
public class ContractDaoImpl extends BaseController implements ContractDao {

    @Autowired
    DataSource dataSource;

    @Override
    public void insert(Contract contract){
        String sql = "INSERT INTO conBase (" +
                "conSN," +
                "conDate," +
                "isInport," +
                "conVerify," +
                "useORG," +
                "supplier," +
                "biddingSN," +
                "conPrice," +
                "monetaryUnit,"+
                "atDoller," +
                "dollerRate,"+
                "atRMB," +
                "rmbRate,"+
                "lcSN," +
                "lcTimeLimit," +
                "lcFrom," +
                "lcPrice," +
                "lcStartDate," +
                "lcChangeDate," +
                "lcChangeReason," +
                "deliveryDate," +
                "conFrom" +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{
                contract.getConSN(),
                Str2Date(contract.getConDate()),
                contract.getIsInport(),
                contract.getConVerify(),
                contract.getUseORG(),
                contract.getSupplier(),
                contract.getBiddingSN(),
                contract.getConPrice(),
                contract.getMonetaryUnit(),
                contract.getAtDoller(),
                contract.getDollerRate(),
                contract.getAtRMB(),
                contract.getRmbRate(),
                contract.getLcSN(),
                Str2Date(contract.getLcTimeLimit()),
                contract.getLcFrom(),
                contract.getLcPrice(),
                contract.getLcStartDate(),
                Str2Date(contract.getLcChangeDate()),
                contract.getLcChangeReason(),
                Str2Date(contract.getDeliveryDate()),
                contract.getConFrom()
        });


    }
    @Override
    public void delete(int id){
        String sql = "DELETE FROM conBase where id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);

    }
    @Override
    public void update(Contract contract){
        String sql = "UPDATE conBase SET " +
                "conSN=?," +
                "conDate=?," +
                "isInport=?," +
                "conVerify=?," +
                "useORG=?," +
                "supplier=?," +
                "biddingSN=?," +
                "conPrice=?," +
                "monetaryUnit=?,"+
                "atDoller=?," +
                "dollerRate=?,"+
                "atRMB=?," +
                "rmbRate=?,"+
                "lcSN=?," +
                "lcTimeLimit=?," +
                "lcFrom=?," +
                "lcPrice=?," +
                "lcStartDate=?," +
                "lcChangeDate=?," +
                "lcChangeReason=?," +
                "deliveryDate=?," +
                "conFrom=?" +
                " WHERE id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{
                contract.getConSN(),
                Str2Date(contract.getConDate()),
                contract.getIsInport(),
                contract.getConVerify(),
                contract.getUseORG(),
                contract.getSupplier(),
                contract.getBiddingSN(),
                contract.getConPrice(),
                contract.getMonetaryUnit(),
                contract.getAtDoller(),
                contract.getDollerRate(),
                contract.getAtRMB(),
                contract.getRmbRate(),
                contract.getLcSN(),
                Str2Date(contract.getLcTimeLimit()),
                contract.getLcFrom(),
                contract.getLcPrice(),
                Str2Date(contract.getLcStartDate()),
                Str2Date(contract.getLcChangeDate()),
                contract.getLcChangeReason(),
                Str2Date(contract.getDeliveryDate()),
                contract.getConFrom(),
                contract.getId()
        });

    }
    @Override
    public List<Contract> ContractList(){
        List contractList = new ArrayList();
        String sql = "SELECT * from conBase WHERE isInPort=TRUE AND conVerify=TRUE";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        contractList = jdbcTemplate.query(sql, new ContractRowMapper());
        return contractList;
    }
    @Override
    public List<Contract> noVerify(){
        List contractList = new ArrayList();
        String sql = "SELECT * from conBase WHERE isInPort=TRUE AND conVerify=FALSE";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        contractList = jdbcTemplate.query(sql, new ContractRowMapper());
        return contractList;
    }
    @Override
    public Contract getContractById(int id){
        List<Contract> contractList = new ArrayList<Contract>();
        String sql = "SELECT * from conBase WHERE id="+id;
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        contractList = jdbcTemplate.query(sql, new ContractRowMapper());
        try{
            return contractList.get(0);
        }catch (IndexOutOfBoundsException ex)
        {
            return null;
        }
    }
    @Override
    public Contract getContractByConSN(String conSN){
        List<Contract> contractList = new ArrayList<Contract>();
        String sql = "SELECT * from conBase WHERE conSN=?";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        contractList = jdbcTemplate.query(sql, new ContractRowMapper(),new Object[]{conSN});
        try{
            return contractList.get(0);
        }catch (IndexOutOfBoundsException ex)
        {
            return null;
        }
    }

    @Override
    public void verify(int id){
        String sql = "UPDATE conBase SET conVerify=TRUE WHERE id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{id});
    }
    //返回TRUE 说明已经有合同号了
    @Override
    public Boolean hasContract(String conSN){
        String sql = "SELECT COUNT(conSN) FROM conBase WHERE conSN = ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        Integer count =  jdbcTemplate.queryForObject(sql,new Object[]{conSN},Integer.class);
        return (count>0 ? true :false);
    }

    /**
     * 根据字段名进行搜索
     * @param fieldName 字段名
     * @param value 字段值
     * @return
     */
    @Override
    public List<Contract> selectAll(String fieldName,Object value){
        String sql = "SELECT * from conBase WHERE "+fieldName+"=? AND isInPort=TRUE";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        List<Contract> contractList = jdbcTemplate.query(sql, new ContractRowMapper(),new Object[]{value});
        return contractList;
    }
    @Override
    public List<Contract> getConByDate(String startDate,String endDate){
        String sql = "SELECT * from conBase WHERE isInPort=TRUE AND conDate BETWEEN ? AND ? ";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        List<Contract> contractList = jdbcTemplate.query(sql, new ContractRowMapper(),new Object[]{startDate,endDate});
        return contractList;
    }
    @Override
    public List<Contract> getConByGood(String goodName){
        String sql = "select conBase.* FROM goods,conBase WHERE isInPort=TRUE AND goods.goodsName = ? AND conBase.conSN = goods.conSN GROUP BY conSN ORDER BY id";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        List<Contract> contractList = jdbcTemplate.query(sql, new ContractRowMapper(),new Object[]{goodName});
        return contractList;
    }

}
