package com.XiaoShuhui.week3.demo;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class RegisterServlet extends HttpServlet {
    Connection con = null;
    public void init(){
        ServletContext context =getServletContext();
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
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("register serlvet doGet");
        response.sendRedirect("./register.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("register servlet dopost");
        PrintWriter writer = response.getWriter();
        String username = request.getParameter("username");//name of input type
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String birthDate = request.getParameter("birthDate");
        System.out.println(username);
        System.out.println(password);
        System.out.println(email);
        System.out.println(gender);
        System.out.println(birthDate);

        try {
            String sql = "insert into usertable(username,password,email,gender,birthDate) values(\'"+username+"\',\'"
                    +password+"\',\'"+email+"\',\'"+gender+"\',\'"+birthDate+"\')";
            // insert data into database
            con.setAutoCommit(false);
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.executeUpdate();
            con.commit();
            System.out.println("insert successfully");
            // select all rows from usertable
            sql = "select * from usertable";
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            writer.println("<table border=\"1\">");
            writer.println("<tr>");
            writer.println("<th>ID</th>");
            writer.println("<th>username</th>");
            writer.println("<th>password</th>");
            writer.println("<th>email</th>");
            writer.println("<th>gender</th>");
            writer.println("<th>birthDate</th>");
            writer.println("</tr>");
            while (resultSet.next()) {
                writer.println("<tr>");
                writer.println("<td>"+resultSet.getString("id")+"</td>");
                writer.println("<td>"+resultSet.getString("username")+"</td>");
                writer.println("<td>"+resultSet.getString("password")+"</td>");
                writer.println("<td>"+ resultSet.getString("email")+"</td>");
                writer.println("<td>"+resultSet.getString("gender")+"</td>");
                writer.println("<td>"+ resultSet.getString("birthDate")+"</td>");
                writer.println("<tr>");
            }
            writer.println("</table>");
            con.commit();

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {
        super.destroy();
        //close connection here - when stop tomcat
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
