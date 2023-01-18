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
    <title>Descripcion lenguaje</title>
</head>
<body class="container">  
    <div class="border border-dark ancho">
        <h2><c:out value="${lenguaje.nombre}"/></h2>
        <a href="/lenguajes">Dashboard</a>
        <h3>Creador: <c:out value="${lenguaje.creador}"/></h3>
        <h3>Version Actual: <c:out value="${lenguaje.versionActual}"/></h3>
    </div> 
    
        <div class="d-grid gap-2 col-6 mx-auto mt-5">
            <a class="btn btn-dark mb-3" href="/lenguajes/edit/${lenguaje.id}">Editar Lenguaje</a>
            <a class="btn btn-dark mb-3" href="/lenguajes/${lenguaje.id}/delete">Eliminar</a>
        </div>
        
    </div>
</body>
</html>