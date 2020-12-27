<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/sample.css">
    <meta charset="UTF-8">
    <title>Verwijder een student</title>
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="actual" value="verwijderBevestiging"/>
</jsp:include>

<main id="container">
    <article>
        <h2>Verwijder deze student</h2>
        <p>Ben je zeker dat je de student ${param.voornaam} ${param.naam} wil verwijderen?</p>
        <form action="StudentInfo?command=verwijderBevestig" method="POST">
            <input type="hidden" name="voornaam" value=${param.voornaam}>
            <input type="hidden" name="naam" value=${param.naam}>

            <input type="submit" value="Zeker" name="submit">
            <input type="submit" value="Toch niet" name="submit">
        </form>
    </article>
</main>
</body>
</html>