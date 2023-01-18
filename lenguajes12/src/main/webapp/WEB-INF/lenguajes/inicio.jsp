<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/inicio.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Lenguajes</title>
</head>
<body class="container">
    <h1 class="text-center my-3 ">Todos los lenguajes</h1>
    <table class="mx-auto ancho">
        <thead class="border border-dark">
            <tr>
                <th class="padding bg-secondary">Nombre</th>
                <th class="padding bg-secondary">Creador</th>
                <th class="padding bg-secondary">Version Actual</th>
                <th class="padding bg-secondary">Accion</th>
            </tr>
        </thead>
        <tbody class="">
            <c:forEach items="${lenguajes}" var="lenguaje">
                <tr class="border border-dark">
                    <td class="padding"><a href="/lenguajes/${lenguaje.id}"><c:out value="${lenguaje.nombre}"/></a></td>
                    <td class="padding"><c:out value="${lenguaje.creador}"/></td>
                    <td class="padding"><c:out value="${lenguaje.versionActual}"/></td>
                    <td class="padding"><a class="me-4" href="/lenguajes/edit/${lenguaje.id}">Editar</a><a href="/lenguajes/${lenguaje.id}/delete">Eliminar</a> </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>


    <h1 class="my-4 text-center">Agregar Lenguaje</h1>
    <form:form action="/lenguajes" method="post" modelAttribute="lenguaje">
        <div class="border border-dark ancho mx-auto my-4 padding">
            <p>
                <form:label  class="etiqueta" path="nombre">Nombre</form:label>
                <form:errors path="nombre"/>
                <form:input class="input" path="nombre"/>
            </p>
            <p>
                <form:label class="etiqueta" path="creador">Creador</form:label>
                <form:errors path="creador"/>
                <form:input class="input" path="creador"/>
            </p>
            <p>
                <form:label class="etiqueta" path="versionActual">Version Actual</form:label>
                <form:errors path="versionActual"/>
                <form:input class="input" path="versionActual"/>
            </p>
            <div class="d-grid gap-2 col-6 mx-auto">
                <input type="submit" class="btn btn-dark" value="Submit"/>
            </div>
            
        </div>
    </form:form>
</body>
</html>