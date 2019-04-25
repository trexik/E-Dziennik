<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ukasz
  Date: 18.04.19
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
</head>
<body>
<a href="/">Strona główna</a>

<h2 class="card-body">Lista przedmiotów</h2>
<div class="table-success">
    <table border="1">
        <tr>
            <th>Przedmiot</th>
            <th>Klasa</th>
        </tr>
        <c:forEach items="${subjects}" var="sub">
        <td>${sub.subject}</td>
        <td>${sub.group}</td>
        <td>
            <a href="/subject/delete/${sub.id}">Delete</a>
        </td>
        </tr>
        </c:forEach>
</div>

<p>${msg}</p>

</body>
</html>
