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
    <div class=" row mt-5">
        <a class="col-3 text-center" href="/">Home</a>
    </div>
    <div class="mt-5 mx-auto border border-dark ancho alto padding">
        <h1 class="mt-3"><c:out value="${person.firstName}"/> <c:out value="${person.lastName}"/></h1>
        <h3 class="mt-3">Numero de Licencia: <c:out value="${person.license.number}"/></h3>
        <h3 class="mt-3">Estado: <c:out value="${person.license.state}"/></h3>
        <h3 class="mt-3">Fecha de expiracion: <c:out value="${person.license.expirationDate}"/></h3>
    </div>
    
</body>
</html>