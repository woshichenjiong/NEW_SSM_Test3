package com.gonmao.service;

import com.gonmao.bean.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Author:陈炯
 * @Date：2020/2/1915:32
 */
public interface IUserInfoService extends UserDetailsService {

  UserInfo doLogin(String username);

//  分页查询
  List<UserInfo> findAll(Integer page,Integer size);

  void addUser(UserInfo userInfo);

  void delUserById(int id);

//  void updateUser(UserInfo userInfo);

  UserInfo updSelUserInfoById(int id);

  void updUserInfo(UserInfo userInfo);
}

