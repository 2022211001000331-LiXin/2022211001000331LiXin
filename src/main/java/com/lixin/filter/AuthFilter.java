package com.lixin.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

//@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {

        System.out.println("i am in AuthFilter--before go to next filter"+System.currentTimeMillis());
        HttpServletRequest Request=(HttpServletRequest)request;
        System.out.println("getRequestURL-->"+Request.getRequestURL());
        System.out.println("getScheme-->"+Request.getScheme());//http
        System.out.println("getServerName-->"+Request.getServerName());//tomcat
        System.out.println("getServerPort-->"+Request.getServerPort());
        System.out.println("getRequestURI-->"+Request.getRequestURI());
        System.out.println("getServletPath-->"+Request.getServletPath());
        System.out.println("getQueryString-->"+Request.getQueryString());
        System.out.println("getMethod-->"+Request.getMethod());
        chain.doFilter(request, response);
        System.out.println("i am in AuthFilter-- response come back here");
    }
}
