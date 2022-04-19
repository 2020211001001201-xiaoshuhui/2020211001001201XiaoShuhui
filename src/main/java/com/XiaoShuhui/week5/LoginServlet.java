package com.XiaoShuhui.week5;

import com.XiaoShuhui.dao.UserDao;
import com.XiaoShuhui.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException{
        super.init();
        /*ServletContext context =getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
            System.out.println("Connection --> in JDBCDemoServlet"+con);//just print for test
            //one connection -
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//doPost(request,response);
        //when user click login menu-request is get
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    PrintWriter writer = response.getWriter();
        try {
            UserDao userDao=new UserDao();
            User user=userDao.findByUsernamePassword(con,username,password);
            if(user!=null){
                //add code for remember me
                String rememberMe=request.getParameter("rememberMe");//1=checked,null if checked
                if(rememberMe!=null && rememberMe.equals("1")){
                    //want to remember me
                    // create 3 cookies
                    Cookie usernameCookie=new Cookie("cUsername",user.getUsername());
                    Cookie passwordCookie=new Cookie("cPassword",user.getPassword());
                    Cookie rememberMeCookie=new Cookie("cRememberMe",rememberMe);
                    //set age of cookies
                    usernameCookie.setMaxAge(5);
                    passwordCookie.setMaxAge(5);
                    rememberMeCookie.setMaxAge(5);
                    //add 3 cookies into response
                    response.addCookie(usernameCookie);
                    response.addCookie(passwordCookie);
                    response.addCookie(rememberMeCookie);
                }
                //create session
                HttpSession session=request.getSession();
                //check session id
                System.out.println("session id-->"+session.getId());
                session.setMaxInactiveInterval(10);
                //create cookie
                //step1:create an object of cookie class
                /*Cookie c=new Cookie("sessionid",""+user.getId());
                //step2 set age of cookie
                c.setMaxAge(10*60);
                //step3:add cookie into response
                //delete cookie
                Cookie cookie=new Cookie("sessionid","");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                response.addCookie(c);*/
                session.setAttribute("user",user);
                 request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }else {
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*try {
            String sql = "select * from usertable where username=? and password=?";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
                //writer.println("<h1>Login Success!!!</h1>");
                //writer.println("<h1>Welcome"+username+"</h1>");
                request.setAttribute("ID",rs.getInt("ID"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthDate",rs.getString("birthDate"));
                //forward to userInfo.jsp
                request.getRequestDispatcher("userInfo.jsp").forward(request,response);
            }
            else {
                //writer.println("<h1>Login Error!!!</h1>");
                request.setAttribute("message","Username or Password Error!!!");
                request.getRequestDispatcher("login.jsp").forward(request,response);
            }
            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }
}
