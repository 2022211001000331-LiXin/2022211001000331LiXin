package com.lixin.week6.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(urlPatterns ={"/search"})
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt=request.getParameter("txt");
        String search=request.getParameter("search");
        if(txt==null){
            response.sendRedirect("index.jsp");
        }
        else{
            if(search=="baidu"){
                response.sendRedirect("http://www.baidu.com/");
            }
            else if(search=="bing"){
                response.sendRedirect("http://cn.bing.com");
            }
            else if(search=="google"){
                response.sendRedirect("http://www.google.com");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
