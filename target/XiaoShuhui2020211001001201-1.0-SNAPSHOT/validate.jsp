<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/5/1
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<<%
    String username=request.getParameter("username");
    String password=request.getParameter("password");
    if("admin".equals(password)){
%>
<jsp:forward page="Welcome.jsp"/>
<%}else {
        out.write("Username or Password Error!!!");
%>
<jsp:include page="login.jsp"/>
<%}
%>
</body>
</html>
