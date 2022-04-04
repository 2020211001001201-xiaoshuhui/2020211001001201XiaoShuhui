package com.XiaoShuhui.week6;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
//@WebServlet(name = "RedirectServlet",value = "/redirect")
public class RedirectServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     System.out.println("before redirect");
     //response.sendRedirect("index.jsp");//url-change to index.jsp
     System.out.println("after redirect");
     //response.sendRedirect("/2020211001001201XiaoShuhui_war/index.jsp");
     //http://localhost:8080/2020211001001201XiaoShuhui_war/redirect
     //http://localhost:8080/index.jsp
     //add /2020211001001201XiaoShuhui_war/
     response.sendRedirect("https://www.baidu.com/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
