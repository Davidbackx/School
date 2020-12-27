<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Nieuwe game - Games</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="form"/>
</jsp:include>
<main>
    <c:if test="${not empty errors}">
        <div class="alert alert-danger">
            <ul>
                <c:forEach items="${errors}" var="error">
                    <li>${error}</li>
                </c:forEach>
            </ul>
        </div>
    </c:if>

    <form method="POST" action="Servlet?command=add" novalidate>
        <fieldset>
            <legend><strong>Game</strong></legend>
            <p class="form-group">
                <label class="control-label" for="developer">Developer: </label> <input
                    id="developer" name="developer" type="text" value="${developerPreviousValue}">
            </p>
            <p class="form-group">
                <label class="control-label" for="naam">Naam: </label> <input
                    id="naam" name="naam" type="text" value="${naamPreviousValue}">
            </p>
            <p class="form-group">
                <label class="control-label" for="soort">Soort: </label> <input
                    id="soort" name="soort" type="text" value="${soortPreviousValue}">
            </p>
            <p class="form-group">
                <label class="control-label" for="prijs">Prijs: </label> <input
                    id="prijs" name="prijs" type="text" value="${prijsPreviousValue}">
            </p>
        </fieldset>
        <p>
            <input id="submit" type="submit" value="Voeg toe">
        </p>
    </form>
</main>
</body>
</html>