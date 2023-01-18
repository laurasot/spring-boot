<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Show</title>
</head>
<body class="container row mx-auto">
    <div class="col">
        <h1><c:out value="${book.title}"/></h1>
        <p>Description: <c:out value="${book.description}"/></p>
        <p>Language: <c:out value="${book.language}"/></p>
        <p>Number of pages: <c:out value="${book.numberOfPages}"/></p>
        <div class="d-grid gap-2 col-6 mx-auto">
            <a class="btn btn-dark mb-3" href="/books/${book.id}/edit">Edit Book</a>
            <form action="/books/${book.id}" method="post">
                <input type="hidden" name="_method" value="delete">
                <input class="btn btn-dark" type="submit" value="Delete">
          </div>
       
        </form>   
    </div>

   
</body>
</html>



