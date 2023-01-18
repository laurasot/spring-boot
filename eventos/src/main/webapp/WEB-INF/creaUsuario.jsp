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
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Crea una cuenta</title>
</head>

<body>
    <div class="container text-center">    
        <h1>Registrate</h1>
        <a class="" href="/login">login</a>
    </div>
        
   
    
<form:form action="" method="POST" modelAttribute="usuario" cssClass="container form ancho">
    
    <p class="form-outline">
        <form:label cssClass="form-label" path="firstName">Nombre</form:label>
        <form:errors cssClass="text-danger" path="firstName"/>
        <form:input cssClass="form-control" path="firstName"/>
    </p>
    <p>
        <form:label path="lastName">Apellido</form:label>
        <form:errors cssClass="text-danger" path="lastName"/>
        <form:input cssClass="form-control" path="lastName"/>
    </p>
    <p>
        <form:label path="email">Email</form:label>
        <form:errors cssClass="text-danger" path="email"/>
        <form:input cssClass="form-control" path="email"/>
    </p>
    <p>
        <form:label path="cityU">Ciudad</form:label>
        <form:errors cssClass="text-danger" path="cityU"/>
        <form:input cssClass="form-control" path="cityU"/>
    </p>
    <p>
        <form:label path="stateU">Estado</form:label>
        <form:errors cssClass="text-danger" path="stateU"/>
        <form:input cssClass="form-control" path="stateU"/>
    </p>
    <p>
        <form:label path="password">Password:</form:label>
        <form:errors  cssClass="text-danger" path="password"/>
        <form:input type="password" cssClass="form-control" path="password"/>
    </p>
    <p>
        <form:label path="passwordConfirmation">Password Confirmation:</form:label>
        <form:errors cssClass="text-danger" path="passwordConfirmation"/>
        <form:input type="password" cssClass="form-control" path="passwordConfirmation"/>
    </p>

    <input type=hidden value=0 name=number>
    <input class="btn btn-dark" type="submit" value="Registrarse"/>
</form:form>
</body>