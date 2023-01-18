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
    <title>Todos los estudiantes</title>
</head>

<body>
    <h1 class="text-center mt-5 mb-4">Todos los Estudiantes</h1>
    
        <table class="border border-dark ancho mx-auto">
            <thead>
                <tr>
                    <th class="border border-dark text-center">Nombre</th>
                    <th class="border border-dark text-center">Edad</th>
                    <th class="border border-dark text-center">Direccion</th>
                    <th class="border border-dark text-center">City</th>
                    <th class="border border-dark text-center">Estado</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${estudiantes}" var="estudiante">
                    <tr class="bg-light">
                        <td class="border border-dark text-center"><c:out value="${estudiante.firstName} ${estudiante.lastName}"/> </td>
                        <td class="border border-dark text-center"><c:out value="${estudiante.age}"/></td>
                        <td class="border border-dark text-center"><c:out value="${estudiante.contact.address}"/></td>
                        <td class="border border-dark text-center"><c:out value="${estudiante.contact.city}"/></td>
                        <td class="border border-dark text-center"><c:out value="${estudiante.contact.state}"/></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    
</body>
</html>