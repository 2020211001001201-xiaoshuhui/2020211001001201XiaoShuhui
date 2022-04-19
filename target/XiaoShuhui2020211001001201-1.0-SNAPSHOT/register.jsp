<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/3/13
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@include file="header.jsp"%>
    This is my register JSP page.<br>
    <form method="post" action="register">
<%--        id<input type="text" name="id"/><br/>--%>
        username<input type="text" name="username"/><br/>
        password<input type="password" name="password"/><br/>
        Email<input type="text" name="email"/><br/>
        Gender<input type="radio" name="gender" value="male">Male
        <input type="radio" name="gender" value="female">Female<br/>
        Date of Birth:<input type="text" name="birthDate"><br/>
        <input type="submit" value="Register"/>
    </form>
<%@include file="footer.jsp"%>

