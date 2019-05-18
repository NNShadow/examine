package com.examine.model;

import org.springframework.web.bind.annotation.RequestParam;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(@RequestParam("username") String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(@RequestParam("password") String password) {
        this.password = password;
    }
}
