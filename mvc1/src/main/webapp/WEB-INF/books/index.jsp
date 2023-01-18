<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <title>Books</title>
</head>
<body class="container">
    <h1>All Books</h1>
    <table class="border border-dark p-5">
        <thead class="">
            <tr>
                <th>Title</th>
                <th>Description</th>
                <th>Language</th>
                <th>Number of Pages</th>
            </tr>
        </thead>
        <tbody class="p-5">
            <!-- una iteracion para mostrar la lista ordenada, en la primera columna se
            muestra el titulo, en la segundala descripcion, lenguaje y asi suscecivamente  -->
            <c:forEach items="${books}" var="book">
            <tr class="border border-dark">
               <td class="border-end border-dark bg-dark"><a class="text-white" role="button" href="books/show/${book.id}"><c:out value="${book.title}"/></a></td> 
                <td class="border-end border-dark"><c:out value="${book.description}"/></td>
                <td class="border-end border-dark"><c:out value="${book.language}"/></td>
                <td><c:out value="${book.numberOfPages}"/></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="/books/new" class="btn btn-dark mt-3">Nuevo Libro</a>
</body>
</html>
