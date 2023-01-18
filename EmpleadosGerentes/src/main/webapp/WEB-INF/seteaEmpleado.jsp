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
        <h3>Empleado</h3>
        <form:form action="/managers/${manager.id}/new" method="post" modelAttribute="employee">
            <p>
                <form:label cssClass="col-sm-2 col-form-label" path="firstName">First Name:</form:label>
                <form:errors path="firstName"/>
                <form:input path="firstName"/>
            </p>

            <p>
                <form:label cssClass="col-sm-2 col-form-label" path="lastName">First Name:</form:label>
                <form:errors path="lastName"/>
                <form:input path="lastName"/>
            </p>
            <input class="btn btn-warning" type="submit" value="Create"/>
        </form:form>
    </div>
</body>
</html>