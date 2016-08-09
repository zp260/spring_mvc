package com.wt.dao;


import com.wt.model.Finance;

import java.util.List;

/**
 * Created by mrz on 16/8/3.
 */
public interface FinanceDao {
    public void insert(Finance finance);
    public void delete(int id);
    public void update(Finance finance);
    public List<Finance> list();
    public List<Finance> getFinanceByConSN(String conSn);
    public Finance getFinanceById(int id);
}
