<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/3/28
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
This is Count JSP page.<br>
<%! int getCount(){
    return ++count;
}%>
<%! int count=0;%>
The page count is now(using count()):<% out.println(getCount());%>
<%@include file="footer.jsp"%>
