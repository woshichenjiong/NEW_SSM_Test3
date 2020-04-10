package com.gonmao.service.impl;

import com.github.pagehelper.PageHelper;
import com.gonmao.bean.Role;
import com.gonmao.bean.UserInfo;
import com.gonmao.dao.IRoleDao;
import com.gonmao.dao.IUserInfoDao;
import com.gonmao.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @Author:陈炯
 * @Date：2020/2/1915:34
 */
@Service("userService")
@Repository
public class UserInfoServiceImpl implements IUserInfoService {

//    如果使用Resource进行注入，那必须制定当前对象名 例如：@Resource(name="xxx)

    @Autowired
    private IUserInfoDao userInfoDao;

    @Autowired
    private IRoleDao roleDao;

    @Override
    public UserInfo doLogin(String username) {
        return userInfoDao.doLogin(username);
    }

    @Override
    public List<UserInfo> findAll(Integer page, Integer size) {
        //设置分页数据
        PageHelper.startPage(page,size);
        return userInfoDao.findAll();
    }

    @Override
    public void addUser(UserInfo userInfo) {
        userInfoDao.addUser(userInfo);
    }

    @Override
    public void delUserById(int id) {
        userInfoDao.delUserById(id);
    }

    /*@Override
    public void updateUser(UserInfo userInfo) {
        userInfoDao.updateUser(userInfo);
    }
*/
    @Override
    public UserInfo updSelUserInfoById(int id) {
        return userInfoDao.updSelUserInfoById(id);
    }

    @Override
    public void updUserInfo(UserInfo userInfo) {
        userInfoDao.updUserInfo(userInfo);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 根据username得到当前登录的用户信息
        UserInfo userInfo = userInfoDao.doLogin(username);
        //使用得到的用户信息的id传入findRoleByUserId的方法中作为查找参数
        List<Role> roleList = roleDao.findRoleByUserId(userInfo.getId());
//        userInfo.setRoleList(roleList);
        userInfo.setRoleList(roleList);
        // 得到想要的信息之后，就要交给spring security处理   {noop}是解码密码，因为密码被securuty加密了
        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(roleList));


        return user;
    }

    private Collection<? extends GrantedAuthority> getAuthority(List<Role> roleList) {
        List<SimpleGrantedAuthority> list = new ArrayList<SimpleGrantedAuthority>();
        // 传入新创建对象且需要拼接的role名
        for (Role role:roleList) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRname()));
        }
        return list;
    }
}
