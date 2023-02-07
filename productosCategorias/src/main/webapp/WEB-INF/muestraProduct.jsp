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
    <title>Productos</title>
</head>

<body class="container">
        <div class="row">
            <div class="col align-self-end">
                <a href="/">Dashboard</a>
            </div>
        </div>
    
    <div class="border border-dark ancho mx-auto text-center mt-5 me-5 alinearDisplay dezplamientoY">
        <h1 class=""><c:out value="${productoAEditar.name}"/></h1>
        <h2 class="">Precio: <c:out value="${productoAEditar.price}"/></h2>
        <h4>Categorias:</h4>
        <c:forEach items="${productoAEditar.categories}" var="categoriaSuya">
            <li><c:out value="${categoriaSuya.name}"/></li>
        </c:forEach>  
    </div> 
    
    <form class="alinearDisplay ancho mt-5 ms-5" method="POST" action="/products/${productoAEditar.id}">
        <select class="form-select"  name="categoria">
                <c:forEach items="${categoriasNoProduct}" var="categoria">
                    <option value="${categoria.id}">${categoria.name}</option>
                </c:forEach>
        </select>
        <input class="btn btn-dark mt-4" type="submit" value="Agregar Categoria"/>
    </form>

    <form class="alinearDisplay ancho mt-5 ms-5" method="POST" action="/plan/${empresa.id}">
        <select class="form-select"  name="servicio">
                <c:forEach items="${servicios}" var="servicio">
                    <option value="${servicio.id}">${servicio.servicioOfrecido}</option>
                </c:forEach>
        </select>
        <option value="">ingresa la opcion que tu prefieras</option>
        <input class="btn btn-dark mt-4" type="submit" value="Agregar Servicio"/>
    </form>
</body>
</html>