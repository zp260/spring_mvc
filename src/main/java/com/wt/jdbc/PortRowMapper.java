package com.wt.jdbc;

import com.wt.model.Port;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/7/8.
 */
public class PortRowMapper implements RowMapper<Port> {
    @Override

    public Port mapRow(ResultSet resultSet,int line) throws SQLException{
            PortExtractor portExtractor = new PortExtractor();
            return portExtractor.extractData(resultSet);
    }
}
