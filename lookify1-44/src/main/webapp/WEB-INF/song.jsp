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
    <title>Lookify!</title>
</head>

<body>
    <div>
        <div class="row">
            <div class="col align-self-end">
                <a href="/dashboard">Dashboard</a>
            </div>
        </div>
    
    <div class="border border-dark ancho mx-auto text-center mt-5">
        <h2 class="">Titulo:<c:out value="${cancion.titulo}"/></h2>
        <h3>Artista: <c:out value="${cancion.artista}"/></h3>
        <h3>Rating: <c:out value="${cancion.clasificacion}"/></h3>
    </div> 
    
        <div class="d-grid gap-2 col-6 mt-5 mx-auto">
            <a class="btn btn-dark mb-3" href="/${cancion.id}/delete">Eliminar</a>
        </div>
        
    </div>
</body>