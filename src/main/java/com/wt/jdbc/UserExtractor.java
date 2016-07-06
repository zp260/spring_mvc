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
        user.setId(resultSet.getInt(1));
        user.setUserName(resultSet.getString(2));
        user.setLoginName(resultSet.getString(3));
        user.setPassword(resultSet.getString(4));
        user.setUserPower(resultSet.getString(5));
        return user;
    }
}
