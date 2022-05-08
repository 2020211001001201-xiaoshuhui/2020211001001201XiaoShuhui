<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/5/8
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 1-Week 11</title>
</head>
<body>

<%
// set attribute
    pageContext.setAttribute("attName","Att in page");
    request.setAttribute("attName","Att in request");
    session.setAttribute("attName","Att in session");
    application.setAttribute("attName","Att in application");
%>
<h2>get 4 scope variable -using java code</h2>
att value :<%=pageContext.getAttribute("attName",PageContext.PAGE_SCOPE)%><br>
att value :<%=pageContext.getAttribute("attName",PageContext.REQUEST_SCOPE)%><br>
att value :<%=pageContext.getAttribute("attName",PageContext.SESSION_SCOPE)%><br>
att value :<%=pageContext.getAttribute("attName",PageContext.APPLICATION_SCOPE)%><br>

Find att :<%=pageContext.findAttribute("attName")%><!--which one ?-->

<h2>get 4 scope variable -using EL code</h2>

Att value :${attName}<!-- ==findAttribute("attName") which one ?-->
<h2> no find - get Attribute from any one scope - using EL code</h2>
att value : ${sessionScope.attName}<br/><!--pageContext.getAttribute("attName",PageContext.SESSION_SCOPE)-->
att value : ${requestScope.attName}<br/>
att value : ${pageScope.attName}<br/>
att value : ${applicationScope.attName}<br/>
</body>
</html>
