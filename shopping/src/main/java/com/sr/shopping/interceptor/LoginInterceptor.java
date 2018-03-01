package com.sr.shopping.interceptor;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.AsyncHandlerInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("login interceptor: " + request.getServletPath());
        HttpSession session = request.getSession();
        Object loginFlag = session.getAttribute("loginFlag");
        if (loginFlag == null || (Integer)loginFlag == 0) {
            Object loginType = session.getAttribute("loginType");
            if (loginType != null && "admin".equalsIgnoreCase((String)loginType) || request.getServletPath().contains("admin")) {
                response.sendRedirect("/admin/login");
            }else {
                response.sendRedirect("/shopping/login");
            }
            return false;
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
