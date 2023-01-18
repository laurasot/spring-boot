<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Home</title>
</head>
<body>
    <div class="container text-center mt-5">    
        <h1>Bienvenido/a, <c:out value="${usuario.firstName}"/></h1>
        <a class="" href="/dashboard">Dashboard</a>
        <a class="" href="/logout">Cerrar sesion</a>
    </div>
    <div class="container text-center mt-5">
        <p>busca las mejores piscinas para ti</p>
        <form action="/search" class="d-flex ancho mx-auto" role="search">
            <input name="direccion" class="form-control" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-dark" type="submit">Search</button>
          </form>
    
    </div>
    
    
</body>
</html>