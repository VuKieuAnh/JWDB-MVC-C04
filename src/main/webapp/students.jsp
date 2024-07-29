<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 29/07/2024
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sach HV</h1>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
    </tr>
    <c:forEach items="${students}" var="s">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.age}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
