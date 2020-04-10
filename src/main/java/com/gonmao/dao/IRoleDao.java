package com.gonmao.dao;

import com.gonmao.bean.Role;

import java.util.List;

/**
 * @Author:陈炯
 * @Date：2020/3/314:49
 */
public interface IRoleDao {

    //查询全部角色
    List<Role> findAllRole();

    //角色增加
    void addRole(Role role);

    //角色删除
    void delRoleById(int rid);

    //查询角色通过rid
    Role findRoleById(int rid);

    List<Role> findRoleByUserId(int uid);
}
