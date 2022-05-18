package com.XiaoShuhui.Lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Assignment1Servlet", value = "/assignment1")
public class Assignment1Servlet extends HttpServlet {
    int index;
    @Override
    public void init() throws ServletException {
        super.init();
        index=0;
        System.out.println("I am from default constructor");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ++index;
        System.out.println("since loading ,this servlet has been accessed "+index+" times");
        PrintWriter out = response.getWriter();
        ((PrintWriter) out).println("<h1>Xiaoshuhui <br>" +
                "2020211001001201<br>"+"since loading ,this servlet has been accessed "+index+" times</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
