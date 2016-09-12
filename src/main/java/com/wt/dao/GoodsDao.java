package com.wt.dao;

import com.wt.model.Goods;
import com.wt.searchBean.GoodAndCon;

import java.util.List;

/**
 * Created by mrz on 16/8/1.
 */
public interface GoodsDao {
    public void insertGoods(Goods goods);
    public void deleteGoods(int id);
    public void updateGoods(Goods goods);
    public List<Goods> goodsList();
    public List<Goods> goodsListByConStage(String con,Integer num);
    public Goods getGoodById(int id);
    public Goods getGoodByName(String goodName);

    /**
     * 查询
     * @param filedname 查询字段名
     * @param value     查询值
     * @return          联合搜索的goodAndCon bean的对象列表
     */
    public List<GoodAndCon> search(String filedname, String value);
}
