package com.XiaoShuhui.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("In AuthFile before doFilter"+System.currentTimeMillis());
        HttpServletRequest request1=(HttpServletRequest)request;
        System.out.println("getRequestURL-->"+request1.getRequestURL());
        System.out.println("getServerName-->"+request1.getServerName());
        System.out.println("getServerPort-->"+request1.getServerPort());
        System.out.println("getRequestURI-->"+request1.getRequestURI());
        System.out.println("getRequestPath-->"+request1.getServletPath());
        System.out.println("getQueryString-->"+request1.getQueryString());
        System.out.println("getMethod-->"+request1.getMethod());
        //request come here-before go to servlet-doGet() or doPost()
        System.out.println("i am in AuthFilter-->doFilter()-before servlet-(request come here)");
        chain.doFilter(request, response);//call next filter - if no next filter-then go to servlet
        //response after servlet come back here
        System.out.println("i am in AuthFilter-->doFilter()-after servlet-(request come here)");
        System.out.println("In AuthFilter after doFilter"+System.currentTimeMillis());
    }
}
