<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>New Book</title>
    <link rel="stylesheet" type="text/css" href="css/new.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="container">    
    <h1>New Book</h1>
    <form:form action="/books" class="form-floating mb-3" method="post" modelAttribute="book">
        <p>
            <form:label class="w-label" path="title">Title</form:label>
            <form:errors path="title"/>
            <form:input class="w-input" path="title"/>
        </p>
        <p>
            <form:label class="w-label" path="description">Description</form:label>
            <form:errors path="description"/>
            <form:textarea path="description"/>
        </p>
        <p>
            <form:label path="language">Language</form:label>
            <form:errors path="language"/>
            <form:input path="language"/>
        </p>
        <p>
            <form:label path="numberOfPages">Pages</form:label>
            <form:errors path="numberOfPages"/>     
            <form:input type="number" path="numberOfPages"/>
        </p>
        <input type="submit" class="btn btn-outline-secondary" value="Submit"/>
    </form:form>    

</body>
</html>
