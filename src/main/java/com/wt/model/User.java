package com.wt.model;

/**
 * Created by mrz on 16/7/1.
 */
public class User {

    private int id;

    private String userName;

    private String loginName;

    private String password;

    private String userPower;

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

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
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

}
