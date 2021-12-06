package com.syt.Entity;

public class User {
    private String userRight;
    private String userName;
    private String userPassword;

    public User( String userRight, String userName, String userPassword) {
        this.userRight = userRight;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User() {

    }

    public String getUserRight() {
        return userRight;
    }

    public void setUserRight(String userRight) {
        this.userRight = userRight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
