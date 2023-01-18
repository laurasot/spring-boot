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
    <title>Evento</title>
</head>

<body>
    <div class="container text-center mt-4">
        <a href="/nuevoEvento">Agregar Evento</a>
        <a href="/logout">Cerrar sesion</a>
        <a href="/eventos">Revisar Eventos</a>
    </div>
    
    <div class="alinearflex mt-3">
        <div class="me-5">
            <h1><c:out value="${evento.name}"/></h1>
            <h4>Host: <c:out value="${evento.hostUsuario.firstName}"/></h4>
            <h4>Date: <c:out value="${evento.date}"/></h4>
            <h4>Location: <c:out value="${evento.cityE}"/>, <c:out value="${evento.stateE}"/></h4>
            <h4>Personas que asisten al evento: <c:out value="${cantidadParticipantes}"/></h4>
            
            <table class="border border-dark mt-4">
                <thead>
                    <tr class="border border-dark bg-secondary">
                        <th class="padding border border-dark">Participante</th>
                        <th class="padding border border-dark">ciudad</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td class="padding border border-dark"><c:forEach items="${evento.usuariosParticipantes}" var="participante">${participante.firstName}</c:forEach> </td>
                        <td class="padding border border-dark"><c:forEach items="${evento.usuariosParticipantes}" var="participante">${participante.cityU}</c:forEach></td>
                    </tr>
                </tbody>
            </table>
        </div>
        

        <div class="ms-5 ">
            <h1>Foro de mensajes</h1>
            <div id="comentarios" class="border border-dark">
                <c:forEach items="${evento.comentarios}" var="comentario">
                   <p>${comentario.contenido}</p>
                </c:forEach>
            </div>
        
            <form:form action="" method="POST" modelAttribute="comentario" cssClass="container form mt-5">
                <p class="form-outline">
                    <form:label cssClass="form-label" path="contenido">Agrega Comentario</form:label>
                    <form:errors path="contenido"/>
                    <form:textarea class="form-control" path="contenido" aria-label="With textarea"></form:textarea>
                </p>        
                <input type=hidden value=0 name=number>
                <input class="btn btn-dark" type="submit" value="Agregar Comentario"/>
            </form:form>
        </div>
    </div>

</body>