<%@ page import="com.XiaoShuhui.week11.Person" %>
<%@ page import="com.XiaoShuhui.week11.Dog" %>
<%--
  Created by IntelliJ IDEA.
  User: 偏执
  Date: 2022/5/8
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Demo 2-Week 11</title>
</head>
<body>
<%
  //create objects
  com.XiaoShuhui.week11.Person person=new Person();
  person.setName("Tom");

  Dog dog=new Dog();
  dog.setName("Tommy");

  person.setDog(dog);
  //set attribute any one scope
  request.setAttribute("personAtt",person);
%>
<h2>get person' dog name -using java code</h2>
<%
  Person p=(Person)pageContext.findAttribute("personAtt");//line 1
  Dog d=p.getDog();//line 2
  out.println(p.getName()+"s' Dog name -->"+d.getName());//line 3
%>
<h2>get person' dog name -using EL code</h2>

Person' Dog name :${personAtt.name}s' Dog name -->${personAtt.dog.name}

</body>
</html>
