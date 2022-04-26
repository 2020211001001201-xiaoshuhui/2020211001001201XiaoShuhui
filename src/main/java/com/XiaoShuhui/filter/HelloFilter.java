package com.XiaoShuhui.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",
urlPatterns = {"/Hello"}
)
//task 1:url /Hello-filter is only for one Servlet-HelloServlet
//task 2:url /*-this filter of for all servlet
//task 3:3 url-this filter for these 3 url only
public class HelloFilter implements Filter {//remember
    public void init(FilterConfig config) throws ServletException {
    System.out.println("i am in HelloFilter-->init()");//when called?--start tomcat
    }

    public void destroy() {
        System.out.println("i am in HelloFilter-->destroy()");//when called?--stop tomcat
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //request come here-before go to servlet-doGet() or doPost()
        System.out.println("i am in HelloFilter-->doFilter()-before servlet-(request come here)");
        chain.doFilter(request, response);//call next filter - if no next filter-then go to servlet
        //response after servlet come back here
        System.out.println("i am in HelloFilter-->doFilter()-after servlet-(request come here)");
    }
}
