<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/5/14
  Time: 16:49
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Week 12-Demo 1</title>
</head>
<body>
This is loop.JSP page<hr>
<c:set var="user" value="admin"/>
<h2>welcome,<c:out value="${user}" default="<font color=red>Guest</font>" escapeXml="false"/> </h2>
<hr>
<h2>Looping with Simple Numeric Values</h2>
<ul>
    <c:forEach var="i" begin="1" end="10">
        <li>${i }</li>
    </c:forEach>
</ul>
<h2>Looping with Designated Step Size</h2>
<ul>
    <c:forEach var="i" begin="1" end="10" step="2">
        <li>${i }</li>
    </c:forEach>
</ul>
</body>
</html>
