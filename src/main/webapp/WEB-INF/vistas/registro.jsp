<%--
  Created by IntelliJ IDEA.
  User: maximiliano
  Date: 10/05/18
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap theme -->
    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
    <title>Registro</title>
</head>
<body>
<div class="card">
    <form:form action="registro" method="POST" modelAttribute="usuario">
        <h3 class="form-signin-heading">Registrar usuario</h3>
        <form:input path="email" id="email" type="email" class="form-control"/>
        <form:input path="password" type="password" id="password" class="form-control"/>
        <form:input path="rol" type="text" id="rol" class="form-control"/>
        <button class="btn btn-lg btn-primary btn-block" Type="Submit">Registrar</button>
    </form:form>
</div>
</body>
</html>
