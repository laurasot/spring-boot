<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Eventos</title>
</head>
<body>
    <div class="container text-center">    
        <h1>Eventos</h1>
        <a href="/nuevoEvento">Agregar Evento</a>
        <a href="/logout">Cerrar sesion</a>
    </div>
    
    <table class="ancho border border-dark mx-auto mt-4">
        <thead>
            <tr class="border border-dark bg-secondary">
                <th class="padding border border-dark">Nombre</th>
                <th class="padding border border-dark">Fecha</th>
                <th class="padding border border-dark">Lugar</th>
                <th class="padding border border-dark">Host</th>
                <th class="padding border border-dark">Accion/Estado</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${eventosEstados}" var="eventoEstado">
                <tr class="bg-light">
                    <td class="padding border border-dark"><a href="/events/${eventoEstado.id}"><c:out value="${eventoEstado.name}"/></a></td>
                    <td class="padding border border-dark"><c:out value="${eventoEstado.date}"/></td>
                    <td class="padding border border-dark"><c:out value="${eventoEstado.cityE}"/></td>
                    <td class="padding border border-dark"><c:out value="${eventoEstado.hostUsuario.firstName}"/></td>
                    <td class="padding border border-dark">
                        <c:choose>
                            <c:when test= "${eventoEstado.hostUsuario.id == idUsuarioLogin}">
                                <a href="/edit/${eventoEstado.id}">Edit</a> <a href="/delete/${eventoEstado.id}">Delete</a>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test= "${eventoEstado.hostUsuario.id != idUsuarioLogin && !eventoEstado.usuariosParticipantes.contains(usuario)}">
                                <a href="/join/${eventoEstado.id}">Join</a>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test= "${eventoEstado.usuariosParticipantes.contains(usuario)}">
                                <p>Joining</p>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test= "${eventoEstado.usuariosParticipantes.contains(usuario)}">
                                <a href="/cancelar/${eventoEstado.id}">Cancel</a>
                            </c:when>
                        </c:choose>
                    </td>   
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <table class="ancho border border-dark mx-auto my-5">
        <thead>
            <tr class="border border-dark bg-secondary">
                <th class="padding border border-dark">Nombre</th>
                <th class="padding border border-dark">Fecha</th>
                <th class="padding border border-dark">Lugar</th>
                <th class="padding border border-dark">Host</th>
                <th class="padding border border-dark">Accion/Estado</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${eventosNoEstados}" var="eventoNoEstado">
                <tr class="bg-light">
                    <td class="padding border border-dark"><a href="/events/${eventoNoEstado.id}"><c:out value="${eventoNoEstado.name}"/></a></td>
                    <td class="padding border border-dark"><c:out value="${eventoNoEstado.date}"/></td>
                    <td class="padding border border-dark"><c:out value="${eventoNoEstado.cityE}"/></td>
                    <td class="padding border border-dark"><c:out value="${eventoNoEstado.hostUsuario.firstName}"/></td>
                    <td class="padding border border-dark">
                        <c:choose>
                            <c:when test= "${eventoNoEstado.hostUsuario.id == idUsuarioLogin}">
                                <a href="">Edit</a> <a href="/delete/${eventoNoEstado.id}">Delete</a>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test= "${eventoNoEstado.hostUsuario.id != idUsuarioLogin && !eventoNoEstado.usuariosParticipantes.contains(usuario)}">
                                <a href="/join/${eventoNoEstado.id}">Join</a>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test= "${eventoNoEstado.usuariosParticipantes.contains(usuario)}">
                                <p>Joining</p>
                            </c:when>
                        </c:choose>
                        <c:choose>
                            <c:when test= "${eventoNoEstado.usuariosParticipantes.contains(usuario)}">
                                <a href="/cancelar/${eventoNoEstado.id}">Cancel</a>
                            </c:when>
                        </c:choose>
                    </td>  
                </tr>
            </c:forEach>
        </tbody>
       
    </table>
</body>
</html>