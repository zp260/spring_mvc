package com.wt.dao;

import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Created by mrz on 16/9/14.
 */
public interface DaoBase {
    /**
     * 根据字段单表查询
     * @param table             表名
     * @param filedName         字段名
     * @param value             字段值
     * @param rowMapper         对象的ROWMAPPER
     * @param callBackList      需要返回的对象list
     * @return                  对象LIST
     */
    public List select(String table, String filedName, String value, RowMapper rowMapper, List callBackList);

    /**
     *双表查询
     * @param table1        表名1
     * @param table2        表名2
     * @param filedName     字段名
     * @param value         字段值
     * @param rowMapper     对象的ROWMAPPER
     * @param callBackList  需要返回的对象list
     * @param condition     条件
     * @return              对象LIST
     */
    public List selectTwo(String table1,String table2, String filedName, String value, RowMapper rowMapper, List callBackList,String condition);

    /**
     * 根据时间段单表搜索
     * @param table         表名
     * @param filedName     字段名
     * @param startDate     开始时间
     * @param endDate       结束时间
     * @param rowMapper     对象的ROWMAPPER
     * @param callBackList  需要返回的对象list
     * @return              对象LIST
     */
    public List selectByDate(String table, String filedName, String startDate,String endDate, RowMapper rowMapper, List callBackList);
}
