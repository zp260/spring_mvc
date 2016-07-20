package com.wt.jdbc;

import com.wt.model.Stage;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/7/20.
 */
public class StageRowMapper implements RowMapper<Stage> {

  @Override
  public Stage  mapRow(ResultSet resultSet, int line) throws SQLException
  {
    StageExtractor stageExtractor = new StageExtractor();
      return stageExtractor.extractData(resultSet);
  }
}
