package com.wt.dao;

import com.wt.jdbc.UserRowMapper;
import com.wt.model.User;
import com.wt.tools.MD5Util;
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
        String sql="INSERT INTO users "+"(username,loginname,password,userpower,rightcontent) VALUES (?,?,?,?,?)";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{user.getUserName(),user.getLoginName(),MD5Util.encode(user.getPassWord()),user.getUserPower(),user.getRightContent()});
    }

    @Override
    public List<User>  getUserList(){
        List userList = new ArrayList();
        String sql = "SELECT * from users";
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
        String sql = "UPDATE users set username=?,loginname=?,password=?,userpower=?,rightContent=? where id=?";
        JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{user.getUserName(),user.getLoginName(),MD5Util.encode(user.getPassWord()),user.getUserPower(),user.getRightContent(),user.getId()});

    }

    @Override
    public User getUserByName(String userName) throws IndexOutOfBoundsException{
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * from users where username='" + userName +"'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql,new UserRowMapper());
        try{
            return userList.get(0);
        }catch (IndexOutOfBoundsException ex)
        {
            return null;
        }
    }
    @Override
    public User getUserById(int id) throws IndexOutOfBoundsException{
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * FROM users WHERE id=" + id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql,new UserRowMapper());
        try{
            return userList.get(0);
        }catch (IndexOutOfBoundsException ex)
        {
            return null;
        }
    }
    @Override
    public User getUserByLoginName(String loginName) throws IndexOutOfBoundsException{
        List<User> userList = new ArrayList<User>();
        String sql = "SELECT * from users where loginname='" + loginName +"'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userList = jdbcTemplate.query(sql,new UserRowMapper());
        try{
            return userList.get(0);
        }catch (IndexOutOfBoundsException ex)
        {
            return null;
        }

    }
    @Override
    public Boolean checkUserPass(User user){
        String sql = "SELECT * FROM users WHERE loginname='" + user.getLoginName() + "' AND password='" + MD5Util.encode(user.getPassWord()) +"'";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        List<User> userList = new ArrayList<User>();
        userList = jdbcTemplate.query(sql,new UserRowMapper());
        if (userList.size()>0){
            return true;
        }
        return false;
    }
}
