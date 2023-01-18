<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
        <title></title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
</head>
<body>
        <h1>CONTADOR!</h1>
        <h1>has registrado <c:out value="${contador}"/> visitas a la pagina <a href="/">http://your_server</a></h1>
        <a href="/">¿quieres visitar la pagina de nuevo?</a>
        <a href="/sumaDos">ven aqui</a>
        <a href="/reset">resetear</a>
</body>
</html>