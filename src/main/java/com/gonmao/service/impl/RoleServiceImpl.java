package com.gonmao.service.impl;

import com.github.pagehelper.PageHelper;
import com.gonmao.bean.Role;
import com.gonmao.dao.IRoleDao;
import com.gonmao.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author:陈炯
 * @Date：2020/3/314:57
 */
@Service
public class RoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao iRoleDao;

    @Override
    public List<Role> findAllRole(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return  iRoleDao.findAllRole() ;
    }

    @Override
    public void addRole(Role role) {
        iRoleDao.addRole(role);
    }

    @Override
    public void delRoleById(int rid) {
        iRoleDao.delRoleById(rid);
    }

    @Override
    public Role findRoleById(int rid) {
        return  iRoleDao.findRoleById(rid);
    }

}
