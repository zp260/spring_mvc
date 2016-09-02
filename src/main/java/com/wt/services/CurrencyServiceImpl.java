package com.wt.services;

import com.wt.dao.CurrencyDao;
import com.wt.model.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrz on 16/8/3.
 */
@Service
public class CurrencyServiceImpl implements  CurrencyService{
    @Autowired
    CurrencyDao currencyDao;

    @Override
    public void insert(Currency money){
        currencyDao.insert(money);
    }
    @Override
    public void delete(int id){
        currencyDao.delete(id);
    }
    @Override
    public void update(Currency money){
        currencyDao.update(money);
    }
    @Override
    public List<Currency> list(){return currencyDao.list();}
    @Override
    public Currency getMoneyByName(String moneyName){
        return currencyDao.getMoneyByName(moneyName);
    }
    @Override
    public Currency getMoneyById(int id){
        return currencyDao.getMoneyById(id);
    }
}
