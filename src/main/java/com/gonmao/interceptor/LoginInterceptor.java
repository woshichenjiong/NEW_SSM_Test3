package com.gonmao.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Author:陈炯
 * @Date：2020/3/29:47
 */
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //在拦截点进行拦截，如果返回的true则不执行拦截点后的操作（拦截成功）
        //1、判断当前的User用户不为空,判断当前的uri不为空且获取当前的登录方法
        HttpSession session = request.getSession();
        /*String url = request.getRequestURI();
        System.out.println("接收的action为："+url);*/
        if (session.getAttribute("userInfo") !=null){
            return true;
        }else{

            //进行拦截，返回登录页面,使用response请求转发方法
            response.sendRedirect(request.getContextPath()+"/user/doLogin.do");
            return false;

        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        //在处理中，拦截执行

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //执行完毕，返回前拦截
    }
}
