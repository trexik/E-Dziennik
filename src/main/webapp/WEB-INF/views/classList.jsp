<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ukasz
  Date: 18.04.19
  Time: 16:53
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
<h1 class="card-header">Lista dodanych klas</h1>

<table border="1" class="table-active" style="width: 100%">
    <tr>
        <th>Klasa:</th>
    </tr>
    <c:forEach items="${groups}" var="group">
    <tr>
        <td>${group.groupName}</td>
        <td>
            <%--<a href="/group/update/${group.id}">Edit</a>--%>
            <a href="/group/delete/${group.id}">Delete</a>
        </td>
    </tr>
    </c:forEach>

    <p>${msg}</p>

</body>
</html>
