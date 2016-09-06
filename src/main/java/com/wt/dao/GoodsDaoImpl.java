package com.wt.dao;

import com.wt.controller.BaseController;
import com.wt.jdbc.GoodsRowMapper;
import com.wt.model.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/8/1.
 */
public class GoodsDaoImpl extends BaseController implements GoodsDao {
    @Autowired
    DataSource dataSource;

    @Override
    public void insertGoods(Goods goods){
        String sql = "INSERT INTO goods (conSN,stageNum,goodsName,goodsPrice,goodsModel,goodsCount) VALUES (?,?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{
        goods.getConSN(),
        goods.getStageNum(),
        goods.getGoodsName(),
        goods.getGoodsPrice(),
        goods.getGoodsModel(),
        goods.getGoodsCount()
        });
    }
    @Override
    public void deleteGoods(int id){
        String sql = "DELETE FROM goods WHERE goodsId="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);


    }
    @Override
    public void updateGoods(Goods goods){
        String sql = "UPDATE goods SET conSN=?,stageNum=?,goodsName=?,goodsPrice=?,goodsModel=?,goodsCount=? WHERE goodsId=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{
                goods.getConSN(),
                goods.getStageNum(),
                goods.getGoodsName(),
                goods.getGoodsPrice(),
                goods.getGoodsModel(),
                goods.getGoodsCount(),
                goods.getGoodsId()
        });

    }
    @Override
    public List<Goods> goodsList(){
        List<Goods> list = new ArrayList<Goods>();
        String sql = "SELECT * FROM goods";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        list = jdbcTemplate.query(sql,new GoodsRowMapper());
        return list;
    }
    @Override
    public List<Goods> goodsListByConStage(String con,Integer num){
        List<Goods> list = new ArrayList<Goods>();
        String sql = "SELECT * FROM goods WHERE conSN=? AND stageNum=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        list = jdbcTemplate.query(sql,new GoodsRowMapper(),new Object[]{con,num});
        return list;
    }
    @Override
    public Goods getGoodById(int id){
        List<Goods> list = new ArrayList<Goods>();
        String sql = "SELECT * FROM goods WHERE goodsId="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        list=jdbcTemplate.query(sql,new GoodsRowMapper());
        return list.get(0);

    }
    @Override
    public Goods getGoodByName(String goodName){
        List<Goods> list = new ArrayList<Goods>();
        String sql = "SELECT * FROM goods WHERE goodsName='"+goodName +"'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        list=jdbcTemplate.query(sql,new GoodsRowMapper());
        return list.get(0);
    }
}
