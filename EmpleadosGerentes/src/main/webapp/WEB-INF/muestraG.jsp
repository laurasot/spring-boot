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
    <h1>
      El jefe de
      <c:out value="${employee.firstName}"/>
      <c:out value="${employee.lastName}"/>
      es:
    </h1>
    <p>
        <c:out value="${employee.manager.firstName}"/>
        <c:out value="${employee.manager.lastName}"/>
    </p>
  </div>
</body>
</html>