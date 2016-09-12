package com.wt.services;

import com.wt.model.Goods;
import com.wt.searchBean.GoodAndCon;

import java.util.List;

/**
 * Created by mrz on 16/8/1.
 */
public interface GoodsService {
    public void insertGoods(Goods goods);
    public void deleteGoods(int id);
    public void updateGoods(Goods goods);
    public List<Goods> goodsList();
    public List<Goods> goodsListByConStage(String con,Integer num);
    public Goods getGoodById(int id);
    public Goods getGoodByName(String goodName);
    public List<GoodAndCon> search(String filedname, String value);
}
