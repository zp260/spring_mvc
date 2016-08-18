package com.wt.services;

import com.wt.model.User;

import java.util.List;

/**
 * Created by mrz on 16/7/1.
 */
public interface UserService {
    public void insertData(User user);
    public List<User> getUserList();
    public void deleteData(int id);
    public User getUserByName(String username);
    public User getUserByLoginName(String loginName);
    public User getUserById(int id);
    public  void updateData(User user);
    public Boolean checkUserPass(User user);
    public Boolean checkUserExist(User user);
}
