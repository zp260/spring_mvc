package com.wt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by mrz on 16/9/13.
 */
@Repository
public class DaoBaseImpl implements DaoBase {
    @Autowired
    DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public List select(String table, String filedName, String value, RowMapper rowMapper,List callBackList){
        String sql = "SELECT * FROM " + table + " WHERE " + filedName + " LIKE '%" + value + "%'";
        callBackList =  jdbcTemplate.query(sql,rowMapper);
        return  callBackList;
    }

    @Override
    public List selectTwo(String table1,String table2, String filedName, String value, RowMapper rowMapper, List callBackList,String condition){
        String sql = "SELECT * FROM " + table1+ "," + table2 + " WHERE " + condition + " AND " + filedName + " LIKE '%" + value + "%'";
        callBackList =  jdbcTemplate.query(sql,rowMapper);
        return  callBackList;
    }
    @Override
    public List selectByDate(String table, String filedName, String startDate,String endDate, RowMapper rowMapper, List callBackList){
        String sql = "SELECT * FROM "+ table +"  WHERE  "+ filedName +" BETWEEN ? AND ?";
        callBackList =  jdbcTemplate.query(sql,rowMapper,new Object[]{startDate,endDate});
        return  callBackList;
    }
}
