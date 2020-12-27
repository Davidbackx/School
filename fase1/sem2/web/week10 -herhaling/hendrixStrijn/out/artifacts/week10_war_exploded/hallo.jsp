<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hallo</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="container">
    <jsp:include page="header.jsp">
        <jsp:param name="hallo" value="actual"/>
    </jsp:include>
    <main>
        <c:choose>
            <c:when test="${vreemdelingCookie != null}">
                <h2>Hallo ${vreemdelingCookie}</h2>
                <form method="POST" action="Servlet?command=vergeet">
                    <label for="vergeet"></label> <input id="vergeet" type="submit"
                                                        value="Vergeet mij">
                </form>
            </c:when>
            <c:otherwise>
                <h2>Hallo vreemdeling!</h2>
                <form method="POST" action="Servlet?command=vreemdeling">
                    <fieldset>
                        <legend>Info</legend>
                            <label class="control-label" for="naam">Naam: </label> <input
                            id="naam" name="naam" type="text" required novalidate>
                    </fieldset>
                    <p>
                        <label for="bewaar">&nbsp;</label> <input id="bewaar" type="submit"
                                                                  value="Bewaar">
                    </p>
                </form>
            </c:otherwise>
        </c:choose>
    </main>
</div>

</body>
</html>
