package com.wt.jdbc;

import com.wt.model.Stage;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/7/20.
 */
public class StageExtractor implements ResultSetExtractor<Stage> {
  public Stage  extractData(ResultSet resultSet) throws SQLException, DataAccessException{
      Stage stage = new Stage();
      stage.setId(resultSet.getInt("id"));
      stage.setConSN(resultSet.getString("conSN"));
      stage.setStageNum(resultSet.getInt("stageNum"));
      stage.setGoodsArriveCoalDate(resultSet.getDate("goodsArriveCoalDate"));
      return stage;
    }
}
