<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" integrity="undefined" crossorigin="anonymous">
  <title>Title</title>
</head>
<body>
    <div class="container">

        <h1> Los subordinados de <c:out value="${gerente.firstName}"/> <c:out value="${gerente.lastName}"/> son:</h1>
        <ul>
          <c:forEach  items="${gerente.employees}" var="empleado">
              <li>
                <c:out value="${empleado.firstName}"/>
                <c:out value="${empleado.lastName}"/>
              </li>
          </c:forEach>
        </ul>
    </div>
    <a href="/gerentes/${gerente.id}/new">agregar empleado a este gerente</a>
</body>
</html>