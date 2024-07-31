<%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 30/07/2024
  Time: 09:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Form edit</h1>
<form method="post" >
    <input type="text" value="${product.id}" name="id">
    <input type="text" value="${product.name}" name="name">
    <input type="text" value="${product.price}" name="price">
    <button type="submit">Edit</button>
</form>
</body>
</html>
