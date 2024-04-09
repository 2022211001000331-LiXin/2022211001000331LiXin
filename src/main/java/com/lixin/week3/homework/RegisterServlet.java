package com.lixin.week3.homework;

import javax.servlet.*;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;


@WebServlet(
        urlPatterns = {"/register"}
)
public class RegisterServlet extends HttpServlet {
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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String id=request.getParameter("id");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String gender=request.getParameter("gender");
        String birthdate=request.getParameter("birthday");

        try{
            Statement st=con.createStatement();
            String sql="insert into usertable(username,password,email,gender,birthdate)"+
                    "values('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthdate+"')";
            System.out.println("sql"+sql);
            int n=st.executeUpdate(sql);
            System.out.println("n-->"+n);

            //sql="select username,password,email,gender,birthdate from usertable";
            //ResultSet rs=st.executeQuery(sql);

            //PrintWriter writer= response.getWriter();
            /*writer.println("<html><body><table border='1'>");
            writer.println("<tr><td>"+"username"+"</td>");
            writer.println("<td>"+"password"+"</td>");
            writer.println("<td>"+"email"+"</td>");
            writer.println("<td>"+"gender"+"</td>");
            writer.println("<td>"+"birthdate"+"</td></tr>");
            while (rs.next()){
                writer.println("<tr><td>"+rs.getString("username")+"</td>");
                writer.println("<td>"+rs.getString("password")+"</td>");
                writer.println("<td>"+rs.getString("email")+"</td>");
                writer.println("<td>"+rs.getString("gender")+"</td>");
                writer.println("<td>"+rs.getString("birthdate")+"</td>");
                writer.println("</tr>");
            }
            writer.println("</table></body></html>");*/

            //request.setAttribute("rsname",rs);//(name,value)  name->String  value->any type(object)

            //request.getRequestDispatcher("userList.jsp").forward(request,response);
            //System.out.println("I am in RegisterServlet-->dopost()-->after forward()");//can not see this line
            response.sendRedirect("Login.jsp");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}