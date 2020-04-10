package com.gonmao.bean;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Author:陈炯
 * @Date：2020/2/1914:33
 */
public class UserInfo {

    private int id;
    private String username;
    private String password;
    private List<Role> roleList;
    public UserInfo() {
    }

    public UserInfo(int id, String name, String password) {
        this.id = id;
        this.username = name;
        this.password = password;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
