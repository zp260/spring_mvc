package com.wt.jdbc;

import com.wt.model.Currency;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/8/3.
 */
public class CurrencyExtrator implements ResultSetExtractor<Currency>{
   public Currency extractData(ResultSet resultSet) throws SQLException, DataAccessException{
       Currency money = new Currency();
       money.setId(resultSet.getInt("id"));
       money.setMoneyName(resultSet.getString("moneyName"));
       return money;
   }
}
