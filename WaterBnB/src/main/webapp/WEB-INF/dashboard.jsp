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
    <title>Piscinas</title>
</head>

<body class="container">
    <div class="container text-center">    
        <h1>Dashboard</h1>
        <a href="/logout">Cerrar sesion</a>
        <h4>Lista de tus piscinas</h4>
    </div>

    <table class="table">
        <thead>
          <tr>
            <th scope="col">Direccion</th>
            <th scope="col">Tamaño</th>
            <th scope="col">Costo por Noche</th>
            <th scope="col">Details </th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${piscinas}" var="piscina">
                <tr>
                    <th colspan=""><c:out value="${piscina.direccion}"/></th>
                    <td colspan=""><c:out value="${piscina.tamano}"/></td>
                    <td colspan=""><c:out value="${piscina.tamano}"/></td>
                    <td colspan=""><a href="host/piscina/${piscina.id}"><c:out value="${piscina.getPromedio()}"/></a></td>
                </tr>
            </c:forEach>
          
        </tbody>
      </table>
        
   
<h4 class="text-center mt-5">Agrega una piscina</h4>    
<form:form action="" method="POST" modelAttribute="piscina" cssClass="container form ancho">
    
    <p class="form-outline">
        <form:label cssClass="form-label" path="direccion">Direccion</form:label>
        <form:errors cssClass="text-danger" path="direccion"/>
        <form:input cssClass="form-control" path="direccion"/>
    </p>
    <p>
        <form:label path="precio">Precio</form:label>
        <form:errors cssClass="text-danger" path="precio"/>
        <form:input cssClass="form-control" path="precio"/>
    </p>
    <p >
        <form:select class="form-select" path="tamano" name=""> 
                <form:option value="medio">Mediana</form:option>
                <form:option value="pequeno">Pequeña</form:option>
                <form:option value="grande">Grande</form:option>
        </form:select>
    </p>
    <p>
        <form:label cssClass="form-label" path="descripcion">Descripcion</form:label>
        <form:errors cssClass="text-danger" path="descripcion"/>
        <form:textarea class="form-control" path="descripcion" aria-label="With textarea"></form:textarea>
    </p>
    <input type=hidden value=0 name=number>
    <input class="btn btn-dark" type="submit" value="Agregar Piscina"/>
</form:form>
</body>
</html>