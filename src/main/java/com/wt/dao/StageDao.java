package com.wt.dao;

import com.wt.model.Stage;

import java.util.List;

/**
 * Created by mrz on 16/7/20.
 */
public interface StageDao {
    public void insert(Stage stage);
    public void delete(int id);
    public void update(Stage stage);
    public List<Stage> getStageList();
    public Stage getStageById(int id);
}
