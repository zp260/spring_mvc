package com.wt.services;

import com.wt.model.Goods;

import java.util.List;

/**
 * Created by mrz on 16/8/1.
 */
public interface GoodsService {
    public void insertGoods(Goods goods);
    public void deleteGoods(int id);
    public void updateGoods(Goods goods);
    public List<Goods> goodsList();
    public Goods getGoodById(int id);
    public Goods getGoodByName(String goodName);
}
