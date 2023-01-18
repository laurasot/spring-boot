<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>
    
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="/css/style.css">
    <title>Login</title>
</head>
<body>
    <div class="container text-center">    
        <h1>Login</h1>
        <a href="/registration">registrarse</a>
    </div>
    
    <p><c:out value="${error}" /></p>
    <form method="post" action="/login" class="container form ancho">
        <p class="form-outline ancho">
            <label for="email">Email</label>
            <input class="ancho" type="text" id="email" name="email"/>
        </p>
        <p>
            <label for="password">Password</label>
            <input class="ancho" type="password" id="password" name="password"/>
        </p>
        <input  class="btn btn-dark" type="submit" value="Login!"/>
    </form>    
</body>
</html>