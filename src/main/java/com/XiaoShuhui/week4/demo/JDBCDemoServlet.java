package com.XiaoShuhui.week4.demo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
@WebServlet(name ="JDBCDemoServlet",urlPatterns = {"/jdbc"},
        initParams = {
        @WebInitParam(name="driver",value = "com.microsoft.sqlserver.jdbc.SQLServerDriver"),
                @WebInitParam(name="url",value = "jdbc:sqlserver://localhost:1433; datebase=userdb;encrypt=false"),
                @WebInitParam(name="username",value = "sa"),
                @WebInitParam(name="password",value = "admin123456789"),
        },
        loadOnStartup = 1
)//done*/
@WebServlet(urlPatterns = {"/jdbc"},loadOnStartup = 1)
public class JDBCDemoServlet extends HttpServlet {
    Connection con = null;

    @Override
    public void init() throws ServletException {
        super.init();
        //String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        //String url="jdbc:sqlserver://localhost:1433;database=userdb;encrypt=false";
        //String username="sa";
        //String password="admin123456789";
        //1.get servlet config
        ServletConfig config=getServletConfig();
        // step 2 - get param
        //String driver =config.getInitParameter("driver"); //get <param-name>driver</param-name>
        //String url =config.getInitParameter("url"); // <param-name>url</param-name>
        //String username =config.getInitParameter("username"); //<param-name>username</param-name>
        //String password =config.getInitParameter("password"); //<param-name>password</param-name>

        ServletContext context=getServletContext();
        String driver=context.getInitParameter("driver");
        String url=context.getInitParameter("url");
        String username=context.getInitParameter("username");
        String password=context.getInitParameter("password");

        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection--> in JDBCDemoServlet" + con);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Connection-->" + con);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void destroy() {
        super.destroy();
        try {
            con.close();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
}
