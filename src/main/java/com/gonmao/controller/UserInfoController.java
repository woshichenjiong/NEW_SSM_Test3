package com.gonmao.controller;

import com.github.pagehelper.PageInfo;
import com.gonmao.bean.UserInfo;
import com.gonmao.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author:陈炯
 * @Date：2020/2/1916:17
 */
@Controller
@RequestMapping("user")
public class UserInfoController {

    @Qualifier("userService")
    @Autowired
    private IUserInfoService userInfoService;

    /*@RequestMapping("/doLogin.do")
    public String doLogin(String username, HttpSession session, String password, Model model) {
        //调用service层方法，进行查询
        UserInfo userInfo = userInfoService.doLogin(username);

        //判断
        if (userInfo != null) {
            if (userInfo.getPassword().equals(password)) {
//                model.addAttribute("success",userInfo);
                session.setAttribute("userInfo",userInfo);
                System.out.println("密码正确，登陆成功！");
                return "main";
            } else {
//                model.addAttribute("error","用户名或密码错误");
                session.setAttribute("error","用户名或密码错误");
                System.out.println("密码错误，登陆失败");

                return "../login";
            }
        } else {
            model.addAttribute("error","用户名不存在");
            System.out.println("用户不存在，请重新输入");
            return "../login";
        }
    }*/


    //全部查询
    //所有需要返回数据的页面显示的，全部都是要封装到ModelAndView里面
    // page代表页面 size代表每页数据的多少
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "5") Integer size){
        //调用service中的方法，得到查询结果
        List<UserInfo> userInfoList = userInfoService.findAll(page,size);
        // 把得到的数据存放到 PageInfo中
        PageInfo pageInfo = new PageInfo(userInfoList);

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pageInfo",pageInfo);
        modelAndView.setViewName("user-list");

        return modelAndView;
    }

    //增加用户
    @RequestMapping("/addUser.do")
    public String addUser(UserInfo userInfo){

        //调用service，得到结果
        userInfoService.addUser(userInfo);

        //增加成功之后重定向到，显示当前所有用户的页面
        return "redirect:findAll.do";
    }

    //删除用户
    @RequestMapping("/delUserById.do")
    public String delUserById(int id){

        userInfoService.delUserById(id);
        System.out.println("删除成功");
        //删除成功后 重定向到findAll.do
        return "redirect:findAll.do";

    }

    /*//更新用户
    @RequestMapping("/updateUser.do")
    public String updateUser(UserInfo userInfo){
        userInfoService.updateUser(userInfo);
        return "redirect:findAll.do";
    }*/

    // 修改前的查询
    @RequestMapping("/updSelUserById.do")
    public ModelAndView updSelUserById(int id){

        UserInfo userInfo = userInfoService.updSelUserInfoById(id);
        ModelAndView mav = new ModelAndView();
        mav.addObject("userInfo",userInfo);
        mav.setViewName("user-update");
        return mav;
    }

    // 修改
    @RequestMapping("updUserInfo.do")
    public String updUserInfo(UserInfo userInfo){

        userInfoService.updUserInfo(userInfo);
        System.out.println("修改成功");
//        如果使用findAll()是表示请求转发，数据库改变，页面数据不变
        return "redirect:findAll.do";
    }

    //注销用户
    @RequestMapping("outUser.do")
    public String outUser(HttpSession session){
        session.removeAttribute("userInfo");
        //注销成功
        return "redirect:doLogin.do";
    }
}
