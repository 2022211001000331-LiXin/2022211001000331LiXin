package com.lixin.week6.homework;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RedirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("before redirect");

        //response.sendRedirect("index.jsp");
        //http://localhost:8080/2022211001000331_Lixin_war_exploded/redirect
        //change to
        //http://localhost:8080/2022211001000331_Lixin_war_exploded/index.jsp
        // only last part of url change

        System.out.println("after redirect");

        //response.sendRedirect("/2022211001000331_Lixin_war_exploded/index.jsp");
        //http://localhost:8080/2022211001000331_Lixin_war_exploded/redirect
        //change to
        //http://localhost:8080/index.jsp
        //url change after localhost:8080
        //or can use response.sendRedirect("/2022211001000331_Lixin_war_exploded/index.jsp");

        response.sendRedirect("http://www.baidu.com");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
