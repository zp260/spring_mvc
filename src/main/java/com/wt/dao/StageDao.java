package com.wt.dao;

import com.wt.model.Stage;
import com.wt.searchBean.DeclareBean;

import java.util.List;

/**
 * Created by mrz on 16/7/20.
 */
public interface StageDao {
    public void insert(Stage stage);
    public void delete(int id);
    public void update(Stage stage);
    public List<Stage> getStageList();
    public List<Stage> getStageListByConSN(String conSN);
    public Stage getStageById(int id);
    public Stage getStageByStageNum(Integer num,String conSn);
    public Integer getStageNumByContract(String contractSN); //通过合同号查已经有多少已存批次
    public List<Stage> selectByFiledName(String fieldName,Object value);
    public List<DeclareBean> selectByDate(String startDate,String endDate); //通过时间段搜索，返回报关BEAN
}
