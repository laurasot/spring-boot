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
    <title>Licencias</title>
</head>

<body>
    <div class="row mt-5">
        <h1 class="col text-center">Nueva Licencia</h1>
        <a class="col-4" href="/">Home</a>
        
    </div>
        
   
   
    

<form:form action="" method="POST" modelAttribute="license" cssClass="container form">
    <p class="form-outline">
        <form:label cssClass="form-label" path="person">Persona</form:label>
        <form:errors path="person"/>
        <form:select class="form-select" path="person" name="listadoPersona" id=""> 
            <c:forEach items="${listaPersonas}" var="persona" >
				<form:option value="${persona.id}">${persona.firstName} ${persona.lastName}</form:option>
		    </c:forEach>
        </form:select>
    </p>
    <p class="form-outline">
        <form:label cssClass="form-label" path="state">Estado</form:label>
        <form:errors path="state"/>
        <form:input cssClass="form-control" path="state"/>
    </p>
    <p>
        <form:label path="expirationDate">Fecha de expiracion</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date" cssClass="form-control col-3" path="expirationDate"/>
    </p>
    <input type=hidden value=0 name=number>
    <input class="btn btn-dark" type="submit" value="Crear licencia"/>
</form:form>
</body>