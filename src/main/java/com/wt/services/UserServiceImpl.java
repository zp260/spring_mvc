package com.wt.services;

import com.wt.dao.UserDao;
import com.wt.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by mrz on 16/7/1.
 */
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public void insertData(User user){
        userDao.insertData(user);
    }

    @Override
    public List<User> getUserList(){
        return userDao.getUserList();
    }

    @Override
    public  void deleteData(int id){
        userDao.deleteData(id);
    }

    @Override
    public User getUser(String username){
        return userDao.getUser(username);
    }
    @Override
    public User getUserById(int id){return  userDao.getUserById(id);}

    @Override
    public void updateData(User user){
        userDao.updateData(user);
    }
}
