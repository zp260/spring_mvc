package com.wt.model;

import java.io.Serializable;

/**
 * Created by mrz on 16/7/1.
 */
public class User implements Serializable{

    private int id;

    private String userName;

    private String loginName;

    private String passWord;

    private String userPower;

    /**
     * 权限字段
     * 每一位表示一种权限
     */
    private String rightContent="00000000000100";//初始权限智能看合同

    private static final long serialVersionUID = 8538631258084019523L;

    public String getUserName(){
        return userName;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getLoginName(){
        return loginName;
    }
    public void setLoginName(String loginName){
        this.loginName = loginName;
    }

    public String getPassWord(){
        return passWord;
    }
    public void setPassWord(String passWord){
        this.passWord = passWord;
    }

    public String getUserPower(){
        return userPower;
    }
    public void setUserPower(String userPower){
        this.userPower=userPower;
    }

    public int getId(){
        return id;
    }

    public void setId(int userId){this.id = userId;}

    public String getRightContent() {
        return rightContent;
    }

    public void setRightContent(String rightContent) {
        this.rightContent = rightContent;
    }

}
