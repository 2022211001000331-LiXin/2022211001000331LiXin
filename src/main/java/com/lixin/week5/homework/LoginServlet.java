package com.lixin.week5.homework;

import com.lixin.dao.UserDao;
import com.lixin.model.User;

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
        //doPost(request, response);

        request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out= response.getWriter();
        String username=request.getParameter("username");
        String password=request.getParameter("password");
       // String email=request.getParameter("email");
        //String gender=request.getParameter("gender");
        //String birthdate=request.getParameter("birthday");


        //write mvc code
        //use model and dao
        UserDao userDao=new UserDao();
        try {
            User user=userDao.findByUsernamePassword(con,username,password);//this method use for login
            if(user!=null){//login success

                //create cookies - 3 steps
                //step 1 - create
                //Cookie c=new Cookie("sessionid",""+user.getId());
                //step 2 - set max age
                //c.setMaxAge(5*60);//second秒
                //step 3 - send back to client
                //response.addCookie(c);

                //add code for remember me
                String rememberMe=request.getParameter("rememberMe");
                if(rememberMe!=null && rememberMe.equals("1")){
                    //create 3 cookies
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);
                    //set age
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    //add cookies into response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }

                //create session -- week 8
                HttpSession session=request.getSession();
                System.out.println("Session id-->"+session.getId());
                //set age 20 min
                session.setMaxInactiveInterval(60*20);//second秒
                //kill the session right now
                //session.invalidate();//use for logout


                session.setAttribute("user",user);//get user info in jsp -- 'request.setAttribute()' is just for one jsp -- session.setAttribute() for many jsp
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else{
                request.setAttribute("massage","username or password error!!!");
                request.getRequestDispatcher("WEB-INF/views/Login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




        /*try{
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
*/
    }
}
