package com.wt.jdbc;

import com.wt.controller.BaseController;
import com.wt.model.FullyFunded;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/8/4.
 */
public class FullyFundedExtrator extends BaseController implements ResultSetExtractor<FullyFunded> {
   public FullyFunded extractData(ResultSet resultSet) throws SQLException, DataAccessException{
       FullyFunded fullyFunded = new FullyFunded();
       try {
           getMethodInfo(fullyFunded,resultSet);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return fullyFunded;
   }
}
