<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css" />"/>
    <script src="<c:url value="/js/bootstrap.min.js" />"></script>
</head>
<body>
<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h1 class="display-4">Resultado de la operacion</h1>
    </div>
</div>
<div class="container col-md-4 col-md-offset-2 col-sm-12">
    <div class="alert alert-danger" role="alert">
        <h4>${errorCal.mensajeAmigable}</h4>
        <h4>${errorCal.mensajeTecnico}</h4>
    </div>
</div>
</body>
</html>

