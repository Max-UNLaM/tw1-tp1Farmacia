<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js" ></script>
    </head>
<body>
    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Resultado</h1>
        </div>
    </div>
    <div class="container col-md-4 col-md-offset-2 col-sm-12">
        <ul class="list-group">
            <li class="list-group-item"><span class="badge badge-secondary">Primer operando</span>${resultado.operandoUno}</li>
            <li class="list-group-item"><span class="badge badge-secondary">Operación</span>${resultado.operacion}</li>
            <li class="list-group-item"><span class="badge badge-secondary">Segundo operando</span>${resultado.operandoDos}</li>
            <li class="list-group-item"><span class="badge badge-secondary">Resultado</span>${resultado.resultado}</li>
        </ul>
    </div>
</body>
</html>