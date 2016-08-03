package com.wt.jdbc;

import com.wt.model.Currency;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/8/3.
 */
public class CurrencyRowMapper implements RowMapper<Currency> {
  public Currency mapRow(ResultSet resultSet, int line) throws SQLException{
      CurrencyExtrator moneyExtrator = new CurrencyExtrator();
     return moneyExtrator.extractData(resultSet);
    }
}
