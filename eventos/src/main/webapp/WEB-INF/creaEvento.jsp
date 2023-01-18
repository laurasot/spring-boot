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
    <title>Crea una Evento</title>
</head>

<body>
    
    <div class="container text-center mt-4">
        <h1>Crea Evento</h1>
        <a href="/logout">Cerrar sesion</a>
        <a href="/eventos">Revisar Eventos</a>
    </div>
<form:form action="" method="POST" modelAttribute="evento" cssClass="container form ancho">
    <p class="form-outline">
        <form:label cssClass="form-label" path="name">Nombre</form:label>
        <form:errors cssClass="text-danger" path="name"/>
        <form:input cssClass="form-control" path="name"/>
    </p>
    <p>
        <form:label path="cityE">Ciudad</form:label>
        <form:errors cssClass="text-danger" path="cityE"/>
        <form:input cssClass="form-control" path="cityE"/>
    </p>
    <p>
        <form:label path="stateE">Estado</form:label>
        <form:errors cssClass="text-danger" path="stateE"/>
        <form:input cssClass="form-control" path="stateE"/>
    </p>
    <p>
        <form:label path="date">Date</form:label>
        <form:errors cssClass="text-danger" path="date"/>
        <form:input  type="date" cssClass="form-control" path="date"/>
    </p>

    <input type=hidden value=0 name=number>
    <input class="btn btn-dark" type="submit" value="Crea Evento"/>
</form:form>
</body>