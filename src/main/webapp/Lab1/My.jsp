<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/5/18
  Time: 12:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>This is MyJsp page.</h4>
<form method="post" action="<%=request.getContextPath()%>/assignment2">
    name<input type="text" name="name"><br>
    class<input type="text" name="class"><br>
    ID<input type="text" name="id"><br>
    <input type="submit"  value="Send data to the server">
</form>
</body>
</html>
