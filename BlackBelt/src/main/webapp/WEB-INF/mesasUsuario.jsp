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
    <title>Sus Mesas</title>
</head>

<body class="container">
    <div class="container text-center">    
        <h1 class="text-warning mt-4" >Welcome back, <c:out value="${usuarioLog.firstName}"/></h1>
        <a class="" href="/logout">Cerrar sesion</a>
        <h4 class="my-4">Tus tablas</h4>
    </div>

    <table class="table mb-4">
        <thead>
          <tr>
            <th scope="col">Usuario Invitado</th>
            <th scope="col">cantidad Invitados</th>
            <th scope="col">Hora de Llegada</th>
            <th scope="col">Acciones</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${usuarioLog.mesas}" var="mesa">
                <tr>
                    <th colspan=""><c:out value="${mesa.nombreInvitado}"/></th>
                    <td colspan=""><c:out value="${mesa.cantidadInvitados}"/></td>
                    <td colspan=""><c:out value="${mesa.fechaFormato()}"/></td>
                    <td colspan="">
                        <a href="/delete/${mesa.id}">Finalizar</a>|
                        <a href="/tables/${mesa.id}/edit">Editar</a>|
                        <a href="/desvincula/${mesa.id}">Desvincular Mesa </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
      </table>
        <a class="btn btn-outline-secondary" href="/tables">Ver Otras Tablas</a>
        <a class="btn btn-outline-secondary" href="/tables/new">Nueva Mesa</a>

</body>
</html>