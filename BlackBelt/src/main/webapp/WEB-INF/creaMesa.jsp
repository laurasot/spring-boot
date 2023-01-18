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
    <title>Crea una cuenta</title>
</head>

<body class="container">
    <div class="container text-center">    
        <h1>Crear Mesa</h1>
        <a class="" href="/logout">logout</a>
    </div>
        
   
    
<form:form action="" method="POST" modelAttribute="mesa" cssClass="container form ancho">
    
    <p class="form-outline">
        <form:label cssClass="form-label" path="nombreInvitado">Nombre Invitado</form:label>
        <form:errors cssClass="text-danger" path="nombreInvitado"/>
        <form:input cssClass="form-control" path="nombreInvitado"/>
    </p>
    <p class="form-outline">
        <form:label cssClass="form-label" path="cantidadInvitados">cantidad Invitados</form:label>
        <form:errors cssClass="text-danger" path="cantidadInvitados"/>
        <form:input type="number" min="1" max="10" cssClass="form-control" path="cantidadInvitados"/>
    </p>
    <p class="form-outline">
        <form:label cssClass="form-label" path="nota">Nota</form:label>
        <form:errors cssClass="text-danger" path="nota"/>
        <form:textarea cssClass="form-control" path="nota"/>
    </p>
    <input type=hidden value=0 name=number>
    <input class="btn btn-outline-secondary" type="submit" value="Crear Mesa"/>
</form:form>
<a class="btn btn-outline-secondary" href="/home">Cancel</a>
</body>