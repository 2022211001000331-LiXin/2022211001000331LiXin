package com.lixin.week5.homework;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(urlPatterns ={"/login"})
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException {
        super.init();

        /*ServletContext config=getServletContext();
        String driver=config.getInitParameter("driver");
        String url=config.getInitParameter("url");
        String username=config.getInitParameter("username");
        String password=config.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("init()--> "+con);
        }catch(ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }*/

        con= (Connection) getServletContext().getAttribute("con");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out= response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
       // String email=request.getParameter("email");
        //String gender=request.getParameter("gender");
        //String birthdate=request.getParameter("birthday");

        try{
            Statement st=con.createStatement();
           // String sql="insert into usertable(username,password,email,gender,birthdate)"+
                    //" values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
            //System.out.println("sql"+sql);
            //int n=st.executeUpdate(sql);
            //System.out.println("n-->"+n);

            String sql="select username,password,email,gender,birthdate from usertable where username='"+username+"' and password='"+password+"'";
            ResultSet rs=st.executeQuery(sql);

            if(rs.next()){
                //out.println("<h1>"+"Login Success!!!"+"</h1>");
                //out.println("<h1>"+"Welcome,"+username+"</h1>");

                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthdate"));

                request.getRequestDispatcher("userInfo.jsp").forward(request,response);

            }else{
                request.setAttribute("massage","username or password error!!!");
                request.getRequestDispatcher("Login.jsp").forward(request,response);

                //out.println("username or password error!!!");
            }


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
