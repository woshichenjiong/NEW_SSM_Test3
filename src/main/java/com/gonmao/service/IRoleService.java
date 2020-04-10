package com.gonmao.service;

import com.gonmao.bean.Role;

import java.util.List;

/**
 * @Author:陈炯
 * @Date：2020/3/314:54
 *
 * 业务逻辑层
 */
public interface IRoleService {

    List<Role> findAllRole(Integer page,Integer size);
    void addRole(Role role);
    void delRoleById(int rid);
    Role findRoleById(int rid);

}
