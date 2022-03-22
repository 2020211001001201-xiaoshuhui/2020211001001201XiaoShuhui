package com.XiaoShuhui.week4.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
@WebServlet("/config")
public class ConfigDeomServlet extends HttpServlet {
    Connection con = null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
/*        ServletConfig config=getServletConfig();
        String name =config.getInitParameter("name");
        String studentid =config.getInitParameter("studentid");*/
        ServletContext context=getServletContext();
        String name=context.getInitParameter("name");
        String studentid=context.getInitParameter("studentid");

        PrintWriter writer=response.getWriter();
        writer.println("name:"+name);
        writer.println("studentid:"+studentid);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
