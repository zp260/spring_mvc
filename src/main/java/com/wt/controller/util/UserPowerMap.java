package com.wt.controller.util;

import com.wt.auth.AuthorityType;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrz on 16/8/18.
 */
public class UserPowerMap {
    /**
     * powerMap        预置权限选项
     * powerListMap    权限列表
     */
    private Map<Integer,Object> powerMap=new HashMap<Integer, Object>();
    private Map<Integer,String> powerListMap=new HashMap<Integer, String>();



    public UserPowerMap(){
        this.powerMap.put(0,"查询员");
        this.powerMap.put(1,"录入员");
        this.powerMap.put(2,"审核员");
        this.powerMap.put(3,"管理员");
        this.powerMap.put(4,"会计");
        this.powerMap.put(5,"总经理");

        for (AuthorityType authorityType : AuthorityType.values()){
            powerListMap.put(authorityType.getIndex(),authorityType.getName());
        }
    }

    public Map<Integer, Object> getPowerMap() {
        return powerMap;
    }
    public Map<Integer, String> getPowerListMap() {
        return powerListMap;
    }
}
