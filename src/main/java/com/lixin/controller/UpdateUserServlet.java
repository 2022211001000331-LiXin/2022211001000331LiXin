package com.lixin.controller;

import com.lixin.dao.UserDao;
import com.lixin.model.User;
import com.lixin.util.DateUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "UpdateUserServlet", value = "/updateuser")
public class UpdateUserServlet extends HttpServlet {

    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthday");

        User user = new User(Integer.valueOf(id), username, password, email, gender, Date.valueOf(birthdate));

        UserDao userDao = new UserDao();

        try {
            int i = userDao.updateUser(con, user);
            if (i == 1){
                HttpSession session=request.getSession();
                session.setMaxInactiveInterval(60*20);//second秒
                //kill the session right now
                //session.invalidate();//use for logout


                session.setAttribute("user",user);//get user info in jsp -- 'request.setAttribute()' is just for one jsp -- session.setAttribute() for many jsp
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);

            }
        } catch (SQLException throwables) {
            request.setAttribute("massage","username or password error!!!");
            request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request,response);
        }
    }
}
