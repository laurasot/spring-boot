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
    <title>Top Song</title>
</head>

<body>
    <div class="row my-4  justify-content-md-center mx-auto ancho">
        <h1 class="col-9">Top 10 de canciones</h1>
        <a class="col-2" href="/dashboard">Dashboard</a>
    </div>
 
    <div class="border border-dark anchoTopten mx-auto padding">
        <c:forEach items="${cancionesTop}" var="cancionTop">
            <p><c:out value="${cancionTop.clasificacion}"/> <a href="/songs/${cancionTop.id}"><c:out value="${cancionTop.titulo}"/></a> <c:out value="${cancionTop.artista}"/></p>
        </c:forEach>
    </div>
   
</body>