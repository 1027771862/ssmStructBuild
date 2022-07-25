package com.hao.config;

import com.mysql.cj.Session;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

//登录拦截器
public class MyLoginHandlerInterceptor implements HandlerInterceptor {
    //return true放行，false拦截
    //preHandle，postHandle，afterHandle请求前，请求时，请求后
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("请求处理前==========拦截器只会拦截控制器的方法，如果访问的是jsp/html/css/image是不会拦截的");
        //进行判断放行拦截
        HttpSession session= request.getSession();
        System.out.println(request.getRequestURI());
        if(request.getRequestURI().contains("login")){
            return true;
        }else if(session.getAttribute("userLoginInfo")!=null){
            return true;
        }
        return false;
    }

    //下俩一般写入日志
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求处理时==========拦截器只会拦截控制器的方法，如果访问的是jsp/html/css/image是不会拦截的");
        System.out.println(new Date());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("请求处理后==========拦截器只会拦截控制器的方法，如果访问的是jsp/html/css/image是不会拦截的");
        System.out.println(new Date());
    }
}
