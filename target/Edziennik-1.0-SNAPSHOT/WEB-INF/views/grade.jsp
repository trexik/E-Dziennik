<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ukasz
  Date: 17.04.19
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="/webjars/jquery/3.0.0/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/main.css" rel="stylesheet">
</head>
<body>
<div class="container">
<form:form method="post">
<label>Liczba pkt
    <input type="number" name="points">
</label>
<label>Max liczba pkt
    <input type="number" name="maxpoints">
</label>
    <input type="submit" value="Save"/>
</form:form>
</div>
</body>
</html>
