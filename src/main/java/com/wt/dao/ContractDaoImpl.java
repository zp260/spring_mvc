package com.wt.dao;

import com.wt.jdbc.ContractRowMapper;
import com.wt.model.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/7/14.
 */
public class ContractDaoImpl implements ContractDao {

    @Autowired
    DataSource dataSource;

    @Override
    public void insert(Contract contract){
        String sql = "INSERT INTO conBase (" +
                "conSN," +
                "conTime," +
                "isInport," +
                "conVerify," +
                "useORG," +
                "supplier," +
                "biddingSN," +
                "conPrice," +
                "atDoller," +
                "atRMB," +
                "lcSN," +
                "lcTimeLimit," +
                "lcFrom," +
                "lcPrice," +
                "lcStartDate," +
                "lcChangeTime," +
                "lcChangeReason," +
                "deliveryDate," +
                "conFrom" +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{
                contract.getConSN(),
                contract.getConTime(),
                contract.getIsInport(),
                contract.getConVerify(),
                contract.getUseORG(),
                contract.getSupplier(),
                contract.getBiddingSN(),
                contract.getConPrice(),
                contract.getAtDoller(),
                contract.getAtRMB(),
                contract.getLcSN(),
                contract.getLcTimeLimit(),
                contract.getLcFrom(),
                contract.getLcPrice(),
                contract.getLcStartDate(),
                contract.getLcChangeTime(),
                contract.getLcChangeReason(),
                contract.getDeliveryDate(),
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
                "conTime=?," +
                "isInport=?," +
                "conVerify=?," +
                "useORG=?," +
                "supplier=?," +
                "biddingSN=?," +
                "conPrice=?," +
                "atDoller=?," +
                "atRMB=?," +
                "lcSN=?," +
                "lcTimeLimit=?," +
                "lcFrom=?," +
                "lcPrice=?," +
                "lcStartDate=?," +
                "lcChangeTime=?," +
                "lcChangeReason=?," +
                "deliveryDate=?," +
                "conFrom=?" +
                " WHERE id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{
                contract.getConSN(),
                contract.getConTime(),
                contract.getIsInport(),
                contract.getConVerify(),
                contract.getUseORG(),
                contract.getSupplier(),
                contract.getBiddingSN(),
                contract.getConPrice(),
                contract.getAtDoller(),
                contract.getAtRMB(),
                contract.getLcSN(),
                contract.getLcTimeLimit(),
                contract.getLcFrom(),
                contract.getLcPrice(),
                contract.getLcStartDate(),
                contract.getLcChangeTime(),
                contract.getLcChangeReason(),
                contract.getDeliveryDate(),
                contract.getConFrom(),
                contract.getId()
        });

    }
    @Override
    public List<Contract> ContractList(){
        List contractList = new ArrayList();
        String sql = "SELECT * from conBase";
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
        return  contractList.get(0);
    }
}
