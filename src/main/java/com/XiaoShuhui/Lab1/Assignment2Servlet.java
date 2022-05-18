package com.XiaoShuhui.Lab1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Assignment2Servlet", value = "/assignment2")
public class Assignment2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("Lab1/My.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        String cla=request.getParameter("class");
        String id=request.getParameter("id");
        request.setAttribute("name",name);
        request.setAttribute("cla",cla);
        request.setAttribute("id",id);
        request.getRequestDispatcher("Lab1/MyDear.jsp").forward(request,response);
    }
}

