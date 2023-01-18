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
    <title>Lookify! New</title>
</head>
<body>
    <a class="" href="/dashboard">Dashboard</a>
    <h1 class="my-4 text-center">Agregar Cancion</h1>
    <form:form class="border border-dark ancho mx-auto text-center" action="/dashboard" method="post" modelAttribute="cancion">
        <div>
            <p>
                <form:label class="anchoLabel mt-5" path="titulo">Titulo</form:label>
                <form:errors path="titulo"/>
                <form:input  path="titulo"/>
            </p>
            <p>
                <form:label class="anchoLabel" path="artista">Artista</form:label>
                <form:errors path="artista"/>
                <form:input  path="artista"/>
            </p>
            <p>
                <form:label class="anchoLabel" path="clasificacion">Rating (1-10)</form:label>
                <form:errors path="clasificacion"/>
                <form:input  path="clasificacion"/>
            </p>
            <div class="d-grid gap-2 col-6 mx-auto">
                <input type="submit" class="btn btn-dark my-5" value="Submit"/>
            </div>
        </div>
    </form:form>
</body>
</html>