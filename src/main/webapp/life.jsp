<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/3/28
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<%!
    public void jspInit(){
        System.out.println("i am in jspinit()");
    }
%>
<html>
<head>
    <title>Life Cycle JSP</title>
</head>
<body>
<%System.out.println("i am in jspservice()");%>
</body>
</html>
<!--service-->
<%!
    public void jspDestory(){
        System.out.println("i am in jspDestory()");
    }
%>
