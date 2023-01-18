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
    <title>Tarea</title>
</head>

<body class="container">
    <div class="container text-center mt-4">
        <a href="/logout">Cerrar sesion</a>
        <a href="/tareas">Tareas</a>
    </div>
        <h1>Tarea: <c:out value="${tarea.name}"/></h1>
        <p>Creador: <c:out value="${tarea.usuarioCreador.name}"/></p>
        <p>persona asignada: <c:out value="${tarea.usuarioAsignado.name}"/></p>
        <p>Prioridad:
            <c:if test="${tarea.prioridad == 3}">
                <td>Media </td>
            </c:if>
            <c:if test="${tarea.prioridad == 2}">
                <td>Media </td>
            </c:if>
            <c:if test="${tarea.prioridad == 1}">
                <td>Baja </td>
            </c:if>
        </p>
        <p>id del usuario: <c:out value="${idUsuarioLogin}"/></p>
        <p>id del creador: <c:out value="${tarea.usuarioCreador.id}"/></p>
        
        <c:choose>
            <c:when test= "${tarea.usuarioCreador.id == idUsuarioLogin}">
                <a href="/delete/${tarea.id}" class="btn btn-dark">Eliminar</a>
                <a href="/tarea/${tarea.id}/edit" class="btn btn-dark">Editar</a>
            </c:when>
        </c:choose>
        <c:choose>
            <c:when test= "${tarea.usuarioAsignado.id == idUsuarioLogin}">
                <a href="/completa/${tarea.id}" class="btn btn-primary">Tarea Completada</a>  
            </c:when>
        </c:choose>
 </body>