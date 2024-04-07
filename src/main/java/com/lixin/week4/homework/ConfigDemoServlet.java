package com.lixin.week4.homework;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        urlPatterns = {"/config"},
        initParams = {
                @WebInitParam(name = "name", value = "LiXin"),
                @WebInitParam(name = "StudentID", value = "2022211001000331")
        }
)
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletConfig config=getServletConfig();
        String name=config.getInitParameter("name");
        String StudentID=config.getInitParameter("StudentID");
        PrintWriter writer= response.getWriter();
        writer.println("<h1>" +"Task 1-Get init parameters from web.xml"+ "</h1>");
        writer.println("<br>name:"+name);
        writer.println("<br>StudentID:"+StudentID);
        writer.println("<h1>" +"Task 2-Get init parameters from @WebServlet"+ "</h1>");
        writer.println("<br>name:"+name);
        writer.println("<br>StudentID:"+StudentID);
        writer.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
