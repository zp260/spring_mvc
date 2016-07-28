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
                "atDoller," +
                "atRMB," +
                "lcSN," +
                "lcTimeLimit," +
                "lcFrom," +
                "lcPrice," +
                "lcStartDate," +
                "lcChangeDate," +
                "lcChangeReason," +
                "deliveryDate," +
                "conFrom" +
                ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
                contract.getAtDoller(),
                contract.getAtRMB(),
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
                "atDoller=?," +
                "atRMB=?," +
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
                contract.getAtDoller(),
                contract.getAtRMB(),
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

    @Override
    public void verify(int id){
        String sql = "UPDATE conBase SET conVerify=TRUE WHERE id=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{id});
    }

}
