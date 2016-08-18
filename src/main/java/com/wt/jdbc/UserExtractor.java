package com.wt.jdbc;

import com.wt.model.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/7/1.
 */
public class UserExtractor implements ResultSetExtractor<User> {
    public User extractData(ResultSet resultSet) throws SQLException,DataAccessException{
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("userName"));
        user.setLoginName(resultSet.getString("loginName"));
        user.setPassWord(resultSet.getString("passWord"));
        user.setUserPower(resultSet.getString("userPower"));
        user.setRightContent(resultSet.getString("rightContent"));
        return user;
    }
}
