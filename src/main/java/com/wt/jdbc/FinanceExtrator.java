package com.wt.jdbc;

import com.wt.controller.BaseController;
import com.wt.model.Finance;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/8/3.
 */
public class FinanceExtrator extends BaseController implements ResultSetExtractor<Finance> {
  public Finance  extractData(ResultSet resultSet) throws SQLException, DataAccessException{
      Finance finance = new Finance();
      try {
          getMethodInfo(finance,resultSet);
      } catch (Exception e) {
          e.printStackTrace();
      }
        return  finance;
  }
}
