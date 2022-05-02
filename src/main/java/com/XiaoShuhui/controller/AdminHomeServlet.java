package com.XiaoShuhui.controller;

import com.XiaoShuhui.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class AdminHomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);//return session or null (no session) but its not crate a new session
        if (session != null && session.getAttribute("user") != null) {
            User user = (User) session.getAttribute("user");
            if ("admin".equals(user.getUsername())) {
                request.getRequestDispatcher("../WEB-INF/views/admin/index.jsp").forward(request, response);
            } else {
                //not admin user
                session.invalidate();//kill session
                request.setAttribute("message", "Unauthorized Access Admin module!!!");
                request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request, response);
            }
        } else {
            //no session-then user click link
            request.setAttribute("message", "Please login as admin!!!");
            request.getRequestDispatcher("../WEB-INF/views/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
