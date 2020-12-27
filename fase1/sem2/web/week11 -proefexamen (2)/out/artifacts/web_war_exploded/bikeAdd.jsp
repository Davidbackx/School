<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html lang="nl">
<head>
    <meta charset="UTF-8">
    <title>Bikes - view detail</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <link rel="stylesheet" media="all" href="css/reset.css">
    <link rel="stylesheet" media="all" href="css/project.css">
    <link href='https://fonts.googleapis.com/css?family=Roboto' rel='stylesheet' type='text/css'>
</head>

<body>

<header>
    <h1>
        <img src="images/bikesBanner.png" alt="banner My Bikes">
    </h1>

    <jsp:include page="nav.jsp"/>
</header>

<div class="container">
    <main>

        <div class="alert alert-danger">
            <c:if test="${not empty errors}">
                <ul>
                    <c:forEach var="error" items="${errors}">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </div>

        <h2>Voeg je bike toe</h2>
        <!-- Wanneer er een assertTrue fail is kan het zijn dat dit komt door da er bij het toevoegen
        // met een GET methode wordt gewerkt en niet met een POST -->
        <form method="POST" action="Servlet?command=add" novalidate>
            <p>
                <label class="control-label" for="itemId">Id:</label>
                <input id="itemId" name="itemId" type="text" value="${prevItemId}">
            </p>
            <p>
                <label class="control-label" for="brand">Brand:</label>
                <input id="brand" name="brand" type="text" value="${prevBrand}">
            </p>
            <p>
                <label class="control-label" for="category">Category:</label>
                <input id="category" name="category" type="text" value="${prevCategory}">
            </p>
            <p>
                <label class="control-label" for="description">Description:</label>
                <input id="description" name="description" type="text" value="${prevDescription}">
            </p>
            <p>
                <label class="control-label" for="price">Price:</label>
                <input id="price" name="price" type="text" value="${prevPrice}">
            </p>
            <p>
                <input type="submit" value="Voeg bike toe" id="submit">
            </p>
            <p class="left">Alle velden zijn verplicht.</p>
        </form>
    </main>
</div>
</body>
</html>