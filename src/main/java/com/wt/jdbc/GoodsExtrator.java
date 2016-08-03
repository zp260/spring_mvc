package com.wt.jdbc;

import com.wt.controller.BaseController;
import com.wt.model.Goods;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/8/1.
 */
public class GoodsExtrator extends BaseController implements ResultSetExtractor<Goods> {
   public Goods extractData(ResultSet resultSet) throws SQLException, DataAccessException{
       Goods goods = new Goods();
       try {
           getMethodInfo(goods,resultSet);
       } catch (Exception e) {
           e.printStackTrace();
       }
       return goods;
   }
}
