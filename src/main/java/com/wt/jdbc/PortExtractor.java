package com.wt.jdbc;

import com.wt.model.Port;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/7/8.
 */
public class PortExtractor implements ResultSetExtractor<Port> {
    public Port extractData(ResultSet resultSet) throws SQLException,DataAccessException {
        Port port = new Port();
        port.setId(resultSet.getInt("id"));
        port.setPortName(resultSet.getString("portName"));
        port.setOrders(resultSet.getInt("orders"));
        return port;
    }
}
