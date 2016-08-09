package com.wt.jdbc;

import com.wt.model.FullyFunded;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/8/4.
 */
public class FullyFundedRowMapper implements RowMapper<FullyFunded>{
   public FullyFunded mapRow(ResultSet resultSet, int line) throws SQLException{
       FullyFundedExtrator fullyFundedExtrator = new FullyFundedExtrator();
       return fullyFundedExtrator.extractData(resultSet);
   }
}
