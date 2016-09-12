package com.wt.services;

import com.wt.dao.GoodsDao;
import com.wt.model.Goods;
import com.wt.searchBean.GoodAndCon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrz on 16/8/1.
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    @Override
    public void insertGoods(Goods goods){
        goodsDao.insertGoods(goods);
    }
    @Override
    public void deleteGoods(int id){
        goodsDao.deleteGoods(id);
    }
    @Override
    public void updateGoods(Goods goods){
        goodsDao.updateGoods(goods);
    }
    @Override
    public List<Goods> goodsList(){
       return goodsDao.goodsList();
    }
    @Override
    public List<Goods> goodsListByConStage(String con,Integer num){return goodsDao.goodsListByConStage(con,num);}
    @Override
    public Goods getGoodById(int id){
            return  goodsDao.getGoodById(id);
    }
    @Override
    public Goods getGoodByName(String goodName){return goodsDao.getGoodByName(goodName);}
    @Override
    public List<GoodAndCon> search(String filedname, String value){return goodsDao.search(filedname,value);}
}
