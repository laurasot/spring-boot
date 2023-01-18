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
    <title>Lenguajes</title>
</head>
<body class="container">
    <h1 class="text-center mt-3">Actualizar</h1>
    <a href="/lenguajes">Dashboard</a>

    <h1>Actualizar <c:out value="${lenguaje.nombre}"/></h1>
    <form:form action="/lenguajes/edit/${lenguaje.id}" method="post" modelAttribute="lenguaje">
        <input type="hidden" name="_method" value="put">
        <p>
            <form:label path="nombre">Nombre</form:label>
            <form:errors path="nombre"/>
            <form:input path="nombre"/>
        </p>
        <p>
            <form:label path="creador">Creador</form:label>
            <form:errors path="creador"/>
            <form:input path="creador"/>
        </p>
        <p>
            <form:label path="versionActual">Version Actual</form:label>
            <form:errors path="versionActual"/>
            <form:input path="versionActual"/>
        </p>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>