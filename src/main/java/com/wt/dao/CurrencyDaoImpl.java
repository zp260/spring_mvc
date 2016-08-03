package com.wt.dao;

import com.wt.jdbc.CurrencyRowMapper;
import com.wt.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/8/3.
 */
@Repository
public class CurrencyDaoImpl implements CurrencyDao {

    @Autowired
    DataSource dataSource;


    @Override
    public void insert(Currency money){
        String sql = "INSERT INTO currency (moneyName) VALUES (?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{money.getMoneyName()});
    }
    @Override
    public void delete(int id){
        String sql = "DELETE FROM currency WHERE id="+id;
        JdbcTemplate jdbcTemplate =new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);

    }
    public void update(Currency money){
        String sql = "UPDATE currency SET moneyName=? WHERE id=?";
        JdbcTemplate jdbcTemplate =new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{
                money.getMoneyName(),
                money.getId()
        });
    }
    public List<Currency> list(){
        List<Currency> list = new ArrayList<Currency>();
        String sql = "SELECT * FROM currency";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        list = jdbcTemplate.query(sql,new CurrencyRowMapper());
        return  list;
    }
    public Currency getMoneyByName(String moneyName){
        List<Currency> list = new ArrayList<Currency>();
        String sql = "SELECT * FROM currency WHERE moneyName = '"+ moneyName + "'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        list = jdbcTemplate.query(sql,new CurrencyRowMapper());
        return list.get(0);

    }
    public Currency getMoneyById(int id){
        List<Currency> list = new ArrayList<Currency>();
        String sql = "SELECT * FROM currency WHERE id =" + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        list = jdbcTemplate.query(sql,new CurrencyRowMapper());
        return list.get(0);
    }
}
