package com.wt.dao;

import com.wt.model.Currency;

import java.util.List;

/**
 * Created by mrz on 16/8/3.
 */
public interface CurrencyDao {
    public void insert(Currency money);
    public void delete(int id);
    public void update(Currency money);
    public List<Currency> list();
    public Currency getMoneyByName(String moneyName);
    public Currency getMoneyById(int id);
}
