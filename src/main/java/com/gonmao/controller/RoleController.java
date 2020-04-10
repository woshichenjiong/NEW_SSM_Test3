package com.gonmao.controller;

import com.github.pagehelper.PageInfo;
import com.gonmao.bean.Role;
import com.gonmao.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Author:陈炯
 * @Date：2020/3/315:03
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService iRoleService;

    @RequestMapping("/findAllRole.do")
    public ModelAndView findAllRole(@RequestParam(defaultValue = "1") Integer page,
                                    @RequestParam(defaultValue = "5") Integer size){
        List<Role> allRole = iRoleService.findAllRole(page, size);
        //创建出分页的内置对象，将查询到的List数据传到对象中
        PageInfo pageInfo = new PageInfo(allRole);
//        pageInfo.setList(allRole) 与上面相同;
        ModelAndView mv = new ModelAndView();
        mv.addObject("pageInfo",pageInfo);
        mv.setViewName("role-details");
        mv.setViewName("role-list");

        return mv;
    }
    //沙雕方法 ，通过查询id实现数据详情
    @RequestMapping("/detailsRole.do")
    public ModelAndView detailsRole(Role role){
        Role roleById = iRoleService.findRoleById(role.getRid());
        ModelAndView mv = new ModelAndView();
        mv.addObject("roleById",roleById);
        mv.setViewName("role-details");
        return mv;
    }


    //增加角色功能
    @RequestMapping("/addRole.do")
    public String addRole(Role role){
        iRoleService.addRole(role);
        return "redirect:findAllRole.do";
    }

    //删除角色
    @RequestMapping("/delRoleById.do")
    public String delRoleById(int rid){

        iRoleService.delRoleById(rid);
        return "redirect:findAllRole.do";
    }

}
