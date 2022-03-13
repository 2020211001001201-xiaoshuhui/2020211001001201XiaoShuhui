<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/3/8
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>register</title>
</head>
<body align="center">
<h2>Register</h2>
<form action="registeredSucceed.jsp" method="post">
    <table align="center">
        <tr align="right">
            <td>Username:</td>
            <td><input type="text" name=name autofocus="autofocus"></td>
        </tr>
        <tr align="right">
            <td>Password:</td>
            <td><input type="text" name=password></td>
        </tr>
        <tr align="right">
            <td>e-mail:</td>
            <td><input type="text" name=e-mail></td>
        </tr>
        <tr>
            <td>Gender</td>
            <td><input type="radio" name="gender" id="gender"   required>Male
                <input type="radio" name="gender"    required>Female<br>
            </td>
        </tr>
        <tr>
            <td>Date of Birth:</td>
            <td><input type="date" name="birthday" id="birthday" class="form-control" placeholder="Please enter birthday" required>
            </td>
        </tr>
    </table>
    <input type="submit" name=register value="register" >
</form>
</body>
</html>

