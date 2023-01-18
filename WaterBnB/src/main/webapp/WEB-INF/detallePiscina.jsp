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
    <title>Evento</title>
</head>

<body class="container">
    <div class="container text-center my-4 ">
        <a href="/logout">Cerrar sesion</a>
        <a href="/dashboard">Dashboard</a>
        <a href="/home">Home</a>
    </div>
    <div class="alinearDisplay me-5 border border-dark">
        <p>Direccion: <c:out value="${piscina.direccion}"/></p>
        <p>Descripcion: <c:out value="${piscina.descripcion}"/></p>
    </div>
    <div class="alinearDisplay border border-dark">
        <p>Email: <c:out value="${piscina.hostUsuario.email}"/></p>
        <p>Nombre: <c:out value="${piscina.hostUsuario.firstName} ${piscina.hostUsuario.lastName}"/></p>
        <p>Tamaño de la piscina: <c:out value="${piscina.tamano}"/></p>
        <p>Precio: <c:out value="${piscina.precio}"/></p>
        <p>id piscina: <c:out value="${piscina.id}"/></p>
    </div>
        <p>Reviews (<c:out value="${piscina.getPromedio()}"/>)</p>
        <p class="text-danger"><c:out value="${error}"/></p>
        <a href="/piscina/${piscina.id}/review">Agregar Review</a>
        <c:forEach items="${piscina.reviews}" var="review">
            <p><c:out value="${review.contenido}"/></p>
        </c:forEach>
    <div>

    </div>
</body>