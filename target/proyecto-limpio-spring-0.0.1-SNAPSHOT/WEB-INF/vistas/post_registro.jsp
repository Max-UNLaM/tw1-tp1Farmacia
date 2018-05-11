<%--
  Created by Tu Vieja
  User: maximiliano
  Date: 10/05/18
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro</title>
</head>
<body>
<h1>El usuario registrado es...</h1>
<div class="col-md-4 col-md-offset-2">
    ${usuario.email}
    ${usuario.password}
    ${usuario.rol}
</div>
</body>
</html>
