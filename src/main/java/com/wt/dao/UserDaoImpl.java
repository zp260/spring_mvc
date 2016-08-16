package com.wt.dao;

import com.wt.jdbc.UserRowMapper;
import com.wt.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mrz on 16/7/1.
 */
public class UserDaoImpl implements UserDao {
    @Autowired
    DataSource dataSource;

    @Override
    public void insertData(User user){
        String sql="INSERT INTO users "+"(username,loginname,password,userpower) VALUES (?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{user.getUserName(),user.getLoginName(),user.getPassWord(),user.getUserPower()});
    }

    @Override
    public List<User>  getUserList(){
        List userList = new ArrayList();
        String sql = "select * from users";
        JdbcTemplate jdbcTemplate =  new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql,new UserRowMapper());
        return  userList;
    }

    @Override
    public void deleteData(int id){
        String sql = "DELETE from users where id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }
    @Override
    public void updateData(User user){
        String sql = "UPDATE users set username=?,loginname=?,password=?,userpower=? where id=?";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);

        jdbcTemplate.update(sql,new Object[]{user.getUserName(),user.getLoginName(),user.getPassWord(),user.getUserPower(),user.getId()});

    }

    @Override
    public User getUser(String username){
        List<User> userList = new ArrayList<User>();
        String sql = "select * from users where username=" + username;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql,new UserRowMapper());
        return userList.get(0);
    }
    @Override
    public User getUserById(int id){
        List<User> userList = new ArrayList<User>();
        String sql = "select * from users where id=" + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql,new UserRowMapper());
        return userList.get(0);
    }
}
