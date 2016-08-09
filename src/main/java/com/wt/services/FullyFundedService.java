package com.wt.services;

import com.wt.model.FullyFunded;

import java.util.List;

/**
 * Created by mrz on 16/8/4.
 */
public interface FullyFundedService {
    public void insert(FullyFunded fullyFunded);
    public void delete(int id);
    public void update(FullyFunded fullyFunded);
    public List<FullyFunded> list();
    public List<FullyFunded> getFullyFundedByConSN(String conSn);
    public FullyFunded getFullyFundedById(int id);
}
