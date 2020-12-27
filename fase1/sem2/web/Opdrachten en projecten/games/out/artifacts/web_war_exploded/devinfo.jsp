<%@page import="java.util.Collection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Def info - Games</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="devinfo"/>
</jsp:include>
<main>
    <c:choose>
        <c:when test="${db == null}">
            <h1>Developer does not exist!</h1>
        </c:when>
        <c:otherwise>
            <h1>${dev}</h1>
            <table style="width:80%">
                <tr>
                    <th>Naam</th>
                    <th>Soort</th>
                    <th>Prijs (€)</th>

                </tr>

                <c:forEach var="game" items="${db}">
                    <tr id="${game.naam}">
                        <td>${game.naam}</td>
                        <td>${game.soort}</td>
                        <td>${game.prijs}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</main>
</body>
</html>
