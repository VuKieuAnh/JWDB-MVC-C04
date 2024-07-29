<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 26/07/2024
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    String name = request.getParameter("name");
    System.out.println(name);
    String pw = request.getParameter("pw");
    System.out.println(pw);
%>
<h1>Xin chao khach hang</h1>
<%
    out.print(pw);
%><%
    out.print(name);
%>

</body>
</html>
