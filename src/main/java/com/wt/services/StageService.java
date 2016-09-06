package com.wt.services;

import com.wt.model.Stage;

import java.util.List;

/**
 * Created by mrz on 16/7/20.
 */
public interface StageService {
    public void insert(Stage stage);
    public void delete(int id);
    public void update(Stage stage);
    public List<Stage> getStageList();
    public List<Stage> getStageListByConSN(String conSN);
    public Stage getStageById(int id);
    public Stage getStageByStageNum(Integer num,String conSn);
    public Integer getStageNumByContract(String contractSN);
}
