<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">   
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Nuevo Comentario</title>
</head>

<body class="container">
    <div class="container text-center">    
        <h1>Agrega una review</h1>
        <a href="/logout">Cerrar sesion</a>
        <a href="/home">Home</a>
    </div>
<p class="container ancho"><c:out value="${piscina.direccion}"/></p>

<form:form action="" method="POST" modelAttribute="review" cssClass="container form ancho">
    
    <p class="form-outline">
        <form:label cssClass="form-label" path="contenido">Agrega tu review</form:label>
        <form:errors cssClass="text-danger" path="contenido"/>
        <form:textarea cssClass="form-control" path="contenido"/>
    </p>
    <p>
        <form:label path="rating">Rating</form:label>
        <form:errors cssClass="text-danger" path="rating"/>
        <form:input type="number" min="1" max="5" cssClass="form-control" path="rating"/>
    </p>


    <input class="btn btn-dark" type="submit" value="Agregar Review"/>
</form:form>

</body>
</html>