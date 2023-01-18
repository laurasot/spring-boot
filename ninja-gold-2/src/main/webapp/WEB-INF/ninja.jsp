<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <title>Ninja Gold</title>
</head>
<body>
    <div class="container">
            <div class="row">
                <h1 id="yourgold" class="col-3">Your Gold:</h1>
                <h1 id="contador" class="contorno col-3"><c:out value="${goldNinja}"/></h1>
                <a href="/reset" class="btn btn-dark">Resetar</a>
            </div>
                

            <div class=" targeta contorno alineardisplay">
            <h2> Farm</h2>
            <form action="/gold" method="post">
                <p>(earns 10-20 gold)</p>
                <input type="hidden" name="tipoApuesta" value="farm">
                <button class="btn btn-outline-secondary">Find Gold!</button>
            </form>
        </div>
        <div class="targeta contorno alineardisplay">
            <h2>Cave</h2>
            <form action="/gold" method="post">
                <p>(earns 5-10 gold)</p>
                <input type="hidden" name="tipoApuesta" value="cave">
                <button class="btn btn-outline-secondary">Find Gold!</button>
            </form>
        </div>
        <div class="targeta contorno alineardisplay">
            <h2>House</h2>
            <p>(earns 2-5 gold)</p>
            <form action="/gold" method="post">
                <input type="hidden" name="tipoApuesta" value="house">
                <button class="btn btn-outline-secondary">Find Gold!</button>
            </form>
        </div>
        <div class="targeta contorno alineardisplay">
            <h2>Casino!</h2>
            <p>(earns/takes 0-50 gold)</p>
            <form action="/gold" method="post">
                <input type="hidden" name="tipoApuesta" value="casino">
                <button class="btn btn-outline-secondary">Find Gold!</button>
            </form>
        </div>
        <h2>Actividades:</h2>
        <div id="actividades"  class="contorno">
            <c:forEach var="actividad" items="${actividades}">
            <p id="actividad"><c:out value="${actividad}" /></p>
            </c:forEach>
        </div>
       
             
         
    </div>
</body>
</html>