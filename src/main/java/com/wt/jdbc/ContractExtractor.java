package com.wt.jdbc;

import com.wt.model.Contract;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by mrz on 16/7/14.
 */
public class ContractExtractor implements ResultSetExtractor<Contract>{
    public Contract extractData(ResultSet resultSet) throws SQLException, DataAccessException{
        Contract contract = new Contract();
        contract.setId(resultSet.getInt("id"));
        contract.setConSN(resultSet.getString("conSN"));
        contract.setConDate(resultSet.getString("conDate"));
        contract.setIsInport(resultSet.getBoolean("isInPort"));
        contract.setConVerify(resultSet.getBoolean("conVerify"));
        contract.setUseORG(resultSet.getString("useORG"));
        contract.setSupplier(resultSet.getString("supplier"));
        contract.setBiddingSN(resultSet.getString("biddingSN"));
        contract.setConPrice(resultSet.getBigDecimal("conPrice"));
        contract.setAtDoller(resultSet.getBigDecimal("atDoller"));
        contract.setAtRMB(resultSet.getBigDecimal("atRMB"));
        contract.setLcSN(resultSet.getString("lcSN"));
        contract.setLcTimeLimit(resultSet.getString("lcTimeLimit"));
        contract.setLcFrom(resultSet.getString("lcFrom"));
        contract.setLcPrice(resultSet.getBigDecimal("lcPrice"));
        contract.setLcStartDate(resultSet.getString("lcStartDate"));
        contract.setLcChangeDate(resultSet.getString("lcChangeDate"));
        contract.setLcChangeReason(resultSet.getString("lcChangeReason"));
        contract.setDeliveryDate(resultSet.getString("deliveryDate"));
        contract.setConFrom(resultSet.getString("conFrom"));
        return contract;
    }
}
