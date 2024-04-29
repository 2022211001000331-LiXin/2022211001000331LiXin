package com.lixin.week2.homework;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HelloWorldServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException {
        PrintWriter writer=response.getWriter();
        writer.println("Name:Li Xin");
        writer.println("ID:2022211001000331");
        writer.println("Date and Time:"+new Date());

        System.out.println("i am in HelloServlet--inside doget()");
        //go back to HelloFilter
    }
    public void doPost(HttpServletRequest request,HttpServletResponse response){

    }
}
