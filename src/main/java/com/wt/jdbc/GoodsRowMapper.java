package com.wt.jdbc;

import com.wt.model.Goods;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/8/1.
 */
public class GoodsRowMapper implements RowMapper<Goods>{
   public Goods mapRow(ResultSet resultSet, int line) throws SQLException{
       GoodsExtrator goodsExtrator = new GoodsExtrator();
       return goodsExtrator.extractData(resultSet);

   }
}
