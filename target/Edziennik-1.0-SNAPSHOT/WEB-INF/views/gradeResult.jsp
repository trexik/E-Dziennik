<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ukasz
  Date: 19.04.19
  Time: 10:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="grade">
    <div class="table-info">
    <div class="form-group">
    <label>Ocena:
    <form: type="text" path="grade" class="form-control"/>
    </label>
    </div>
    </div>
</form:form>
    </body>
</html>
