package com.wt.dao;

import com.wt.controller.BaseController;
import com.wt.jdbc.GoodsRowMapper;
import com.wt.model.Goods;
import com.wt.searchBean.GoodAndCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/8/1.
 */
@Repository
public class GoodsDaoImpl extends BaseController implements GoodsDao {
    @Autowired
    DataSource dataSource;
    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Override
    public void insertGoods(Goods goods){
        String sql = "INSERT INTO goods (conSN,stageNum,goodsName,goodsPrice,goodsModel,goodsCount) VALUES (?,?,?,?,?,?)";
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
        jdbcTemplate.update(sql);


    }
    @Override
    public void updateGoods(Goods goods){
        String sql = "UPDATE goods SET conSN=?,stageNum=?,goodsName=?,goodsPrice=?,goodsModel=?,goodsCount=? WHERE goodsId=?";
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
        list = jdbcTemplate.query(sql,new GoodsRowMapper());
        return list;
    }
    @Override
    public List<Goods> goodsListByConStage(String con,Integer num){
        List<Goods> list = new ArrayList<Goods>();
        String sql = "SELECT * FROM goods WHERE conSN=? AND stageNum=?";
        list = jdbcTemplate.query(sql,new GoodsRowMapper(),new Object[]{con,num});
        return list;
    }
    @Override
    public Goods getGoodById(int id){
        List<Goods> list = new ArrayList<Goods>();
        String sql = "SELECT * FROM goods WHERE goodsId="+id;
        list=jdbcTemplate.query(sql,new GoodsRowMapper());
        return list.get(0);

    }
    @Override
    public Goods getGoodByName(String goodName){
        List<Goods> list = new ArrayList<Goods>();
        String sql = "SELECT * FROM goods WHERE goodsName='"+goodName +"'";
        list=jdbcTemplate.query(sql,new GoodsRowMapper());
        return list.get(0);
    }
    @Override
    public List<GoodAndCon> search(String filedname,String value){
        String sql = "select goods.*,conBase.useORG,conBase.supplier,stage.goodsArriveCoalDate FROM goods,conBase,stage WHERE isInPort=TRUE AND conBase.conSN = goods.conSN = stage.conSN AND "+filedname+"  LIKE '%"+value+"%' GROUP BY goodsId";
        List<GoodAndCon> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<GoodAndCon>(GoodAndCon.class));
        return list;
    }
}
