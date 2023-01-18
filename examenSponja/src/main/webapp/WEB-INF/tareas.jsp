<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Tareas</title>
</head>
<body>
    <div class="container text-center">    
        <h1>Tareas</h1>
        <a href="/logout">Cerrar sesion</a>
        <a href="/mayor">mayor prioridad</a>
        <a href="/menor">menor prioridad</a>
    </div>

    <table class="table">
        <thead>
          <tr>
            <th scope="col">Tarea</th>
            <th scope="col">Creador</th>
            <th scope="col">Asignado a</th>
            <th scope="col">Prioridad</th>
          </tr>
        </thead>
        <tbody>
            <c:forEach items="${tareas}" var="tarea">
                <tr>
                    <th colspan=""><a href="/tarea/${tarea.id}"><c:out value="${tarea.name}"/></a></th>
                    <td colspan=""><c:out value="${tarea.usuarioCreador.name}"/></td>
                    <td colspan=""><c:out value="${tarea.usuarioAsignado.name}"/></td>
                    <td colspan="">
                        <c:if test="${tarea.prioridad == 3}">
                            <p>Alta</p> 
                        </c:if>
                        <c:if test="${tarea.prioridad == 2}">
                            <p>Media</p> 
                        </c:if>
                        <c:if test="${tarea.prioridad == 1}">
                            <p>Baja</p>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
      </table>

      <a href="/tareaNueva">Crear Tareas</a>
</body>
</html>