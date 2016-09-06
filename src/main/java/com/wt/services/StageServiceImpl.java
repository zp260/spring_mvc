package com.wt.services;

import com.wt.dao.StageDao;
import com.wt.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mrz on 16/7/20.
 */
public class StageServiceImpl implements StageService {
    @Autowired
    StageDao stageDao;
    public void insert(Stage stage){
        stageDao.insert(stage);
    }
    public void delete(int id){stageDao.delete(id);}
    public void update(Stage stage){stageDao.update(stage);}
    public List<Stage> getStageList(){
        return stageDao.getStageList();
    }
    public List<Stage> getStageListByConSN(String conSN){return stageDao.getStageListByConSN(conSN);}
    public Stage getStageById(int id){return stageDao.getStageById(id);}
    public Stage getStageByStageNum(Integer num,String conSn){return stageDao.getStageByStageNum(num,conSn);}
    public Integer getStageNumByContract(String contractSN){return stageDao.getStageNumByContract(contractSN);}
}
