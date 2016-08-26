package com.wt.controller.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mrz on 16/8/23.
 */
public class CallbackMap {
    private Map<String,Object> callBackMap = new HashMap<String, Object>();
    public CallbackMap(){
        callBackMap.put("info","");
        callBackMap.put("success",false);
        callBackMap.put("error","");
    }

    public Map<String, Object> getCallBackMap() {
        return callBackMap;
    }

    public void setCallBackMap(Map<String, Object> callBackMap) {
        this.callBackMap = callBackMap;
    }
}
