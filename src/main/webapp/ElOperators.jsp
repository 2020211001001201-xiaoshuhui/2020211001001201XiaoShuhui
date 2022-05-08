<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/5/8
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 5-week 11</title>
</head>
<body>
<table border="1">
    <tr>
        <td colspan="2">Arithmetic Operation</td>
        <td colspan="2">Relational Operation</td>
    </tr>
    <tr>
        <td>Expression</td><td>Result</td>
        <td>Expression</td><td>Result</td>
    </tr>
    <tr>
        <td>\${3+2-1}</td><td>${3+2-1}</td>
        <td>\${1&lt;2}</td><td>${1<2}</td>
    </tr>
    <tr>
        <td>\${"1"+2}</td><td>${"1"+2}</td>
        <td>\${"a"&lt;"b"}</td><td>${"a"<"b"}</td>
    </tr>
    <tr align="center">
        <td>\${1+2*3+3/4}</td><td>${1+2*3+3/4}</td>
        <td>\${2/3 &gt;=3/2}</td><td>${2/3>=3/2}</td>
    </tr>
    <tr align="center">
        <td>\${3%2}</td><td>${3%2}</td>
        <td>\${3/4==0.75}</td><td>${3/4==0.75}</td>
    </tr>
    <tr>
        <td colspan="2">Logical Operation</td>
        <td colspan="2">Empty Operation</td>
    </tr>
    <tr>
        <td>Expression</td><td>Result</td>
        <td>Expression</td><td>Result</td>
    </tr>
    <tr align="center">
        <td>\${(1&lt;2)&&(4&lt;3)}</td><td>${(1<2)&&(4<3)}</td>
        <td>\${empty ""}</td><td>${empty ""}</td>
    </tr>
    <tr align="center">
        <td>\${(1&lt;2)&&(4&lt;3)}</td><td>${(1<2)||(4<3)}</td>
        <td>\${empty null}</td><td>${empty null}</td>
    </tr>
    <tr align="center">
        <td>\${!(1&lt;2)}</td><td>${!(1<2)}</td>
        <td>\${empty param.blah}</td><td>${empty param.blah}</td>
    </tr>
</table>
</body>
</html>
