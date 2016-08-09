package com.wt.dao;

import com.wt.controller.BaseController;
import com.wt.jdbc.FinanceRowMapper;
import com.wt.model.Finance;
import jdk.nashorn.internal.scripts.JD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/8/3.
 */
@Repository
public class FinanceDaoImpl extends BaseController implements FinanceDao{

    @Autowired
    DataSource dataSource;


    @Override
    public void insert(Finance finance){

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= setInsertSql(finance,"finance","id");
        jdbcTemplate.update(sql,new Object[]{
        finance.getConSN(),
        finance.getStageId(),
        finance.getCertificate(),
        finance.getReceiveMoney(),
        finance.getPaidMoney(),
        finance.getUnpaidMoney(),
       Str2Date(finance.getPaidMoneyDate())
        });

    }
    @Override
    public void delete(int id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= "DELETE FROM finance WHERE id="+id;
        jdbcTemplate.update(sql);
    }
    @Override
    public void update(Finance finance){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        String sql= "UPDATE finance SET " +
                "conSN=?," +
                "stageId=?," +
                "certificate=?," +
                "receiveMoney=?," +
                "paidMoney=?," +
                "unpaidMoney=?," +
                "paidMoneyDate=? " +
                "WHERE id=?";
        jdbcTemplate.update(sql,new Object[]{
                finance.getConSN(),
                finance.getStageId(),
                finance.getCertificate(),
                finance.getReceiveMoney(),
                finance.getPaidMoney(),
                finance.getUnpaidMoney(),
                Str2Date(finance.getPaidMoneyDate()),
                finance.getId()
        });
    }
    @Override
    public List<Finance> list(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Finance> finances = new ArrayList<Finance>();
        String sql= "SELECT * FROM finance";
        finances = jdbcTemplate.query(sql,new FinanceRowMapper());
        return  finances;


    }
    @Override
    public List<Finance> getFinanceByConSN(String conSn){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Finance> finances = new ArrayList<Finance>();
        String sql= "SELECT * FROM finance WHERE  conSn='" + conSn + "'";
        finances = jdbcTemplate.query(sql,new FinanceRowMapper());
        return  finances;
    }
    public Finance getFinanceById(int id){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<Finance> finances = new ArrayList<Finance>();
        String sql= "SELECT * FROM finance WHERE  id=" + id;
        finances = jdbcTemplate.query(sql,new FinanceRowMapper());
        return  finances.get(0);
    }
}
