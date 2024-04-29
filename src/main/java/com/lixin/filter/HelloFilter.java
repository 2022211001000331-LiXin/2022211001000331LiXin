package com.lixin.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//filter is a java class
@WebFilter(
        urlPatterns = {"/register","/jdbc"}//for many but not all
)
public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("i am in HelloFilter-->init()");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        //when client send a request for servlet,request first come here before go to servlet
        System.out.println("i am in HelloFilter-->dofilter()--before request go to servlet");
        filterChain.doFilter(servletRequest,servletResponse);//link with next filter
        // if no next filter--go to servlet
        System.out.println("i am in HelloFilter--response come back here--after servlet");

    }

    @Override
    public void destroy() {

    }
}
