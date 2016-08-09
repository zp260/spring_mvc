package com.wt.dao;

import com.wt.controller.BaseController;
import com.wt.jdbc.FullyFundedRowMapper;
import com.wt.model.FullyFunded;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mrz on 16/8/4.
 */
@Repository
public class FullyFundedDaoImpl extends BaseController implements FullyFundedDao{
    @Autowired
    DataSource dataSource;
    @Override
    public void insert(FullyFunded fullyFunded){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = setInsertSql(fullyFunded,"fullyFunded","id");
        jdbcTemplate.update(sql,new Object[]{
                fullyFunded.getConSN(),
                fullyFunded.getAskForReportSN(),
                fullyFunded.getAskForMoney(),
                Str2Date(fullyFunded.getAskForDate()),
                fullyFunded.getReceiveMoney(),
                Str2Date(fullyFunded.getReceiveMoneyDate()),
                fullyFunded.getSuccess()
        });

    }

    public void delete(int id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "DELETE FROM fullyFunded WHERE id="+id;
        jdbcTemplate.update(sql);
    }


    public void update(FullyFunded fullyFunded){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "UPDATE fullyFunded SET conSN=?,askForReportSN=?,askForMoney=?,askForDate=?,receiveMoney=?,receiveMoneyDate=?,success=? WHERE id=?";
        jdbcTemplate.update(sql,new Object[]{
                fullyFunded.getConSN(),
                fullyFunded.getAskForReportSN(),
                fullyFunded.getAskForMoney(),
                fullyFunded.getAskForDate(),
                fullyFunded.getReceiveMoney(),
                fullyFunded.getReceiveMoneyDate(),
                fullyFunded.getSuccess(),
                fullyFunded.getId()
        });
    }
    @Override
    public List<FullyFunded> list(){
        List<FullyFunded> list = new ArrayList<FullyFunded>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM fullyFunded";
        list =   jdbcTemplate.query(sql,new FullyFundedRowMapper());
        return list;
    }
    @Override
    public List<FullyFunded> getFullyFundedByConSN(String conSn){
        List<FullyFunded> list = new ArrayList<FullyFunded>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM fullyFunded WHERE consn='"+conSn+"'";
        list =   jdbcTemplate.query(sql,new FullyFundedRowMapper());
        return list;

    }
    @Override
    public FullyFunded getFullyFundedById(int id){
        List<FullyFunded> list = new ArrayList<FullyFunded>();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql = "SELECT * FROM fullyFunded WHERE id="+id;
        list =   jdbcTemplate.query(sql,new FullyFundedRowMapper());
        return list.get(0);
    }
}
