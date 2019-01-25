package com.bootdo.system.dao;

/**
 * Created by yuantousanfen on 2019/1/25.
 */
public class UserDao {
    private UserDao userDao=new UserDao();
    private String pwdOld;
    private String pwdNew;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public String getPwdOld() {
        return pwdOld;
    }

    public void setPwdOld(String pwdOld) {
        this.pwdOld = pwdOld;
    }

    public String getPwdNew() {
        return pwdNew;
    }

    public void setPwdNew(String pwdNew) {
        this.pwdNew = pwdNew;
    }
}
