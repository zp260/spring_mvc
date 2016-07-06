package com.wt.jdbc;

import com.wt.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/7/1.
 */
public class UserRowMapper implements RowMapper<User> {
    @Override
    public  User mapRow(ResultSet resultSet,int line) throws SQLException{
        UserExtractor userExtractor = new UserExtractor();
        return userExtractor.extractData(resultSet);
    }

}
