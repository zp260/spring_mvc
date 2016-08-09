package com.wt.dao;

import com.wt.jdbc.StageRowMapper;
import com.wt.model.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import com.wt.controller.BaseController;

/**
 * Created by mrz on 16/7/20.
 */
public class StageDaoImpl extends BaseController implements StageDao {
    @Autowired
    DataSource dataSource;



    @Override
    public void insert(Stage stage){
        String sqlstr= setInsertSql(stage,"stage","id");
        System.out.println(sqlstr);
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        try {
            Object ob = setInsertObj(stage,"id");
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Object[] ob = new Object[50];


        jdbcTemplate.update(sqlstr,new Object[]{
                stage.getConSN(),
                stage.getStageNum(),
                Str2Date(stage.getGoodsArriveCoalDate()),
                Str2Date(stage.getGoodsSendETime()),
                Str2Date(stage.getGoodsSendATime()),
                Str2Date(stage.getGoodsArriveETime()),
                Str2Date(stage.getGoodsArriveATime()),
                Str2Date(stage.getEbDate()),
                Str2Date(stage.getBankNoticeBillTime()),
                Str2Date(stage.getBillTime()),
                Str2Date(stage.getBillToCustomsDate()),
                stage.getCdSN(),
                stage.getCdPdf(),
                Str2Date(stage.getCdTime()),
                stage.getCdPrice(),
                Str2Date(stage.getPortDate()),
                stage.getPort(),
                stage.getGetDocPdf(),
                stage.getInvoicePdf(),
                stage.getCoPdf(),
                stage.getBoxDocPdf(),
                stage.getTaxDate(),
                stage.getTariffs(),
                stage.getTariffsPdf(),
                stage.getVat(),
                stage.getVatPdf(),
                stage.getSpecialTariff(),
                stage.getSpecialTariffPdf(),
                stage.getPaytax(),
                stage.getLateFee(),
                stage.getInspectionSN(),
                stage.getInspectionPdf(),
                Str2Date(stage.getInspectionTime()),
                Str2Date(stage.getPassTime()),
                Str2Date(stage.getContainerCheckTime()),
                stage.getInspectionCharges(),
                stage.getFumigationCharges(),
                Str2Date(stage.getOpenContainerTime()),
                stage.getOpenContainerResoult(),
                Str2Date(stage.getFhApproveBillTime()),
                stage.getFhReason(),
                stage.getFhPrice(),
                stage.getFhMoneySeed(),
                stage.getFhMoneyExchange(),
                stage.getFhRMBprice(),
                stage.getFhRMBexchange(),
                stage.getFhDollarPrice(),
                stage.getFhDollarExchange(),
                Str2Date(stage.getBankFHtime()),
                Str2Date(stage.getGetFHtime())
        });



    }
    @Override
    public void update(Stage stage){

        String sql = "UPDATE stage SET conSN=?," +
                "        stageNum=?," +
                "        goodsArriveCoalDate=?," +
                "        goodsSendETime=?," +
                "        goodsSendATime=?," +
                "        goodsArriveETime=?," +
                "        goodsArriveATime=?," +
                "        ebDate=?," +
                "        bankNoticeBillTime=?," +
                "        billTime=?," +
                "        billToCustomsDate=?," +
                "        cdSN=?," +
                "        cdPdf=?," +
                "        cdTime=?," +
                "        cdPrice=?," +
                "        portDate=?," +
                "        port=?," +
                "        getDocPdf=?," +
                "        invoicePdf=?," +
                "        coPdf=?," +
                "        boxDocPdf=?," +
                "        taxDate=?," +
                "        tariffs=?," +
                "        tariffsPdf=?," +
                "        vat=?," +
                "        vatPdf=?," +
                "        specialTariff=?," +
                "        specialTariffPdf=?," +
                "        paytax=?," +
                "        lateFee=?," +
                "        inspectionSN=?," +
                "        inspectionPdf=?," +
                "        inspectionTime=?," +
                "        passTime=?," +
                "        containerCheckTime=?," +
                "        inspectionCharges=?," +
                "        fumigationCharges=?," +
                "        openContainerTime=?," +
                "        openContainerResoult=?," +
                "        fhApproveBillTime=?," +
                "        fhReason=?," +
                "        fhPrice=?," +
                "        fhMoneySeed=?," +
                "        fhMoneyExchange=?," +
                "        fhRMBprice=?," +
                "        fhRMBexchange=?," +
                "        fhDollarPrice=?," +
                "        fhDollarExchange=?," +
                "        bankFHtime=?," +
                "        getFHtime=?" +
                "        WHERE id= ?";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql,new Object[]{
                stage.getConSN(),
                stage.getStageNum(),
                stage.getGoodsArriveCoalDate(),
                stage.getGoodsSendETime(),
                stage.getGoodsSendATime(),
                stage.getGoodsArriveETime(),
                stage.getGoodsArriveATime(),
                stage.getEbDate(),
                stage.getBankNoticeBillTime(),
                stage.getBillTime(),
                stage.getBillToCustomsDate(),
                stage.getCdSN(),
                stage.getCdPdf(),
                stage.getCdTime(),
                stage.getCdPrice(),
                stage.getPortDate(),
                stage.getPort(),
                stage.getGetDocPdf(),
                stage.getInvoicePdf(),
                stage.getCoPdf(),
                stage.getBoxDocPdf(),
                stage.getTaxDate(),
                stage.getTariffs(),
                stage.getTariffsPdf(),
                stage.getVat(),
                stage.getVatPdf(),
                stage.getSpecialTariff(),
                stage.getSpecialTariffPdf(),
                stage.getPaytax(),
                stage.getLateFee(),
                stage.getInspectionSN(),
                stage.getInspectionPdf(),
                stage.getInspectionTime(),
                stage.getPassTime(),
                stage.getContainerCheckTime(),
                stage.getInspectionCharges(),
                stage.getFumigationCharges(),
                stage.getOpenContainerTime(),
                stage.getOpenContainerResoult(),
                stage.getFhApproveBillTime(),
                stage.getFhReason(),
                stage.getFhPrice(),
                stage.getFhMoneySeed(),
                stage.getFhMoneyExchange(),
                stage.getFhRMBprice(),
                stage.getFhRMBexchange(),
                stage.getFhDollarPrice(),
                stage.getFhDollarExchange(),
                stage.getBankFHtime(),
                stage.getGetFHtime(),
                stage.getId()
        });

    }
    @Override
    public void delete(int id){
        String sql = "DELETE FROM stage WHERE id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql);
    }
    @Override
    public List<Stage> getStageList(){
        List<Stage> stageList= new ArrayList<Stage>();
        String sql = "SELECT * FROM stage";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        stageList = jdbcTemplate.query(sql,new StageRowMapper());
        return  stageList;


    }
    @Override
    public Stage getStageById(int id){
        List<Stage> stageList = new ArrayList<Stage>();
        String sql = "SELECT * FROM stage where id="+id;
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        stageList = jdbcTemplate.query(sql,new StageRowMapper());
        return  stageList.get(0);

    }
}
