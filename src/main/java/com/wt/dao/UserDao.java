package com.wt.dao;

import com.wt.model.User;

import java.util.List;

/**
 * Created by mrz on 16/7/1.
 */
public interface UserDao {
    public void  insertData(User user);
    public List<User> getUserList();
    public  void deleteData(int id);
    public User getUserByName(String userName);
    public User getUserById(int id);
    public User getUserByLoginName(String loginName);
    public void updateData(User user);
    public Boolean checkUserPass(User user);//验证用户名密码
}
