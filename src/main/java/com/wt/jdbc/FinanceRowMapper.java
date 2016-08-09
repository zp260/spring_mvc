package com.wt.jdbc;

import com.wt.model.Finance;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/8/3.
 */
public class FinanceRowMapper implements RowMapper<Finance>{
   public Finance mapRow(ResultSet resultSet, int line) throws SQLException{
       FinanceExtrator financeExtrator = new FinanceExtrator();
       return financeExtrator.extractData(resultSet);

   }
}
