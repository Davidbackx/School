<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Overzicht - Games</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="overview"/>
</jsp:include>
<main>
    <h1>Vind een game</h1>
        <table style="width:80%">
                <tr>
                    <th>Developer</th>
                    <th>Naam</th>
                    <th>Soort</th>
                    <c:if test="${requestCookie == true}">
                        <th>Prijs (€)</th>
                    </c:if>
                    <th></th>
                </tr>


            <c:forEach var="game" items="${db}">
                <tr id="${game.naam}">
                    <td>${game.developer}</td>
                    <td>${game.naam}</td>
                    <td>${game.soort}</td>
                    <c:if test="${requestCookie == true}">
                       <td>${game.prijs}</td>
                    </c:if>
                    <td><a href="Servlet?command=remove&developer=${game.developer}&naam=${game.naam}">verwijder</a></td>
                </tr>
            </c:forEach>

        </table>
    <form>
        <p>Toon prijs?</p>
        <p>
            <input type="radio" value="prijsYes" name="command" id="prijsYes">
            <label for="prijsYes">Yes</label>
            <input type="radio" value="prijsNo" name="command" id="prijsNo">
            <label for="prijsNo">No</label>
        </p>
        <p><input type="submit" value="Send" id="submit"></p>
    </form>
</main>
</body>
</html>
