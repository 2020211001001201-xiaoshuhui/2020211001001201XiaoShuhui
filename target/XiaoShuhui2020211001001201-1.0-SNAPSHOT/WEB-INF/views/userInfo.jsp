<%@ page import="com.XiaoShuhui.model.User" %><%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/4/4
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%@include file="header.jsp"%>
<h1>User Info</h1>
 <%--<%
    //read cookies
    Cookie [] allCookies=request.getCookies();
    for(Cookie c:allCookies){
        //get one by one
        out.println("<br/"+c.getName()+"---"+c.getValue());
    }
    %>--%>
    <%
    User u=(User)session.getAttribute("user");
    %>
<table>
    <tr>
        <td>Username:</td><td><%=u.getUsername()%></td>
    </tr><tr>
        <td>Password:</td><td><%=u.getPassword()%></td>
    </tr><tr>
        <td>Email:</td><td><%=u.getEmail()%></td>
    </tr><tr>
        <td>Gender:</td><td><%=u.getGender()%></td>
    </tr><tr>
        <td>Birth Date:</td><td><%=u.getBirthDate()%></td>
    </tr>
</table>
<a href="updateUser">Update</a>
<%@include file="footer.jsp"%>