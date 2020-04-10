package com.gonmao.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @Author:陈炯
 * @Date：2020/3/210:27
 */
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        //过滤器出生

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // servletRequest是接口，HTTPServletRequest是实现，但是有些方法是HTTPServletRequest独有的，比如getSession
        // HTTPServletRequest 接口是继承自servletRequest接口，增加了和HTTP相关的方法

        //强转得到想要的request和response
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        //获取session
        HttpSession session = request.getSession();
        if (session.getAttribute("userInfo")==null && request.getRequestURI().indexOf("/user/doLogin.do") ==-1){
            // 没有登录
            response.sendRedirect(request.getContextPath() + "/user/doLogin.do");

        }else{
            //已经登录，继续下一个请求（继续访问）
            filterChain.doFilter(request,response);

        }

    }

    @Override
    public void destroy() {

        //过滤器消亡

    }
}
