<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/3/28
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>Login</h1>
<%
    if(!(request.getAttribute("message")==null)){
       out.println(request.getAttribute("message"));
    }
%>
<form method="post" action="login">
    username<input type="text" name="username"/><br/>
    password<input type="password" name="password"/><br/>
    <input type="submit" value="sumbit"/>
</form>
<%@include file="footer.jsp"%>
