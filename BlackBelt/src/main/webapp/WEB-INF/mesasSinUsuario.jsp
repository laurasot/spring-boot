<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">   
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Mesas sin Usuarios</title>
</head>

<body class="container">
    <div class="container text-center">    
        <h1 class="text-warning">Todas Las Tablas</h1>
        <a href="/logout">Cerrar sesion</a>
        <a href="/home">Home</a>
    </div>

    <table class="table">
        <thead>
          <tr>
            <th scope="col">Usuario Invitado</th>
            <th scope="col">cantidad Invitados</th>
            <th scope="col">Hora de Llegada</th>
            <th scope="col">Acciones</th>
          </tr>
        </thead>
        <tbody>
            

            <c:forEach items="${mesasSinUsuario}" var="mesa">
                <tr>
                    <th colspan=""><c:out value="${mesa.nombreInvitado}"/></th>
                    <td colspan=""><c:out value="${mesa.cantidadInvitados}"/></td>
                    <td colspan=""><c:out value="${mesa.fechaFormato()}"/></td>
                    <td colspan="">
                        <a href="/vincula/${mesa.id}">Vincular Mesa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
      </table>

</body>
</html>