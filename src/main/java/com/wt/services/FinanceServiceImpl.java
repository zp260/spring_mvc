package com.wt.services;

import com.wt.dao.FinanceDao;
import com.wt.model.Finance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by mrz on 16/8/3.
 */
@Service
public class FinanceServiceImpl implements FinanceService {
    @Autowired
    FinanceDao financeDao;

    @Override
    public void insert(Finance finance){ financeDao.insert(finance);}
    @Override
    public void delete(int id){financeDao.delete(id);}
    @Override
    public void update(Finance finance){financeDao.update(finance);}
    @Override
    public List<Finance> list(){return financeDao.list();}
    @Override
    public List<Finance> getFinanceByConSN(String conSn){return  financeDao.getFinanceByConSN(conSn);}
    @Override
    public Finance getFinanceById(int id){return financeDao.getFinanceById(id);}
}
