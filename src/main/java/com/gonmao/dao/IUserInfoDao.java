package com.gonmao.dao;

import com.gonmao.bean.UserInfo;

import java.util.List;


/**
 * @Author:陈炯
 * @Date：2020/2/1914:43
 */
public interface IUserInfoDao {

    //验证登录 查询Select
    UserInfo doLogin(String username);

    //全部查询
    List<UserInfo> findAll();

    //增加用户
    void addUser(UserInfo userInfo);

    //删除用户
    void delUserById(int id);

    /*//更新用户
    void updateUser(UserInfo userInfo);*/

//    修改前的查询
    UserInfo updSelUserInfoById(int id);

    // 修改
    void updUserInfo(UserInfo userInfo);




}
