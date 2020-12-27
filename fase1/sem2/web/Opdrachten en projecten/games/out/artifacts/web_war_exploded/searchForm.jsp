<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Dev info - Games</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="searchForm"/>
    </jsp:include>
    <main>
        <form method="GET" action="Servlet?command=search" novalidate>
            <input type="hidden" name="command" value="search"/>
            <fieldset>
                <legend><strong>Game</strong></legend>
                <p class="form-group">
                    <label class="control-label" for="developer">Vind games van developer: </label> <input
                        id="developer" name="developer" type="text"  required novalidate>
            </fieldset>
            <p>
                <input type="submit" value="Zoek">
            </p>
        </form>
</main>
</body>
</html>
