<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: kieuanh
  Date: 26/07/2024
  Time: 09:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="kax" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Hello</h1>
<%
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("Hello");
    arrayList.add("Hello1");
    arrayList.add("Hello2");
    arrayList.add("Hello2");
    request.setAttribute("ds", arrayList);
%>
<%--ds co so luong >3 -> so luong lon--%>
<kax:if test="${ds.size()>3}">
    <p>so luong lon</p>
</kax:if>
<ul>
    <kax:forEach var="s" items="${ds}">
<%--        var: bien tai moi lan lap--%>
<%--        items: ds muon lap--%>
        <li>${s}</li>
    </kax:forEach>

</ul>
</body>
</html>
