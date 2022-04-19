package com.XiaoShuhui.week3;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
//@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
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
            System.out.println("init()-->"+con);//just print for test
            //one connection -
        } catch (Exception e) {
            e.printStackTrace();
        }*/
        con=(Connection) getServletContext().getAttribute("con");//name od attribute
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
        //System.out.println("register servlet doGet");
        //response.sendRedirect("./register.jsp");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //System.out.println("register servlet dopost");
        PrintWriter writer = response.getWriter();
        String id=request.getParameter("id");
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
/*            String sql="insert into usertable values(?,?,?,?,?,?)";
            PreparedStatement st= con.prepareStatement(sql);
            st.setString(1,id);
            st.setString(2,username);
            st.setString(3,password);
            st.setString(4,email);
            st.setString(5,gender);
            st.setString(6,birthDate);
            st.executeUpdate();*/
            Statement st=con.createStatement();
            String sql = "insert into usertable(username,password,email,gender,birthDate) values(\'"+username+"\',\'"
                    +password+"\',\'"+email+"\',\'"+gender+"\',\'"+birthDate+"\')";
            // insert data into database
            System.out.println("sql"+sql);
            int n=st.executeUpdate(sql);
            System.out.println("n-->"+n);
            /*//con.setAutoCommit(false);
            //PreparedStatement preparedStatement = con.prepareStatement(sql);
            //preparedStatement.executeUpdate();
            //con.commit();
            //System.out.println("insert successfully");*/
            // select all rows from usertable
            //sql = "select * from usertable";
            //ResultSet rs=st.executeQuery(sql);
            //PrintWriter out=response.getWriter();
            //con.setAutoCommit(false);
            //preparedStatement = con.prepareStatement(sql);
            //ResultSet rs = preparedStatement.executeQuery();
            //here is html code--move these html code in a jsp page-userList.jsp
            /*writer.println("<table border=\"1\">");
            writer.println("<tr>");
            writer.println("<th>ID</th>");
            writer.println("<th>username</th>");
            writer.println("<th>password</th>");
            writer.println("<th>email</th>");
            writer.println("<th>gender</th>");
            writer.println("<th>birthDate</th>");
            writer.println("</tr>");
            while (rs.next()) {
                writer.println("<tr>");
                writer.println("<td>"+rs.getString("id")+"</td>");
                writer.println("<td>"+rs.getString("username")+"</td>");
                writer.println("<td>"+rs.getString("password")+"</td>");
                writer.println("<td>"+ rs.getString("email")+"</td>");
                writer.println("<td>"+rs.getString("gender")+"</td>");
                writer.println("<td>"+ rs.getString("birthDate")+"</td>");
                writer.println("<tr>");
            }
            writer.println("</table>");
            con.commit();

            writer.close();*/
            //request.setAttribute("rsname",rs);
            //request.getRequestDispatcher("userList.jsp").forward(request,response);
            //System.out.println("i am in RegisterServlet-->doPost()-->after forward()");

        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("login.jsp");
    }

/*    @Override
    public void destroy() {
        super.destroy();
        //close connection here - when stop tomcat
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
}
