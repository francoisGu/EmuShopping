package com.litaos.model;

import java.io.Serializable;

/**
 * Created by litaoshen on 9/09/2015.
 */
public class User implements Serializable{

    static final long serialVersionUID = 1L;

    public final static String BUYER = "buyer";
    public final static String SELLER = "seller";

    private int userId;

    private String username;
    private String password;
    private String type;


    public User() {
    }

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.type = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
