<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="d" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ukasz
  Date: 17.04.19
  Time: 13:34
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
<div class="container">
    <a href="/">Przejdz do strony glownej</a>

<form:form method="post" modelAttribute="subject">
    <div class="table-info">
        <div class="form-group">
            <label>Nazwa przedmiotu:
                <form:input type="text" path="subject"/>
            </label
            <br><br>
            <label>Klasa:
                <form:select path="group" items="${groups}" itemLabel="groupName" itemValue="id"/>
            </label>
            <br><br>
            <input type="submit" value="Dodaj przedmiot do danej klasy" class="btn-dark"/>
            <br><br>
            </form:form>
        </div>
    </div>

</body>
</html>
