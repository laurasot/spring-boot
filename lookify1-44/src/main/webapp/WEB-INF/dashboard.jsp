<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Lookify!</title>
</head>
<body>
    <div class="row my-4  justify-content-md-center text-center">
        <a class="col-2" href="/songs/new">Add New</a>
        <a class="col-2" href="/search/topTen">Top Songs</a>

        <form class="col-3" method="POST" action="/search">
            <input  type="search" name="artista" placeholder="Artista" aria-label="Search">
            <button class="btn btn-dark" type="submit">Buscar</button>
        </form>
    </div>
    
    <table class="ancho border border-dark mx-auto">
        <thead>
            <tr class="border border-dark bg-secondary">
                <th class="padding border border-dark">Titulo</th>
                <th class="padding border border-dark">Rating</th>
                <th class="padding border border-dark">Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${canciones}" var="cancion">
                <tr class="bg-light">
                    <td class="padding border border-dark"><a href="/songs/${cancion.id}"><c:out value="${cancion.titulo}"/></a></td>
                    <td class="padding border border-dark"><c:out value="${cancion.clasificacion}"/></td>
                    <td class="padding border border-dark"><a href="/${cancion.id}/delete">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
       
    </table>
</body>
</html>