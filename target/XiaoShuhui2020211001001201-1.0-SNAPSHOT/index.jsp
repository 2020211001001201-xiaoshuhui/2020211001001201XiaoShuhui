<%@ page import="java.util.Date" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@include file="header.jsp"%>
<h1><%= "Welcome to my home page." %><%System.out.println("service");%>
<%--    Date and Time<%out.println(new Date());%>--%>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet-week1</a>
<br/>
<a href="hello">Student Info Servlet-week2</a>
<br/>
<a href="life">Life Cycle Servlet-week3</a>
<br/>
<a href="register.jsp">Register-getParameter-week3</a>
<br/>
<a href="config">Config parameter-week4</a>
<br/>
<a href="register.jsp">Register JDBC-week4</a>
<br/>
<a href="index.jsp">include-week5</a>
<br/>
<a href="login.jsp">Login-week5</a>
<br/>
<!--<form>
    <span style="...">New User Registration</span><br/><br/>
    <span style="...">Username</span><input type="text" name="name" required="true" style="..."><br/><br/>
    <span style="...">Password</span><input type="password" name="password" required="true" style="..."><br/><br/>
    <span style="...">Email</span><input type="email" name="email" required="true" style="..."><br/><br/>
    <span style="...">Gender</span>
    <span style="...">Male</span><input type="radio">
    <span style="...">Female</span><input type="radio"><br/><br/>
    <span style="...">Date of birth(yy-mm-dd)</span><input type="date" pattern="yy-mm-dd" required="true" style="..."><br/><br/>
    <input type="submit" value="register" style="...">
</form>-->
<%@include file="footer.jsp"%>
