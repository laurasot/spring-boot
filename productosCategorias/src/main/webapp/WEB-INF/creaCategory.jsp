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
    <title>Crear Producto</title>
</head>
<body>
    <h1>Nueva Categoria</h1>
    <form:form action="/new" method="POST" modelAttribute="category" cssClass="container form">
    <p class="form-outline">
        <form:label path="name">Nombre</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <input class="btn btn-dark" type="submit" value="Crear categoria"/>
</form:form>
</body>
</html>