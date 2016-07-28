package com.wt.jdbc;

import com.wt.controller.BaseController;
import com.wt.model.Stage;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/7/20.
 */
public class StageExtractor extends BaseController implements ResultSetExtractor<Stage> {
  public Stage  extractData(ResultSet resultSet) throws SQLException, DataAccessException{
      Stage stage = new Stage();
      try {
          getMethodInfo(stage,resultSet);
      } catch (Exception e) {
          e.printStackTrace();
      }
      return stage;
    }
}
