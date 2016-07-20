package com.wt.jdbc;

import com.wt.model.Contract;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *-[0'P;0-=0'-][POIT    4
 */
public class ContractRowMapper implements RowMapper<Contract> {
    @Override
   public Contract mapRow(ResultSet resultSet, int line) throws SQLException{
        ContractExtractor contractExtractor = new ContractExtractor();
      return   contractExtractor.extractData(resultSet);
    }
}
