package com.wt.dao;

import com.wt.jdbc.PortRowMapper;
import com.wt.model.Port;
import com.wt.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;


import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/7/8.
 */
public class PortDaoImpl implements PortDao {
    @Autowired
    DataSource dataSource;

    @Override
    public void insertPort(Port port){
        String sql = "INSERT INTO ports (portname,orders) VALUES (?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{port.getPortName(),port.getOrders()});
    }

    @Override
    public void updatePort(Port port){
        String sql = "UPDATE ports SET portname=?,orders=? where id =?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{port.getPortName(),port.getOrders(),port.getId()});
    }

    @Override
    public void delPort(int id){
        String sql = "DELETE FROM ports WHERE id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }

    @Override
    public List<Port> getPortList(){

        List portlist= new ArrayList();
        String sql = "select * from ports";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        portlist= jdbcTemplate.query(sql,new PortRowMapper());
        return  portlist;
    }

    @Override
    public Port  getPortById(int id){
        List<Port> ports = new ArrayList<Port>();
        String sql = "SELECT * FROM ports WHERE id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        ports=jdbcTemplate.query(sql,new PortRowMapper());
        return ports.get(0);
    }
}
