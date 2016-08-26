package com.wt.services;

import com.wt.dao.UserDao;
import com.wt.model.User;
import com.wt.tools.MD5Util;
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
    public User getUserByName(String username){
        return userDao.getUserByName(username);
    }
    public User getUserByLoginName(String loginName){return userDao.getUserByLoginName(loginName);}
    @Override
    public User getUserById(int id){return  userDao.getUserById(id);}

    @Override
    public void updateInfo(User user){
        userDao.updateInfo(user);
    }
    public void updatePass(User user){ userDao.updatePass(user);}

    @Override
    public Boolean checkUserPass(User user){
        return  userDao.checkUserPass(user);
    }
    @Override
    public Boolean checkUserExist(User user){
        if (getUserByLoginName(user.getLoginName())!=null){ //登录名唯一，不返回空代表已存在登录名相关账户
            return false;
        }
        return true; //可以插入新账户
    }
}
