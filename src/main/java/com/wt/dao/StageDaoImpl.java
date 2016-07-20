package com.wt.dao;

import com.wt.jdbc.StageRowMapper;
import com.wt.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/7/20.
 */
public class StageDaoImpl implements StageDao {
    @Autowired
    DataSource dataSource;

    @Override
    public void insert(Stage stage){
        String sql = "INSERT INTO stage (conSN,stageNum,goodsArriveCoalDate) VALUES (?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{stage.getConSN(),stage.getStageNum(),stage.getGoodsArriveCoalDate()});

    }
    @Override
    public void update(Stage stage){
        String sql = "UPDATE stage SET conSN=?,stageNum=?,goodsArriveCoalDate=?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{stage.getConSN(),stage.getStageNum(),stage.getGoodsArriveCoalDate()});

    }
    @Override
    public void delete(int id){
        String sql = "DELETE FROM stage WHERE id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }
    @Override
    public List<Stage> getStageList(){
        List<Stage> stageList= new ArrayList<Stage>();
        String sql = "SELECT * FROM stage";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        stageList = jdbcTemplate.query(sql,new StageRowMapper());
        return  stageList;


    }
    @Override
    public Stage getStageById(int id){
        List<Stage> stageList = new ArrayList<Stage>();
        String sql = "SELECT * FROM stage where id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        stageList = jdbcTemplate.query(sql,new StageRowMapper());
        return  stageList.get(0);

    }
}
