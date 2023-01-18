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
    <title>Licencias</title>
</head>

<body>
   <div class="row mt-5">
        <h1 class="col text-center">Nueva Persona</h1>
        <a class="col-4" href="/">Home</a>
    </div>
<form:form action="/new" method="POST" modelAttribute="person" cssClass="container form">
    <p class="form-outline">
        <form:label cssClass="form-label" path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input cssClass="form-control" path="firstName"/>
    </p>
    <p class="form-outline">
        <form:label cssClass="form-label" path="lastName">Last name</form:label>
        <form:errors path="lastName"/>
        <form:input cssClass="form-control" path="lastName"/>
    </p>
    <input class="btn btn-dark" type="submit" value="Crear person"/>
</form:form>
</body>