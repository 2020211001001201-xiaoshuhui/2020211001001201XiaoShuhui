<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/5/8
  Time: 11:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 4-week 11</title>
</head>
<body>
<h2>Get request parameter using java code</h2>
name:<%=request.getParameter("name")%><br>
ID:<%=request.getParameter("id")%><br>
Subject :<%
    String [] allSubjects=request.getParameterValues("subject");
    for(String s : allSubjects){
        out.print(s +",");
    }
%><br>

<h2>Get request parameter using EL code</h2>
Name:${param.name}<br>
Id:${param.id}<br>
subject :${paramValues.subject[0]},${paramValues.subject[1]},${paramValues.subject[2]}

<h2>Get request using java code </h2>
Host:<%=request.getHeaders("Host")%>

<h2>Get request using EL code </h2>
Host:${header.Host}

<h2>read all cookies using java code</h2>
<%
    Cookie[] allCookies=request.getCookies();
    for(Cookie c:allCookies){
        out.println("name"+c.getName()+"value"+c.getValue());
    }
%>

<h2>read all cookies using EL code</h2>
value:${cookie.JSESSIONID.value}

<h2>Get Context init Param using java code</h2>
Username:<%=application.getInitParameter("username")%>

<h2>Get Context init Param using EL code</h2>
username:${initParam.username}

<h3>Use pageContext using java code</h3>
session id :<%=pageContext.getSession().getId()%><!--jsp object-->
<h3>Use pageContext using EL code</h3>
Session id :${pageContext.session.id}
<h3>Use empty</h3>
<%
    String str="test";//not an attribute
    pageContext.setAttribute("str",null);
%>
-->${empty str}
</body>
</html>
