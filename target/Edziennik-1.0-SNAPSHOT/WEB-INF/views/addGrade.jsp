<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ukasz
  Date: 16.04.19
  Time: 14:01
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
    <a href="/">Wroc na strone domowa</a>
    <br>

    <form:form method="post" modelAttribute="grade">
        <form:errors path="*"></form:errors>
        <div class="table-info">
            <div class="form-group">
                <label>Wpisz ocenę:
                    <form:input type="number" min="1" max="6" path="grade" class="form-control"/>
                    <form:errors path="grade"></form:errors>
                </label>

                <label>Uczeń:
                    <form:select path="user" items="${users}" itemLabel="surname" itemValue="id" class="form-control"/>
                    <form:errors path="user"></form:errors>
                </label><br>
                <label>Przedmiot:
                    <form:select path="subject" items="${subjects}" itemLabel="subject" itemValue="id" class="form-control"/>
                    <form:errors path="user"></form:errors>
                </label>
                <br><br>
            </div>
        </div>
        <input type="submit" value="Dodaj do bazy" class="btn-dark"/>

    </form:form>

</div>
</div>

</body>
</html>
