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

<body>
    <div class="container text-center">    
        <h1>Edita Tarea</h1>
        <a class="" href="/logout">Cerrar sesion</a>
    </div>  
    
<form:form action="" method="PUT" modelAttribute="tarea" cssClass="container form ancho">
    
    <p class="form-outline">
        <form:label cssClass="form-label" path="name">Nombre</form:label>
        <form:errors cssClass="text-danger" path="name"/>
        <form:input cssClass="form-control" path="name"/>
    </p>
    <p >
        <form:select class="form-select" path="prioridad" name=""> 
                <form:option value="3">Alta</form:option>
                <form:option value="2">Media</form:option>
                <form:option value="1">Baja</form:option>
        </form:select>
    </p>

    <p >
        <p><c:out value="${error}"/></p>
        <form:select class="form-select" path="usuarioAsignado">
            <c:forEach items="${listaUsuarios}" var="usuario">
                <form:option value="${usuario.id}"><c:out value="${usuario.name}"/></form:option>
            </c:forEach>
        </form:select>
    </p>

    <input type=hidden value=0 name=number>
    <input class="btn btn-dark" type="submit" value="Guardar Tarea"/>
</form:form>
</body>