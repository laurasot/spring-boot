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
    <div class="row my-4  justify-content-md-center text-center">
        <form class="col-4" method="POST" action="/search">
            <input  type="search" name="artista" placeholder="Artista" aria-label="Search">
            <button  type="submit">Buscar</button>
        </form>
            <a class="col-4" href="/dashboard">Dashboard</a>
    </div>
        <h1 class="text-center my-4">canciones de <c:out value="${artista}"/></h1>
        <table class="border border-dark mx-auto ancho padding">
            <thead class="padding">
                <th class="padding">Nombre</th>
                <th class="padding">Rating</th>
                <th class="padding">Actions</th>
            </thead>
            <tbody class="">
                <c:forEach items="${cancionesArtista}" var="cancionArtista">
                    <tr>
                        <td><c:out value="${cancionArtista.titulo}"/></td>
                        <td><c:out value="${cancionArtista.clasificacion}"/></td>
                        <td><a href="/${cancion.id}/delete">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
</body>